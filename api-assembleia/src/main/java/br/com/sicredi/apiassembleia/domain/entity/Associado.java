package br.com.sicredi.apiassembleia.domain.entity;

import br.com.sicredi.apiassembleia.constant.SchemaConstants;
import br.com.sicredi.apiassembleia.domain.AbstractDominioEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(schema = SchemaConstants.PGAPIASSEMBLEIA, name = "TB_ASSOCIADO")
public class Associado extends AbstractDominioEntity<Long> {

    @ManyToOne(fetch  = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    private Pessoa pessoa;

}
