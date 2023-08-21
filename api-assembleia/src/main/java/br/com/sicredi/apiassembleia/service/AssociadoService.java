package br.com.sicredi.apiassembleia.service;

import br.com.sicredi.apiassembleia.domain.entity.Associado;
import br.com.sicredi.apiassembleia.domain.entity.Pauta;
import br.com.sicredi.apiassembleia.domain.entity.Pessoa;
import br.com.sicredi.apiassembleia.domain.enumeration.StatusEnum;
import br.com.sicredi.apiassembleia.dto.AssociadoDTO;
import br.com.sicredi.apiassembleia.dto.PautaDTO;
import br.com.sicredi.apiassembleia.exceptions.CPFCNPJValidSize;
import br.com.sicredi.apiassembleia.repository.AssociadoRepository;
import br.com.sicredi.apiassembleia.repository.PautaRepository;
import br.com.sicredi.apiassembleia.repository.PessoaRepository;
import br.com.sicredi.apiassembleia.util.Utils;
import br.com.sicredi.apiassembleia.vo.AssociadoVO;
import br.com.sicredi.apiassembleia.vo.PautaVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AssociadoService {

    @Autowired
    protected PessoaRepository pessoaRepository;
    @Autowired
    protected AssociadoRepository associadoRepository;

    @Autowired
    protected ModelMapper modelMapper;

    public Long cadastrar(final AssociadoVO vo) {
        log.info("Cadastrando Associado");
        verificaCPF(vo.getCpfCnpj());

        Pessoa pessoa = modelMapper.map(vo, Pessoa.class);
        pessoa.setStatus(StatusEnum.ATIVO);
        pessoa = pessoaRepository.save(pessoa);

        Associado associado = modelMapper.map(vo, Associado.class);
        associado.setPessoa(pessoa);
        associado.setStatus(StatusEnum.ATIVO);
        associado = associadoRepository.save(associado);
        log.info("Associado inserido com sucesso.");
        return associado.getId();
    }


    private void verificaCPF(String cpf) {
        if (!Utils.contemApenasDigito(cpf) || cpf.length() != 11) {
            throw new CPFCNPJValidSize();
        }
    }

    public Page<AssociadoDTO> findAllPagable(final Pageable pageable) {
        return associadoRepository.findAllPagable(pageable);
    }
}
