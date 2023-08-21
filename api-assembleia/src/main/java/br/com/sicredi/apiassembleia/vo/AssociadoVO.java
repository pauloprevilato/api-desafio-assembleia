package br.com.sicredi.apiassembleia.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class AssociadoVO  implements Serializable {
    private static final long serialVersionUID = -9141098389725852323L;

    private Long id;
    private String cpfCnpj;
    private String nomeRazaoSocial;

}