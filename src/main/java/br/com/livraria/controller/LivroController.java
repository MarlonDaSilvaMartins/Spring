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

    @DeleteMapping("/livro")
    public void deletarMaisDeUmLivro(@RequestBody Livro[] livro){
        livroService.deletarMaisDeUm(livro);
    }

    @PostMapping("/livro")
    public Livro salvarLivro(@RequestBody Livro livro){
       return livroService.salvar(livro);
    }

    @PutMapping("/livro/{livroId}")
    public Livro update(@PathVariable("livroId") String livroId, @RequestBody Livro livro){
        livro.setLivroId(livroId);
        return livroService.atualizar(livro);
    }

    @PatchMapping("/livro/{livroId}")
    public Livro updateParcial(@PathVariable("livroId") String livroId, @RequestBody Livro livro){
        livro.setLivroId(livroId);
        return livroService.atualizar(livro);
    }
}