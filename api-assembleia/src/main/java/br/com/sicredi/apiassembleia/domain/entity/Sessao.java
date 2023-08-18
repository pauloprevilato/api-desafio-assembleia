package br.com.sicredi.apiassembleia.domain.entity;

import br.com.sicredi.apiassembleia.constant.SchemaConstants;
import br.com.sicredi.apiassembleia.domain.AbstractDominioEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(schema = SchemaConstants.PGAPIASSEMBLEIA, name = "TB_SESSAO")
public class Sessao extends AbstractDominioEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAUTA", referencedColumnName = "ID")
    private Pauta pauta;

    @Column(name = "SESSAO_DATA_INICIAL")
    private Date data;
    
    @Column(name = "SESSAO_TEMPO")
    private int tempo;

}
