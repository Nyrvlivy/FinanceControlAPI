package br.com.financecontrolapi.api.v1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionListDTO {
    private List<TransactionDTO> transactions;
}
