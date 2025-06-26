package com.carlos.proposta_app.controller;

import com.carlos.proposta_app.dto.PropostaRequestDto;
import com.carlos.proposta_app.dto.PropostaResponseDto;
import com.carlos.proposta_app.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity criar(@RequestBody PropostaRequestDto requestDto){
        PropostaResponseDto responseDto = propostaService.criar(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
