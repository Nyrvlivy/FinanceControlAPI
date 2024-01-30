package br.com.financecontrolapi.api.v1.mapper;

import br.com.financecontrolapi.api.v1.dto.TransactionDTO;
import br.com.financecontrolapi.infrastructure.entities.TransactionEntity;
import org.springframework.stereotype.Component;

//@Component
//public class TransactionMapper {
//
////    public TransactionEntity toEntity(TransactionDTO dto) {
////        TransactionEntity entity = new TransactionEntity();
////        entity.setDate(dto.getDate());
////        entity.setValue(dto.getValue());
////        entity.setCategory(dto.getCategory());
////        return entity;
////    }
//
////    public TransactionDTO toDTO(TransactionEntity entity) {
////        TransactionDTO dto = new TransactionDTO();
////        dto.setId(entity.getId());
////        dto.setDate(entity.getDate());
////        dto.setValue(entity.getValue());
////        dto.setCategory(entity.getCategory());
////        return dto;
////    }
//
//    public TransactionEntity toEntity(TransactionDTO dto) {
//        return TransactionEntity.builder()
//                .date(dto.getDate())
//                .value(dto.getValue())
//                .category(dto.getCategory())
//                .build();
//    }
//
//    public TransactionDTO toDTO(TransactionEntity entity) {
//        return TransactionDTO.builder()
//                .id(entity.getId())
//                .date(entity.getDate())
//                .value(entity.getValue())
//                .category(entity.getCategory())
//                .build();
//    }
//
//}
@Component
public class TransactionMapper {

    public TransactionEntity toEntity(TransactionDTO dto) {
        TransactionEntity entity = new TransactionEntity();
        entity.setDate(dto.getDate());
        entity.setValue(dto.getValue());
        entity.setCategory(dto.getCategory());
        return entity;
    }

    public TransactionDTO toDto(TransactionEntity entity) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setValue(entity.getValue());
        dto.setCategory(entity.getCategory());
        return dto;
    }
}