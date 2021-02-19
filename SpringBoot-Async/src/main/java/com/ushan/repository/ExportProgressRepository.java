package com.ushan.repository;

import com.ushan.model.ExportProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ExportProgressRepository extends JpaRepository<ExportProgressEntity, Long> {
    ExportProgressEntity findByExportId(String exportId);
    void deleteByExportId(String exportId);
}