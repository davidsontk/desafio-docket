package com.desafio.docket.mapper;

import com.desafio.docket.dto.CertidaoDTO;
import com.desafio.docket.model.Certidao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertidaoMapper {

    Certidao converteParaCertidao(CertidaoDTO certidaoDTO);
}
