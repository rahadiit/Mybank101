package com.example.Mybank.dto;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class Transaction {

    Long id;
    String transactiontype;

}
