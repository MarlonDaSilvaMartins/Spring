package br.com.livraria.service;

import java.util.List;

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
        Livro livroUpdate = livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor pesquisado não foi encontrado!"));
        //Double preco = livro.getPreco().isNaN() ? livroUpdate.getPreco() : livro.getPreco();
        double preco = livro.getPreco();
        livroUpdate.setPreco(preco);
        return livroRepository.save(livroUpdate);
    }

    public void deletar(String livroId){
        livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor pesquisado não foi encontrado!"));
        livroRepository.deleteById(livroId);
    }

    public void deletarMaisDeUm(List<String> livro){
        for(String livroId : livro){
            livroRepository.findById(livroId).orElseThrow(() -> new DataNotFoundException("Valor "+livroId+" não foi encontrado!"));
            livroRepository.deleteById(livroId);
        }
    }

    public String lerCookie(String nome){
        return "Meu nome é " + nome;
    }

}//livroService
