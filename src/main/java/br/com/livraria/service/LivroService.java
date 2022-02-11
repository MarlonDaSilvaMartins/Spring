package br.com.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.livraria.controller.LivroRequest;
import br.com.livraria.error.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivroRepository;

@Service
public class LivroService{
    @Autowired
    LivroRepository livroRepository;

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> pegarTodosLivros(){
        List<Livro> livro = new ArrayList<Livro>();
        return livroRepository.findAll();
    }

    public Livro getLivroById(String livroId){
        livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor pesquisado não foi encontrado!"));
        return livroRepository.findById(livroId).get();
    }

    public List<Livro> pegarTodosLivrosId(){
        return livroRepository.findAll();
    }

    public Livro atualizar(String livroId, Livro livro){
        livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor pesquisado não foi encontrado!"));
        return livroRepository.save(livroRepository.findById(livro.getLivroId()).get());
    }

    public void deletar(String livroId){
        livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor pesquisado não foi encontrado!"));
        livroRepository.deleteById(livroId);
    }

    public void deletarMaisDeUm(List<String> livro){
        for(String livroId : livro){
            livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor pesquisado não foi encontrado!"));
            livroRepository.deleteById(livroId);
        }
    }

    public String lerCookie(String nome){
        return "Meu nome é " + nome;
    }

}//livroService
