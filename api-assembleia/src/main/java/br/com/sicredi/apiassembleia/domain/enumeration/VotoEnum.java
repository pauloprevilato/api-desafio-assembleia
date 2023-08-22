package br.com.sicredi.apiassembleia.domain.enumeration;

import lombok.Getter;

@Getter
public enum VotoEnum {

    SIM,
    NAO;
    public VotoEnum getOpcao(String opcao) {

        if (opcao.toUpperCase().equals("SIM")){
            return VotoEnum.SIM;
        }
        return VotoEnum.NAO;
    }
}

