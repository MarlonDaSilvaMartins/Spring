package br.com.livraria.controller;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class LivroResponse {
    private String livroId;
    private String nome;
    private String autor;
    private LocalDate data;
    private Double preco;
}
