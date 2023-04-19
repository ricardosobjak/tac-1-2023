package br.edu.utfpr.todo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.todo.model.ToDo;

public interface TodoRepository 
    extends CrudRepository<ToDo, UUID> {
    
}
