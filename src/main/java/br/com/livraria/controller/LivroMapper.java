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

    public static LivroResponse livroToResponse(Livro livro){
        return LivroResponse.builder()
                .livroId(livro.getLivroId())
                .nome(livro.getNome())
                .autor(livro.getAutor())
                .preco(livro.getPreco())
                .build();
    }
}
