package br.com.sicredi.apiassembleia.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
public class PessoaDTO implements Serializable {
    private static final long serialVersionUID = -8482193760667693665L;

    private Long id;
    private String cpfCnpj;
    private String nomeRazaoSocial;

    PessoaDTO(Long id, String cpfCnpj, String nomeRazaoSocial) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nomeRazaoSocial = nomeRazaoSocial;
    }
}
