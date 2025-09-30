package com.dhitan.entity.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Integer id;
    private String productID;
    private String productName;
    private String amount;
    private String customerName;
    private Integer status;
    private LocalDateTime transactionDate;
    private String createBy;
    private LocalDateTime createOn;
}
