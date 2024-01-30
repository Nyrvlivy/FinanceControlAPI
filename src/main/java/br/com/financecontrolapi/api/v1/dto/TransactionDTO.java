package br.com.financecontrolapi.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDTO {

    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "date")
    private LocalDate date;
    @JsonProperty(value = "value")
    private BigDecimal value;
    @JsonProperty(value = "category")
    private String category;
}
