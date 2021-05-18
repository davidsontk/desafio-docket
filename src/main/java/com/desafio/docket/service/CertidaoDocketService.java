package com.desafio.docket.service;

import com.desafio.docket.dto.CertidaoDTO;
import com.desafio.docket.mapper.CertidaoMapper;
import com.desafio.docket.model.Certidao;
import com.desafio.docket.repository.CertidaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CertidaoDocketService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CertidaoMapper certidaoMapper;

    @Autowired
    private CertidaoRepository certidaoRepository;

    public Set<Certidao> buscaCertidoesDocket() {
        ResponseEntity<CertidaoDTO[]> entity = restTemplate.getForEntity("https://docketdesafiobackend.herokuapp.com/api/v1/certidoes", CertidaoDTO[].class);
        if (entity.getBody() != null) {
            return Arrays.stream(entity.getBody()).map(certidao -> certidaoMapper.converteParaCertidao(certidao)).collect(Collectors.toSet());
        }
        return new HashSet<>();
    }

    public void salvaCertidoesDocket() {
        ResponseEntity<CertidaoDTO[]> entity = restTemplate.getForEntity("https://docketdesafiobackend.herokuapp.com/api/v1/certidoes", CertidaoDTO[].class);
        if (entity.getBody() != null) {
            certidaoRepository.saveAll(Arrays.stream(entity.getBody()).map(certidao -> certidaoMapper.converteParaCertidao(certidao)).collect(Collectors.toList()));
        }
    }

}
