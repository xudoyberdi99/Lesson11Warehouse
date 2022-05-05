package com.company.warehouse.payload;

import lombok.Data;

import java.sql.Date;

@Data
public class InputProductDto {
    private Integer productId;
    private Double amount;
    private Double price;
    private Date expireDate;
    private Integer inputId;
}
