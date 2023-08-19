package br.com.sicredi.apiassembleia.service;

import br.com.sicredi.apiassembleia.domain.entity.Sessao;
import br.com.sicredi.apiassembleia.domain.enumeration.StatusEnum;
import br.com.sicredi.apiassembleia.dto.SessaoDTO;
import br.com.sicredi.apiassembleia.exceptions.BusinessException;
import br.com.sicredi.apiassembleia.repository.SessaoRepository;
import br.com.sicredi.apiassembleia.vo.FiltroSessaoVO;
import br.com.sicredi.apiassembleia.vo.SessaoVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class SessaoService {

    @Autowired
    protected SessaoRepository sessaoRepository;
    @Autowired
    protected ModelMapper modelMapper;

    protected void validateIniciar(SessaoVO vo) throws BusinessException {
        log.info("Iniciando validações da Sessao.");

        if (Objects.isNull(vo.getPauta().getId())) {
            throw new BusinessException("A Identificação da Pauta É Obrigatória ", HttpStatus.BAD_REQUEST);
        }

        log.info("Validações concluída com sucesso.");
    }


    public Long iniciar(SessaoVO vo) throws BusinessException {
        log.info("Iniciando Sessao");

        validateIniciar(vo);
        Sessao sessao = modelMapper.map(vo, Sessao.class);
        sessao.setStatus(StatusEnum.ATIVO);
        sessao = sessaoRepository.save(sessao);

        log.info("Sessao iniciada com sucesso.");
        return sessao.getId();
    }


    public Page<SessaoDTO> findPagableSessaoByFiltro(final FiltroSessaoVO vo, final Pageable pageable)
            throws BusinessException {
        return sessaoRepository.findPagableSessaoByFiltro(
                vo.getTitulo().toUpperCase(), pageable);
    }

}
