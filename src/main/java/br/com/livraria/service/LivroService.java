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

    public Livro salvarOuAtualizar(Livro livro){
        return livroRepository.save(livro);

    }

    public void deletar(String id){
        livroRepository.deleteById(id);
    }

    public void atualizar(Livro livro,String livroId){
        livroRepository.save(livro);
    }
}
