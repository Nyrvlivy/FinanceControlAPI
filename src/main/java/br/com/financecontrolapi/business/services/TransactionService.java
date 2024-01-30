package br.com.financecontrolapi.business.services;

import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import br.com.financecontrolapi.infrastructure.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionEntity> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionEntity createTransaction(TransactionEntity entity) {
        return transactionRepository.save(entity);
    }

    public List<TransactionEntity> createMultiTransactions(List<TransactionEntity> entities) {
        return transactionRepository.saveAll(entities);
    }


}
