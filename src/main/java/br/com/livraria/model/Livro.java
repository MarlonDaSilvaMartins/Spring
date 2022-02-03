package br.com.livraria.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Document
public class Livro {
    private String livroId;
    private String nome;
    private String autor;
    private double preco;
}