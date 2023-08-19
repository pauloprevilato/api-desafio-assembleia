package br.com.sicredi.apiassembleia.repository;

import br.com.sicredi.apiassembleia.domain.entity.Pauta;
import br.com.sicredi.apiassembleia.dto.PautaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

    @Query(value = "SELECT NEW br.com.sicredi.apiassembleia.dto.PautaDTO(" //
            + "pauta.id, pauta.pautaNumero, pauta.pautaDescricao) "//
            + "FROM Pauta pauta " //
          )
    Page<PautaDTO> findAllPagable(Pageable pageable);
}
