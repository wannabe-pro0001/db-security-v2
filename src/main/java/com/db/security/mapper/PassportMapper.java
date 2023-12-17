package com.db.security.mapper;

import com.db.security.model.PassportEntity;
import com.db.security.response.PassportResponse;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    PassportResponse toResponse(PassportEntity entity);
}
