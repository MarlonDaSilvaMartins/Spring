package br.com.livraria.model;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Document
public class Livro {
    @Id
    private String livroId;
    private String nome;
    private String autor;
    private double preco;
}