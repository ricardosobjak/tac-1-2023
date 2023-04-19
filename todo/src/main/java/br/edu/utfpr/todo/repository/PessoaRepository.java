package br.edu.utfpr.todo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.todo.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, UUID> {
        public boolean existsByEmail(String email);
}
