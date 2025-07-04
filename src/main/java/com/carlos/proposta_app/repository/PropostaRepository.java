package com.carlos.proposta_app.repository;

import com.carlos.proposta_app.entity.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {

    List<Proposta> findAllByIntegradaIsFalse();
}
