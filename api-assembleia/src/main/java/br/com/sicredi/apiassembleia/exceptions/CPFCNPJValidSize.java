package br.com.sicredi.apiassembleia.exceptions;

public class CPFCNPJValidSize extends ExceptionGeneric {
    private static final long serialVersionUID = 1L;

    public CPFCNPJValidSize() {
        super("O CPF informado está mal formatado. Só deve conter dígitos e seu tamanho deve conter 11 caracteres");
    }

}
