package com.desafio.docket.service;

import com.desafio.docket.dto.CartorioCadastroDTO;
import com.desafio.docket.dto.CartorioDTO;
import com.desafio.docket.mapper.CartorioMapper;
import com.desafio.docket.model.Cartorio;
import com.desafio.docket.repository.CartorioRepository;
import com.desafio.docket.repository.CertidaoRepository;
import com.desafio.docket.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartorioService {

    @Autowired
    private CartorioMapper cartorioMapper;

    @Autowired
    private CertidaoRepository certidaoRepository;

    @Autowired
    private CartorioRepository cartorioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public CartorioDTO prepararESalvarCartorio (CartorioCadastroDTO cartorioCadastroDTO) {
        return salvarCartorio(cartorioMapper.converterParaCartorioDTO(cartorioCadastroDTO));
    }

    public CartorioDTO salvarCartorio (CartorioDTO cartorioDTO) {
        Cartorio cartorio = cartorioMapper.converterParaCartorio(cartorioDTO);
        cartorio.setEndereco(enderecoRepository.save(cartorio.getEndereco()));
        cartorio.setListaCertidoes(new HashSet<>(certidaoRepository.findAll()));

        return cartorioMapper.converterParaCartorioDTO(cartorioRepository.save(cartorio));
    }

    public void deletarCartorio (Integer idCartorio) {
        Optional<Cartorio> cartorio = cartorioRepository.findById(idCartorio);
        cartorioRepository.deleteById(idCartorio);
        enderecoRepository.delete(cartorio.get().getEndereco());

    }

    public CartorioDTO buscarCartorio (Integer idCartorio) {
        return cartorioMapper.converterParaCartorioDTO(cartorioRepository.findById(idCartorio).orElse(null));
    }

    public List<CartorioDTO> buscarTodosCartorios () {
        return cartorioRepository.findAll().stream().map(cartorio -> cartorioMapper.converterParaCartorioDTO(cartorio)).collect(Collectors.toList());
    }


}
