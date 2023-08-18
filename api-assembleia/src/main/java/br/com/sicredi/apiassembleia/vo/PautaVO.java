package br.com.sicredi.apiassembleia.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class PautaVO implements Serializable {
    private static final long serialVersionUID = 48809288075963508L;

    private Long id;
    private int pautaNumero;
    private String pautaDescricao;
}
