package com.ushan.controller;

import com.ushan.dto.ExportDto;
import com.ushan.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ExportController {

    @Autowired
    ExcelService excelService;

    @GetMapping(value = "/startAsync")
    ResponseEntity<String> startExportReport(){
        String id = UUID.randomUUID().toString();
        excelService.createExcelSheet(id);

        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/progress")
    public ResponseEntity<ExportDto> getProgressPercentageByExportId(@RequestParam String exportId) {
        return new ResponseEntity<>(excelService.getPercentByExportUniqueId(exportId), HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> exportByExportId(@RequestParam String exportId) throws IOException {
        byte[] byteArray = excelService.getWorkbookByExportUniqueId(exportId);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        excelService.deleteExportProgress(exportId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Cars.xlsx");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));
    }
}
