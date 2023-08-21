package br.com.sicredi.apiassembleia.repository;

import br.com.sicredi.apiassembleia.domain.entity.Associado;
import br.com.sicredi.apiassembleia.dto.AssociadoDTO;
import br.com.sicredi.apiassembleia.dto.PautaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    @Query(value = "SELECT NEW br.com.sicredi.apiassembleia.dto.AssociadoDTO(" //
            + "associado.id, pessoa.id, pessoa.cpfCnpj, pessoa.nomeRazaoSocial) "//
            + "FROM Associado associado " //
            + "LEFT JOIN associado.pessoa pessoa " //
    )
    Page<AssociadoDTO> findAllPagable(Pageable pageable);
}
