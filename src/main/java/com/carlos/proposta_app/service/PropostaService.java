package com.carlos.proposta_app.service;

import com.carlos.proposta_app.dto.PropostaRequestDto;
import com.carlos.proposta_app.dto.PropostaResponseDto;
import com.carlos.proposta_app.entity.Proposta;
import com.carlos.proposta_app.mapper.PropostaMapper;
import com.carlos.proposta_app.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostarepository;

    @Autowired
    private NotificacaoRabbitService notificacaoService;

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    public PropostaResponseDto criar(PropostaRequestDto requestDto){
        Proposta proposta =  PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);
        propostarepository.save(proposta);

        notificarRabbitMQ(proposta);
        return PropostaMapper.INSTANCE.convertentityToDto(proposta);
    }

    private void notificarRabbitMQ(Proposta proposta){
        try{
            notificacaoService.notificar(proposta, exchange);
        }catch(RuntimeException ex){
            proposta.setIntegrada(false);
            propostarepository.save(proposta);
        }
    }

    public List<PropostaResponseDto> obterProposta() {
       return PropostaMapper.INSTANCE.convertListEntityToListDto(propostarepository.findAll());
    }
}
