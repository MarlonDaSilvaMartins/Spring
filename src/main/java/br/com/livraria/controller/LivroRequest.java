package br.com.livraria.controller;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class LivroRequest {
    @NotEmpty(message = "Nome vazio")
    private String nome;
    @NotEmpty(message = "Autor vazio")
    private String autor;
    @NotNull(message = "Valor vazio")
    @DecimalMin(value = "0.1",message = "valor minimo de 0.10")
    private Double preco;
}
