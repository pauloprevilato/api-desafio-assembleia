package br.com.sicredi.apiassembleia.controller;

import br.com.sicredi.apiassembleia.exceptions.BusinessException;
import br.com.sicredi.apiassembleia.service.VotacaoService;
import br.com.sicredi.apiassembleia.vo.VotacaoVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/votacao", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class VotacaoController {

    private ModelMapper modelMapper;

    @Autowired
    private VotacaoService votacaoService;

    @PostMapping(value = "/votar")
    @ResponseStatus(HttpStatus.CREATED)
    public Long votar(@RequestBody VotacaoVO vo) throws BusinessException {
        return votacaoService.votar(vo);
    }
}
