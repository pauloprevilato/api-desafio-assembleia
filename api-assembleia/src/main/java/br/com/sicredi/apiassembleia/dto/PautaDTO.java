package br.com.sicredi.apiassembleia.dto;

import br.com.sicredi.apiassembleia.domain.entity.Pauta;

public record PautaDTO(Long id, int pautaNumero, String pautaDescricao) {

    public PautaDTO(Pauta pauta) {
        this(pauta.getId(), pauta.getPautaNumero(), pauta.getPautaDescricao());
    }
}
