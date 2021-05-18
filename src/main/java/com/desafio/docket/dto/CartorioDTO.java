package com.desafio.docket.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartorioDTO {

    private Integer id;
    private String nome;
    private List<CertidaoDTO> listaCertidoes;
    private EnderecoDTO endereco;

}
