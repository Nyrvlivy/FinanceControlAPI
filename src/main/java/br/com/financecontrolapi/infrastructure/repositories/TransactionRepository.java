package br.com.financecontrolapi.infrastructure.repositories;

import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    List<TransactionEntity> findByDate(LocalDate date);

    List<TransactionEntity> findByCategory(String category);

    List<TransactionEntity> findByDateAndCategory(LocalDate date, String category);
}

