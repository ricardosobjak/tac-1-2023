package br.edu.utfpr.todo.controller;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.todo.dto.TodoDTO;
import br.edu.utfpr.todo.model.ToDo;
import br.edu.utfpr.todo.repository.PessoaRepository;
import br.edu.utfpr.todo.repository.TodoRepository;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired 
    private PessoaRepository pessoaRepository;

    @Autowired
    private TodoRepository todoRepository;
    
    /**
     * Criar um ToDo
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TodoDTO todoDTO) {
        var entity = new ToDo();
        entity.setId(UUID.randomUUID());

        BeanUtils.copyProperties(todoDTO, entity);

        System.out.println(todoDTO);
        System.out.println(entity);

        var pes = pessoaRepository.findById(UUID.fromString(todoDTO.getPessoaId()));
        entity.setPessoa(pes.get());

        todoRepository.save(entity);

        return ResponseEntity.status(201).body(entity);
    }

}
