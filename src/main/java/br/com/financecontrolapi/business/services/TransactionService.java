package br.com.financecontrolapi.business.services;

import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import br.com.financecontrolapi.infrastructure.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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

    public List<TransactionEntity> filterByDate(LocalDate date) {
        return transactionRepository.findByDate(date);
    }

    public List<TransactionEntity> filterByDateAndCategory(LocalDate date, String category) {
        if (category == null || category.isEmpty()) {
            return transactionRepository.findByDate(date);
        }
        return transactionRepository.findByDateAndCategory(date, category);
    }

    public List<TransactionEntity> filterByCategory(String category) {
        return transactionRepository.findByCategory(category);
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

    public void deleteById(Integer id) {
        transactionRepository.deleteById(id);
    }

    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }
}
