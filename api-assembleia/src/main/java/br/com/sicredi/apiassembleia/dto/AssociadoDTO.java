package br.com.sicredi.apiassembleia.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AssociadoDTO implements Serializable {
    private static final long serialVersionUID = 1519814701808579305L;
    private Long idAssociado;

    private PessoaDTO pessoa;
    AssociadoDTO(Long idAssociado, Long idPessoa,String cpfCnpj, String nomeRazaoSocial) {
        this.idAssociado = idAssociado;

        this.pessoa = PessoaDTO.builder()
                .id(idPessoa)
                .cpfCnpj(cpfCnpj)
                .nomeRazaoSocial(nomeRazaoSocial)
                .build();
    }
}
