package br.com.financecontrolapi.api.v1.controller;

import br.com.financecontrolapi.api.v1.dto.TransactionDTO;
import br.com.financecontrolapi.api.v1.dto.TransactionListDTO;
import br.com.financecontrolapi.api.v1.mapper.TransactionMapper;
import br.com.financecontrolapi.business.services.TransactionService;
import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Find all transactions", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search operation successful"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAllTransactions() {
        List<TransactionEntity> transactions = transactionService.findAllTransactions();

        List<TransactionDTO> dtos = transactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Save new transactions", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save transactions operation successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @CrossOrigin
    @PostMapping
    public ResponseEntity<List<TransactionDTO>> createTransactions(@RequestBody TransactionListDTO transactionListDTO) {
        List<TransactionEntity> transactionEntities = transactionListDTO.getTransactions().stream()
                .map(transactionMapper::toEntity)
                .collect(Collectors.toList());

        List<TransactionEntity> createdTransactions = transactionService.createMultiTransactions(transactionEntities);

        List<TransactionDTO> dtos = createdTransactions.stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Update transactions", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update transaction operation successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Transaction not found"),
            @ApiResponse(responseCode = "422", description = "Invalid request data."),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Integer id, @RequestBody TransactionDTO transactionDTO) {
        TransactionEntity transaction = transactionService.findById(id);

        transaction.setDate(transactionDTO.getDate());
        transaction.setValue(transactionDTO.getValue());
        transaction.setCategory(transactionDTO.getCategory());

        TransactionEntity updatedTransaction = transactionService.save(transaction);
        TransactionDTO dto = transactionMapper.toDto(updatedTransaction);

        return ResponseEntity.ok(dto);
    }

}
