package br.com.livraria.controller;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class LivroResponse {
    private String livroId;
    private String nome;
    private String autor;
    private Double preco;
}
