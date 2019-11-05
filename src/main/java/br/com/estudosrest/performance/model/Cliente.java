package br.com.estudosrest.performance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name ="cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String nome;

    @Size(max = 100)
    private String endereco;

    @Size(max = 20)
    private String numero;

    @Size(max = 100)
    private String bairro;

    @Email
    @Size(max = 200)
    private String email;

    @Size(max = 11)
    private String cpf;

    @CreatedDate
    private LocalDate dataCriacao;
}
