package br.com.sicredi.apiassembleia.controller;

import br.com.sicredi.apiassembleia.dto.SessaoDTO;
import br.com.sicredi.apiassembleia.exceptions.BusinessException;
import br.com.sicredi.apiassembleia.service.SessaoService;
import br.com.sicredi.apiassembleia.vo.FiltroSessaoVO;
import br.com.sicredi.apiassembleia.vo.SessaoVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sessao", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SessaoController {

    @Autowired
    SessaoService sessaoService;

    @PostMapping(value = "/iniciar-sessao")
    @ResponseStatus(HttpStatus.CREATED)
    public Long iniciar(@RequestBody SessaoVO vo) throws BusinessException {
        return sessaoService.iniciar(vo);
    }

    @GetMapping(value = "/consultar-sessao")
    @ResponseStatus(HttpStatus.OK)
    public Page<SessaoDTO> findByIdSessaoPagination(@Valid FiltroSessaoVO vo,
            final Pageable pageable) throws BusinessException {
        return sessaoService.findPagableSessaoByFiltro(vo, pageable);
    }


}