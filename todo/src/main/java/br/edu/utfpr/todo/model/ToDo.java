package br.edu.utfpr.todo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_todo")
public class ToDo {
    @Id
    private UUID id;

    @Column(name = "description", length = 255)
    private String descricao;

    @ManyToOne
    private Pessoa pessoa;
}
