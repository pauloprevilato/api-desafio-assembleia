package br.com.sicredi.apiassembleia.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SessaoDTO {
    private static final long serialVersionUID = 9049406244218144583L;
    private Long idSessao;
    private int numero;
    private Date data;
    private int tempo;
    private String titulo;

    private PautaDTO pauta;

    public SessaoDTO(Long idSessao,  int numero, Date data,
                     int tempo, String titulo, Long idPauta, int pautaNumero, String pautaDescricao) {


        this.idSessao = idSessao;
        this.numero = numero;
        this.data = data;
        this.tempo = tempo;
        this.titulo = titulo;

        this.pauta = PautaDTO.builder()
                .id(idPauta)
                .pautaNumero(pautaNumero)
                .pautaDescricao(pautaDescricao)
                .build();

    }
}
