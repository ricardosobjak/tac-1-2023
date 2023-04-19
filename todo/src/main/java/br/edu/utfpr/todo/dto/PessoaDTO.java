package br.edu.utfpr.todo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PessoaDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, message = "Mínino 2 carateres")
    private String nome;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, message = "Mínimo 4 caracteres")
    private String senha;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;
}
