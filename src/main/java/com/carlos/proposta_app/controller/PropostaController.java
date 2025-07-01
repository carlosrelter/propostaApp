package com.carlos.proposta_app.controller;

import com.carlos.proposta_app.dto.PropostaRequestDto;
import com.carlos.proposta_app.dto.PropostaResponseDto;
import com.carlos.proposta_app.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity criar(@RequestBody PropostaRequestDto requestDto){
        PropostaResponseDto responseDto = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseDto.getId())
                .toUri()).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterPropostas(){
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
