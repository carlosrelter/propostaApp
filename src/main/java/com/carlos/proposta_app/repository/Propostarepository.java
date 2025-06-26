package com.carlos.proposta_app.repository;

import com.carlos.proposta_app.entity.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Propostarepository extends JpaRepository<Proposta,Long> {
}
