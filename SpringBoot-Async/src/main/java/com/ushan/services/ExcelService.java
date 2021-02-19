package com.ushan.services;

import com.ushan.dto.ExportDto;
import com.ushan.model.Car;
import com.ushan.model.ExportProgressEntity;
import com.ushan.repository.CarRepository;
import com.ushan.repository.ExportProgressRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ExcelService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ExportProgressRepository exportProgressRepository;

    static String[] headers = {"Id","Name","Type"};

    @Async("asyncExecutor")
    public void createExcelSheet(String id){
        saveProgress(id, 10, "Query Execution is in-progress.","Cars.xlsx",false,null);
        List<Car> cars = carRepository.findAll();
        saveProgress(id, 50, "Query Execution is completed.","Cars.xlsx",false,null);
        Workbook workbook = null;
        try {
            workbook = constructExcel(cars,id,"Cars.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Workbook constructExcel(List<Car> cars,String exportId,String fileName) throws IOException {
        int percent = 0;
        XSSFWorkbook workbook = null;
        try{
            workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("CARS");

            Row headerRow = sheet.createRow(0);
            for(int col=0;col<headers.length;col++){
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(headers[col]);
            }

            int rowIndex=1;
            int i =1;
            for (Car car : cars){
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(car.getId());
                row.createCell(1).setCellValue(car.getName());
                row.createCell(2).setCellValue(car.getType());
                percent = i * 50 / cars.size();
                TimeUnit.SECONDS.sleep(5);
                saveProgress(exportId, percent + 50,
                        "Export Sheet Generation is in-progress", fileName, false, null);
                i++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        saveProgress(exportId, 100, "Export sheet is completed.","Cars.xlsx",false,workbook);
        return workbook;
    }

    private void saveProgress(String exportId, Integer progressPercentage, String message,String fileName, boolean exception,Workbook workbook) {
        ExportProgressEntity exportProgressEntity = exportProgressRepository.findByExportId(exportId);
        exportProgressEntity = exportProgressEntity != null ? exportProgressEntity : new ExportProgressEntity();
        exportProgressEntity.setExportId(exportId);
        exportProgressEntity.setProgressPercentage(progressPercentage);
        exportProgressEntity.setMessage(message);
        exportProgressEntity.setFileName(fileName);
        exportProgressEntity.setException(exception);
        if (workbook != null) {
            byte[] bytes = null;
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                workbook.write(bos);
                bytes = bos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exportProgressEntity.setWorkbook(bytes);
        }
        exportProgressRepository.save(exportProgressEntity);
    }

    public ExportDto getPercentByExportUniqueId(String exportUniqueId) {
        ExportProgressEntity exportProgressEntity = exportProgressRepository.findByExportId(exportUniqueId);
        return new ExportDto(exportUniqueId, exportProgressEntity.getProgressPercentage(),
                exportProgressEntity.getMessage(), exportProgressEntity.getFileName(),
                exportProgressEntity.isException());
    }

    public byte[] getWorkbookByExportUniqueId(String exportUniqueId) {
        ExportProgressEntity exportProgressEntity = exportProgressRepository.findByExportId(exportUniqueId);
        return exportProgressEntity != null ? exportProgressEntity.getWorkbook() : null;
    }

    public void deleteExportProgress(String id) {
        exportProgressRepository.deleteByExportId(id);
    }
}
