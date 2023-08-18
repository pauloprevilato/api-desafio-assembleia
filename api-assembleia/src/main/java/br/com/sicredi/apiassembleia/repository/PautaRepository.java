package br.com.sicredi.apiassembleia.repository;

import br.com.sicredi.apiassembleia.domain.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
