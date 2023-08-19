package br.com.sicredi.apiassembleia.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
public class PautaDTO implements Serializable {
    private static final long serialVersionUID = 7436816374670640541L;

    private Long id;
    private int pautaNumero;
    private String pautaDescricao;

    public PautaDTO(Long id, int pautaNumero, String pautaDescricao) {
        this.id = id;
        this.pautaNumero = pautaNumero;
        this.pautaDescricao = pautaDescricao;
    }

}
