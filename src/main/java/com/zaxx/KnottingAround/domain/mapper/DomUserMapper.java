package com.zaxx.KnottingAround.domain.mapper;

import com.zaxx.KnottingAround.domain.dto.userDto.UserShowDto;
import com.zaxx.KnottingAround.persistence.entity.UserEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomUserMapper {
    UserShowDto toUserShowDto(UserEntity userEntity);
    List<UserShowDto> toUserShowDtoS(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target= "password",ignore = true),
            @Mapping(target= "locked",ignore = true),
            @Mapping(target= "disabled",ignore = true),
            @Mapping(target= "roles",ignore = true)
    })
    UserEntity toUserEntity(UserShowDto userShowDto);
    List<UserEntity> toUserEntities(List<UserShowDto> userShowDtos);
}
