package br.edu.utfpr.todo.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.todo.dto.PessoaDTO;
import br.edu.utfpr.todo.model.Pessoa;
import br.edu.utfpr.todo.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    /**
     * Obter todas as pessoas da API
     * 
     * @return
     */
    @GetMapping({ "", "/" })
    public Iterable<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }

    /**
     * Obter 1 pessoa pelo seu ID
     * 
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Pessoa> getPessoa(@PathVariable String id) {
        return pessoaRepository.findById(UUID.fromString(id));
    }

    /**
     * Criar uma Pessoa
     */
    @PostMapping({"", "/"})
    public ResponseEntity<Object> create(@RequestBody PessoaDTO pessoaDTO) {
        // Validar se o e-mail existe no banco de dados
        if(pessoaRepository.existsByEmail(pessoaDTO.getEmail())) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Conflito: E-mail já existe.");
        }

        var entity = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, entity);
        entity.setId(UUID.randomUUID());

        try {
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pessoaRepository.save(entity));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
