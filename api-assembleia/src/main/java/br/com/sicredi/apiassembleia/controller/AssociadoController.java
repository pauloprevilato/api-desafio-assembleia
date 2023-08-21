package br.com.sicredi.apiassembleia.controller;

import br.com.sicredi.apiassembleia.dto.AssociadoDTO;
import br.com.sicredi.apiassembleia.exceptions.BusinessException;
import br.com.sicredi.apiassembleia.service.AssociadoService;
import br.com.sicredi.apiassembleia.vo.AssociadoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/associado", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AssociadoController {

    @Autowired
    protected AssociadoService associadoService;

    @PostMapping(value ="/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Long cadastrar(@RequestBody AssociadoVO vo) {
        return associadoService.cadastrar(vo);
    }

    @GetMapping(value = "/consultar")
    @ResponseStatus(HttpStatus.OK)
    public Page<AssociadoDTO> findAllPagination(Pageable pageable)
            throws BusinessException {
        return associadoService.findAllPagable(pageable);
    }



}
