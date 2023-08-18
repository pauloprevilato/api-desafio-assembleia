package br.com.sicredi.apiassembleia.controller;

import br.com.sicredi.apiassembleia.service.PautaService;
import br.com.sicredi.apiassembleia.vo.PautaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pauta", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PautaController {

    @Autowired
    protected PautaService pautaService;

    @PostMapping(value = "/carga")
    @ResponseStatus(HttpStatus.CREATED)
    public void carga() {
        pautaService.cargaPauta();
    }

    @PostMapping(value = "/cadastrar-pauta")
    @ResponseStatus(HttpStatus.CREATED)
    public Long cadastrar(@RequestBody PautaVO vo) {
        return pautaService.cadastrar(vo);
    }

}
