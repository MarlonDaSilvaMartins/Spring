package br.com.livraria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;

@RestController
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping("/livro")
    public List<Livro>pegarTodosLivros(){
        return livroService.pegarTodosLivros();
    }

    @GetMapping("/livro/{livroId}")
    public Livro pegarLivro(@PathVariable("livroId") String livroId){
        return livroService.getLivroById(livroId);
    }

    @DeleteMapping("/livro/{livroId}")
    public void deletarLivro(@PathVariable("livroId") String livroId){
        livroService.deletar(livroId);
    }

    @PostMapping("/livro")
    public Livro salvarLivro(@RequestBody Livro livro){
       return livroService.salvarOuAtualizar(livro);
    }

    @PutMapping("/livro")
    public Livro update(@RequestBody Livro livro){
        livroService.salvarOuAtualizar(livro);
        return livro;
    }
}