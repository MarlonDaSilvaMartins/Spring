package br.com.livraria.controller;

import br.com.livraria.model.Livro;

public class LivroMapper {
    public static Livro mapperToImpl(LivroRequest livroRequest){
        return Livro.builder()
                .nome(livroRequest.getNome())
                .autor(livroRequest.getAutor())
                .preco(livroRequest.getPreco())
                .build();
    }

    public static LivroRequest livroToRequest(Livro livro){
        return LivroRequest.builder()
                .nome(livro.getNome())
                .autor(livro.getAutor())
                .preco(livro.getPreco())
                .build();
    }
}
