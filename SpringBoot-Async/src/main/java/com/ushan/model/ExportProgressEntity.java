package com.ushan.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = ExportProgressEntity.TABLE_NAME)
public class ExportProgressEntity implements Serializable {
    protected static final String TABLE_NAME = "export_progress";
    private static final long serialVersionUID = -7883570276965234427L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "export_id", unique = true, nullable = false)
    private String exportId;
    @Column(name = "progress_percentage")
    private Integer progressPercentage;
    @Column(name = "message")
    private String message;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "exception")
    private boolean exception;
    @Lob
    @Column(name = "workbook")
    private byte[] workbook;

}