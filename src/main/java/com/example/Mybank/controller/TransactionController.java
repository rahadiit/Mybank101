package com.example.Mybank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customizexception.ResponseWrapper;
import com.example.Mybank.dto.Transaction;
import com.example.Mybank.services.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/getall")
    public ResponseEntity<List<Transaction>> getAllTransactions() {

        List<Transaction> transactions = transactionService.getAllTransactions();

        return new ResponseEntity<>(transactions, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Transaction> CreateTransaction(@RequestBody Transaction trs) {

        ResponseWrapper<Transaction> savetrans = transactionService.CreateTransaction(trs);
        if (savetrans.getMessage() != null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<>(savetrans.getData(), HttpStatus.CREATED);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id) {

        Transaction transaction = transactionService.getTransaction(id);
        if (transaction == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Transaction> UpdateTransaction(@PathVariable Long id) {

        Transaction transaction = transactionService.updateTrans(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Transaction> DeleteTransaction(@PathVariable Long id) {

        Transaction transaction = transactionService.deleteTrans(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }

}