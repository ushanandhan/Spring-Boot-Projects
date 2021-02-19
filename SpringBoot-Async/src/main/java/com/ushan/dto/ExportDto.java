package com.ushan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ExportDto implements Serializable {
    private static final long serialVersionUID = -9149289684584143734L;
    private String exportId;
    private Integer progress;
    private String message;
    private String fileName;
    private boolean exception;
}