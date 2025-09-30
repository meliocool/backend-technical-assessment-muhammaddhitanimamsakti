package com.dhitan.entity.dto;

import lombok.Data;
import java.util.List;

@Data
public class ViewDataResponseDto {
    private List<TransactionDto> data;
    private List<StatusDto> status;
}
