package com.example.Mybank.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Customizexception.ResponseWrapper;
import com.example.Mybank.dto.Transaction;

import lombok.Data;

@Service
@Data
public class TransactionService {
    private final Transaction transactionRepository;

    ArrayList<Transaction> transaction = new ArrayList<>();

    public TransactionService(Transaction transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {

        return transaction;
    }

    public ResponseWrapper<Transaction> CreateTransaction(Transaction trs) {
        transaction.add(trs);
        return new ResponseWrapper<>(null, trs);
    }

    public Transaction getTransaction(Long id) {

        return transaction.stream()
                .filter(trs -> trs.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Transaction updateTrans(Long id) {
        Transaction updated = null;

        for (Transaction trs : transaction) {
            if (trs.getId().equals(id)) {
                trs.setTransactiontype("transaction_updated");
                updated = trs;
                break;
            }
        }

        return updated;
    }

    public Transaction deleteTrans(Long id) {
        Transaction deleted = null;

        for (Transaction trs : transaction) {
            if (trs.getId().equals(id)) {
                deleted = trs;
                transaction.remove(trs);
                break;
            }
        }

        return deleted;
    }

}
