import java.util.List;


import org.springframework.stereotype.Component;

import lombok.Data;
import DTO.Transaction;


@Component
@Data
public class TransactionService {
private final Transaction transactionRepository;

    public TransactionService(Transaction transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<Transaction> getAllTransactions() {
        // Dummy implementation for illustration
        return List.of(new Transaction());
    }
}

