package com.dhitan.service;

import com.dhitan.entity.dto.TransactionDto;
import com.dhitan.entity.dto.ViewDataResponseDto;
import com.dhitan.repository.TransactionRepository;
import com.dhitan.entity.dto.StatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public ViewDataResponseDto getAllData() {
        List<Object[]> rawTransactions = transactionRepository.findAllTransactions();
        List<TransactionDto> transactionData = rawTransactions.stream().map(this::mapToObject).collect(Collectors.toList());
        List<StatusDto> statusData = List.of(
                createStatus(0, "SUCCESS"),
                createStatus(1, "FAILED")
        );

        ViewDataResponseDto response = new ViewDataResponseDto();
        response.setData(transactionData);
        response.setStatus(statusData);

        return response;
    }

    private TransactionDto mapToObject(Object[] row) {
        TransactionDto dto = new TransactionDto();
        if (row[0] != null) dto.setId((Integer) row[0]);
        if (row[1] != null) dto.setAmount((String) row[1]);
        if (row[2] != null) dto.setStatus((Integer) row[2]);
        if (row[3] instanceof Timestamp) {
            dto.setTransactionDate(((Timestamp) row[3]).toLocalDateTime());
        }
        if (row[4] != null) dto.setCreateBy((String) row[4]);
        if (row[5] instanceof Timestamp) {
            dto.setCreateOn(((Timestamp) row[5]).toLocalDateTime());
        }
        if (row[6] != null) dto.setProductID((String) row[6]);
        if (row[7] != null) dto.setProductName((String) row[7]);
        if (row[8] != null) dto.setCustomerName((String) row[8]);

        return dto;
    }

    private StatusDto createStatus(int id, String name) {
        StatusDto status = new StatusDto();
        status.setId(id);
        status.setName(name);
        return status;
    }
}
