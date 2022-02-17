package br.com.livraria.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document
public class Livro {
    @Id
    private String livroId;
    private String nome;
    private String autor;
    private LocalDate data;
    private Double preco;
}