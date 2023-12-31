package br.com.sicredi.apiassembleia.repository;

import br.com.sicredi.apiassembleia.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
