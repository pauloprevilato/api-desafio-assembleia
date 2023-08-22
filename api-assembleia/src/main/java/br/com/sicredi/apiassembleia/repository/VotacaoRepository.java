package br.com.sicredi.apiassembleia.repository;

import br.com.sicredi.apiassembleia.domain.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}
