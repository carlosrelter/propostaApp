package com.carlos.proposta_app.service;

import com.carlos.proposta_app.dto.PropostaRequestDto;
import com.carlos.proposta_app.dto.PropostaResponseDto;
import com.carlos.proposta_app.entity.Proposta;
import com.carlos.proposta_app.mapper.PropostaMapper;
import com.carlos.proposta_app.repository.Propostarepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaService {

    @Autowired
    private Propostarepository propostarepository;

    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta =  PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostarepository.save(proposta);
        return PropostaMapper.INSTANCE.convertentityToDto(proposta);
    }
}
