package br.com.sicredi.apiassembleia.service;

import br.com.sicredi.apiassembleia.domain.entity.Votacao;
import br.com.sicredi.apiassembleia.domain.enumeration.StatusEnum;
import br.com.sicredi.apiassembleia.repository.VotacaoRepository;
import br.com.sicredi.apiassembleia.vo.VotacaoVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VotacaoService {


    @Autowired
    VotacaoRepository votacaoRepository;

    @Autowired
    ModelMapper modelMapper;

    public Long votar(final VotacaoVO vo) {
        log.info("Cadastrando Voto");

        Votacao votacao = modelMapper.map(vo, Votacao.class);
        votacao.setStatus(StatusEnum.ATIVO);
        votacao = votacaoRepository.save(votacao);

        log.info("Voto cadastrado com sucesso.");
        return votacao.getId();
    }
}
