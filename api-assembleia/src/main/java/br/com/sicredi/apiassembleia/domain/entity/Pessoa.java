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
@Table(schema = SchemaConstants.PGAPIASSEMBLEIA, name = "TB_PESSOA")
public class Pessoa extends AbstractDominioEntity<Long> {

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "NOME_RAZAO_SOCIAL")
    private String nomeRazaoSocial;

}
