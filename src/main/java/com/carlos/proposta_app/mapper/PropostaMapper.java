package com.carlos.proposta_app.mapper;

import com.carlos.proposta_app.dto.PropostaRequestDto;
import com.carlos.proposta_app.dto.PropostaResponseDto;
import com.carlos.proposta_app.entity.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target = "usuario.nome", source ="nome")
    @Mapping(target = "usuario.sobreNome", source ="sobreNome")
    @Mapping(target = "usuario.cpf", source ="cpf")
    @Mapping(target = "usuario.telefone", source ="telefone")
    @Mapping(target = "usuario.renda", source ="renda")
    @Mapping(target = "id", ignore = true )
    @Mapping(target = "aprovada", ignore = true)
    @Mapping(target = "integrada", constant = "true")
    @Mapping(target = "observacao", ignore= true)
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);

    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "sobreNome", source = "usuario.sobreNome")
    @Mapping(target = "telefone", source = "usuario.telefone")
    @Mapping(target = "cpf", source = "usuario.cpf")
    @Mapping(target = "renda", source = "usuario.renda")
    @Mapping(target = "valorSolicitadoFmt", expression = "java(setValorSolicitadoFmt(proposta))")
    PropostaResponseDto convertentityToDto(Proposta proposta);

    List<PropostaResponseDto> convertListEntityToListDto(Iterable<Proposta> propostas);

    default String setValorSolicitadoFmt(Proposta proposta){
        return NumberFormat.getCurrencyInstance().format(proposta.getValorSolicitado());
    }
}
