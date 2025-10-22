import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/transactions")
@NoArgsConstructor
public class TransactionController {

//     1. (GET - "/api/transactions”) - Get All Transaction history.

// 2. (GET - "/api/transactions/{id}”) - Get a specific Transaction.

// 3. (PUT - "/api/transactions/{id}”) - Update a specific Transaction.

// 4. (DELETE - "/api/transactions/{id}”) - Delete a specific Transaction.

// 5. (POST - "/api/transactions") - Add a new transaction.
final TransactionService transactionService;
public  ResponseEntity<List<Transaction>> getAllTransactions() {


    List<Transaction> transactions = transactionService.getAllTransactions();

    return ResponseEntity<>(transactions, HttpStatus.OK);

}
