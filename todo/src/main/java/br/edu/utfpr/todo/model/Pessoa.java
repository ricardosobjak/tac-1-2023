package br.edu.utfpr.todo.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // Informa que é entidade de persistência no DB
@Table(name = "tb_pessoa") // Personalizar o nome da tabela
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pessoa {
    @Id
    private UUID id;
    
    private String nome;
    private String senha;
    private String email;
}
