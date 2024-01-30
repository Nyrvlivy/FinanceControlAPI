package br.com.financecontrolapi.business.services;

import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import br.com.financecontrolapi.infrastructure.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionEntity findById(Integer id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found"));
    }

    public List<TransactionEntity> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionEntity createTransaction(TransactionEntity entity) {
        return transactionRepository.save(entity);
    }

    public List<TransactionEntity> createMultiTransactions(List<TransactionEntity> entities) {
        return transactionRepository.saveAll(entities);
    }

    public TransactionEntity save(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }


}
