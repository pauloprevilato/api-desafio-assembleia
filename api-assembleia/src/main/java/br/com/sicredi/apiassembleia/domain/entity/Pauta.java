package br.com.sicredi.apiassembleia.domain.entity;

import br.com.sicredi.apiassembleia.constant.SchemaConstants;
import br.com.sicredi.apiassembleia.domain.AbstractDominioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(schema = SchemaConstants.PGAPIASSEMBLEIA, name = "TB_PAUTA")
public class Pauta extends AbstractDominioEntity<Long> {

    @Column(name = "PAUTA_NUMERO")
    private int pautaNumero;

    @Column(name = "PAUTA_DESCRICAO")
    private String pautaDescricao;

}
