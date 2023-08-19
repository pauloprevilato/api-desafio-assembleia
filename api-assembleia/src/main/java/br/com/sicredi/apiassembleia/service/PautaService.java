package br.com.sicredi.apiassembleia.service;

import br.com.sicredi.apiassembleia.domain.entity.Pauta;
import br.com.sicredi.apiassembleia.domain.enumeration.StatusEnum;
import br.com.sicredi.apiassembleia.dto.PautaDTO;
import br.com.sicredi.apiassembleia.repository.PautaRepository;
import br.com.sicredi.apiassembleia.vo.PautaVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PautaService {

    @Autowired
    protected PautaRepository pautaRepository;

    @Autowired
    protected ModelMapper modelMapper;

    public void cargaPauta() {
        log.info("Iniciando Carga de Pautas");

        Pauta pauta = pautaBuilder();
        pauta = pautaRepository.save(pauta);
    }

    public Long cadastrar(final PautaVO vo) {
        log.info("Cadastrando Pauta");

        Pauta pauta = modelMapper.map(vo, Pauta.class);
        pauta.setStatus(StatusEnum.ATIVO);
        pauta = pautaRepository.save(pauta);

        log.info("Pauta cadastrada com sucesso.");
        return pauta.getId();
    }

    public Page<PautaDTO> findAllPagable(final Pageable pageable) {
        return pautaRepository.findAllPagable(pageable);
    }

    public Pauta pautaBuilder() {
        return Pauta.builder() //
                .pautaDescricao("Iniciando carga de Pauta ") //
                .pautaNumero(10) //
                .status(StatusEnum.ATIVO) //
                .build();

    }
}
