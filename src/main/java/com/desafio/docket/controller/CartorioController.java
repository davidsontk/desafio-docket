package com.desafio.docket.controller;

import com.desafio.docket.dto.CartorioCadastroDTO;
import com.desafio.docket.dto.CartorioDTO;
import com.desafio.docket.service.CartorioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartorio")
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;

    @ApiOperation(
            value="Buscar todos Cartorios",
            notes="Busca todos os cartorios cadastrados",
            response=CartorioDTO.class
    )
    @GetMapping
    public ResponseEntity<List<CartorioDTO>> buscarTodosCartorios() {
        return new ResponseEntity<>(cartorioService.buscarTodosCartorios(), HttpStatus.OK);
    }

    @ApiOperation(
            value="Busca cartorio",
            notes="Busca pelo seu id",
            response=CartorioDTO.class
    )
    @GetMapping("/{idCartorio}")
    public ResponseEntity<CartorioDTO> buscaCartorio(@PathVariable Integer idCartorio) {
        return new ResponseEntity<>(cartorioService.buscarCartorio(idCartorio), HttpStatus.OK);
    }

    @ApiOperation(
            value="Salvar Cartorio",
            notes="Salvar um cartorio",
            response=CartorioDTO.class
    )
    @PostMapping
    public ResponseEntity<CartorioDTO> salvarCartorio(@RequestBody CartorioCadastroDTO cartorioCadastroDTO) {
        return new ResponseEntity<>(cartorioService.prepararESalvarCartorio(cartorioCadastroDTO), HttpStatus.CREATED);
    }

    @ApiOperation(
            value="Alterar Cartorio",
            notes="Altera um cartorio",
            response=CartorioDTO.class
    )
    @PutMapping
    public ResponseEntity<CartorioDTO> alterarCartorio(@RequestBody CartorioDTO cartorioDTO) {
        return new ResponseEntity<>(cartorioService.salvarCartorio(cartorioDTO), HttpStatus.CREATED);
    }

    @ApiOperation(
            value="Deletar Cartorio",
            notes="Deletar um cartorio pelo seu id",
            response=CartorioDTO.class
    )
    @DeleteMapping("/{idCartorio}")
    public ResponseEntity<?> deletarCartorio(@PathVariable Integer idCartorio) {
        cartorioService.deletarCartorio(idCartorio);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
