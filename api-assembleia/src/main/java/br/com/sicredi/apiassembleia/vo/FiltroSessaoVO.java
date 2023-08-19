package br.com.sicredi.apiassembleia.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class FiltroSessaoVO implements Serializable {
    private static final long serialVersionUID = -3040012151580668345L;

    @NotNull
    private String titulo;

}
