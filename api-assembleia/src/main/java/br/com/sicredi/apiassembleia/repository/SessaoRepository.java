package br.com.sicredi.apiassembleia.repository;

import br.com.sicredi.apiassembleia.domain.entity.Sessao;
import br.com.sicredi.apiassembleia.dto.SessaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    @Query(value = "SELECT NEW br.com.sicredi.apiassembleia.dto.SessaoDTO(" //
            + "sessao.id, sessao.numero," //
            + "sessao.data, sessao.tempo, sessao.titulo, pauta.id, pauta.pautaNumero, pauta.pautaDescricao) "//
            + "FROM Sessao sessao " //
            + "LEFT JOIN sessao.pauta pauta " //
            + "WHERE 1 = 1 " //
            + "AND (:titulo IS NULL OR UPPER(sessao.titulo) LIKE %:titulo%) " //
            )
    Page<SessaoDTO> findPagableSessaoByFiltro(@Param("titulo") final String titulo, Pageable pageable);
}
