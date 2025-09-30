package com.dhitan.controller;


import com.dhitan.entity.dto.ViewDataResponseDto;
import com.dhitan.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viewAllTransactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ViewDataResponseDto getAllData() {
        return transactionService.getAllData();
    }
}
