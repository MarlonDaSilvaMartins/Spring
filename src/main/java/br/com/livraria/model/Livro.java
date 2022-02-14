package br.com.livraria.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private Double preco;
}