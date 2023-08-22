package br.com.sicredi.apiassembleia.domain.entity;

import br.com.sicredi.apiassembleia.constant.SchemaConstants;
import br.com.sicredi.apiassembleia.domain.AbstractDominioEntity;
import br.com.sicredi.apiassembleia.domain.enumeration.VotoEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(schema = SchemaConstants.PGAPIASSEMBLEIA, name = "TB_VOTACAO")
public class Votacao extends AbstractDominioEntity<Long> {

    @ManyToOne
    @JoinColumn(name="ID_SESSAO", referencedColumnName = "ID")
    private Sessao sessao;

    @ManyToOne
    @JoinColumn(name="ID_ASSOCIADO", referencedColumnName="ID")
    private Associado associado;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="TB_VOTO")
    private VotoEnum voto;

}
