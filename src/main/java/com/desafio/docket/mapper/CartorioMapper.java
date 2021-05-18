package com.desafio.docket.mapper;

import com.desafio.docket.dto.CartorioDTO;
import com.desafio.docket.model.Cartorio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartorioMapper {

    Cartorio converterParaCartorio(CartorioDTO cartorioDTO);

    CartorioDTO converterParaCartorioDTO(Cartorio cartorio);
}
