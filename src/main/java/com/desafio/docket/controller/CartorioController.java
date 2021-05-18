package com.desafio.docket.controller;

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


    @GetMapping
    @ApiOperation(value = "Search all peoples or search by term", nickname = "searchPeople", notes = "Search all peoples")
    public ResponseEntity<List<CartorioDTO>> buscarTodosCartorios() {
        return new ResponseEntity<>(cartorioService.buscarTodosCartorios(), HttpStatus.OK);
    }

    @GetMapping("/{idCartorio}")
    public ResponseEntity<CartorioDTO> buscaCartorio(@PathVariable Integer idCartorio) {
        return new ResponseEntity<>(cartorioService.buscarCartorio(idCartorio), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartorioDTO> salvarCartorio(@RequestBody CartorioDTO cartorioDTO) {
        return new ResponseEntity<>(cartorioService.salvarCartorio(cartorioDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CartorioDTO> alterarCartorio(@RequestBody CartorioDTO cartorioDTO) {
        return new ResponseEntity<>(cartorioService.salvarCartorio(cartorioDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idCartorio}")
    public ResponseEntity<?> deletarCartorio(@PathVariable Integer idCartorio) {
        cartorioService.deletarCartorio(idCartorio);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
