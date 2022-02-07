package br.com.livraria.service;

import java.util.ArrayList;
import java.util.List;
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

    public void deletar(String livroId){
        livroRepository.deleteById(livroId);
    }

    public void deletarMaisDeUm(Livro[] livro){
        for(Livro livro1 : livro){
            livroRepository.deleteById(livro1.getLivroId());
        }
    }

    public Livro atualizar(Livro livro){
        return livroRepository.save(livro);
    }
}
