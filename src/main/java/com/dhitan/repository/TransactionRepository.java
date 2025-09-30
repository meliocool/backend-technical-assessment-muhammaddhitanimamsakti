package com.dhitan.repository;

import com.dhitan.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    String SQL_QUERY = """
        SELECT t.id, t.amount, t.status, t.transaction_date, t.create_by, t.create_on, t.product_id, p.product_name, t.customer_name
        FROM transactions t
        JOIN products p ON t.product_id = p.product_id
        ORDER BY t.id
    """;
    @Query(value = SQL_QUERY, nativeQuery = true)
    List<Object[]> findAllTransactions();
}
