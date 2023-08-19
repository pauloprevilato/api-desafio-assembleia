package br.com.sicredi.apiassembleia.vo;

import br.com.sicredi.apiassembleia.domain.entity.Pauta;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SessaoVO implements Serializable {
    private static final long serialVersionUID = -4064744628293693222L;

    private Long id;
    private Pauta pauta;
    private int numero;
    private Date data;
    private int tempo;
    private String titulo;
}
