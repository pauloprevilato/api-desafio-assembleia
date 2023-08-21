package br.com.sicredi.apiassembleia.exceptions;

public abstract class ExceptionGeneric  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String mensagem;

    public ExceptionGeneric(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
