package br.com.sicredi.apiassembleia.controller;

import br.com.sicredi.apiassembleia.domain.entity.Pauta;
import br.com.sicredi.apiassembleia.dto.PautaDTO;
import br.com.sicredi.apiassembleia.exceptions.BusinessException;
import br.com.sicredi.apiassembleia.exceptions.ObjectNotFoundException;
import br.com.sicredi.apiassembleia.repository.PautaRepository;
import br.com.sicredi.apiassembleia.service.PautaService;
import br.com.sicredi.apiassembleia.vo.PautaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pauta", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PautaController {

    @Autowired
    protected PautaService pautaService;

    @Autowired
    protected PautaRepository pautaRepository;

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



    @GetMapping(value = "/consultar-pauta")
    @ResponseStatus(HttpStatus.OK)
    public Page<PautaDTO> findAllPagination(@PageableDefault(size = 5, sort = {"pautaNumero"}) Pageable pageable)
            throws BusinessException {
                return pautaService.findAllPagable(pageable);
    }

    @GetMapping(value = "/consultar-pauta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pauta findById  (@PathVariable(value = "id") Long id) {
        Optional<Pauta> obj = pautaRepository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Pauta.class.getName()));
    }
}
