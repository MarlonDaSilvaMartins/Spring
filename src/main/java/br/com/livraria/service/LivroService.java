package br.com.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.livraria.model.Livro;
import br.com.livraria.repository.LivroRepository;

@Service
public class LivroService{
    @Autowired
    LivroRepository livroRepository;

    public List<Livro> pegarTodosLivros(){
        List<Livro> livro = new ArrayList<Livro>();
        livroRepository.findAll().forEach(livro1 -> livro.add(livro1));
        return livro;
    }

    public Livro getLivroById(String id){
        return livroRepository.findById(id).get();
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro atualizar(Livro livro){
        Livro livro1 = livroRepository.findById(livro.getLivroId()).get();
        var nome = Optional.ofNullable(livro.getNome());
        if(nome.isPresent()){
            livro1.setNome(nome.get());
        }
        var autor = Optional.ofNullable(livro.getAutor());
        if(autor.isPresent()){
            livro1.setAutor(autor.get());
        }
        var preco = Optional.ofNullable(livro.getPreco());
        if(preco.isPresent()){
            livro1.setPreco(preco.get());
        }
        return livroRepository.save(livro1);
    }

    public void deletar(String livroId){
        livroRepository.deleteById(livroId);
    }

    public void deletarMaisDeUm(Livro[] livro){
        for(Livro livro1 : livro){
            livroRepository.deleteById(livro1.getLivroId());
        }
    }

    public String lerCookie(String nome){
        return "Meu nome é " + nome;
    }
}//livroService
