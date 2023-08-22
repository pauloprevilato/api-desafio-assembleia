package br.com.sicredi.apiassembleia.vo;

import br.com.sicredi.apiassembleia.domain.entity.Associado;
import br.com.sicredi.apiassembleia.domain.entity.Sessao;
import br.com.sicredi.apiassembleia.domain.enumeration.VotoEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class VotacaoVO implements Serializable {
    private static final long serialVersionUID = -8903594875589231396L;

    private Long id;
    private Sessao sessao;
    private Associado associado;
    private VotoEnum voto;

}
