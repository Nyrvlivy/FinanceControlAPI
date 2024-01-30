package br.com.financecontrolapi.api.v1.controller;

import br.com.financecontrolapi.api.v1.dto.TransactionDTO;
import br.com.financecontrolapi.api.v1.dto.TransactionListDTO;
import br.com.financecontrolapi.api.v1.mapper.TransactionMapper;
import br.com.financecontrolapi.business.services.TransactionService;
import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@Tag(name = "Transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAllTransactions() {
        List<TransactionEntity> transactions = transactionService.findAllTransactions();

        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(transactionDTOs);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<List<TransactionDTO>> createTransactions(@RequestBody TransactionListDTO transactionListDTO) {
        List<TransactionEntity> transactionEntities = transactionListDTO.getTransactions().stream()
                .map(transactionMapper::toEntity)
                .collect(Collectors.toList());

        List<TransactionEntity> createdTransactions = transactionService.createMultiTransactions(transactionEntities);

        List<TransactionDTO> createdTransactionDTOs = createdTransactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(createdTransactionDTOs);
    }
}
