package br.com.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.livraria.model.Livro;
import br.com.livraria.service.LivroService;

import javax.validation.Valid;

@RestController
public class LivroController {
    @Autowired
    LivroService livroService;

    @PostMapping("/v1/livro")
    public Livro salvarLivro(@Valid @RequestBody LivroRequest livro){
        return livroService.salvar(LivroMapper.mapperToImpl(livro));
    }

    @GetMapping("/v1/livro")
    public List<Livro>pegarTodosLivros(){
        return livroService.pegarTodosLivros();
    }

    @GetMapping("/v1/livro/{livroId}")
    public Livro pegarLivro(@PathVariable("livroId") String livroId){
        return livroService.getLivroById(livroId);
    }

    @PutMapping("/v1/livro/{livroId}")
    public Livro update(@PathVariable("livroId") String livroId, @Valid @RequestBody LivroRequest livro){
        return livroService.atualizar(livroId,LivroMapper.mapperToImpl(livro));
    }

    @PatchMapping("/v1/livro/{livroId}")
    public Livro updateParcial(@PathVariable("livroId") String livroId, @Valid @RequestBody LivroRequest livro){
        return livroService.atualizar(livroId,LivroMapper.mapperToImpl(livro));
    }

    @DeleteMapping("/v1/livro/{livroId}")
    public void deletarLivro(@PathVariable("livroId") String livroId){
        livroService.deletar(livroId);
    }

    @DeleteMapping("/v1/livro")
    public void deletarMaisDeUmLivro(@RequestBody List<String> livroId){
        livroService.deletarMaisDeUm(livroId);
    }

    @GetMapping("/v1/cookie")
    public String lerCookie(@CookieValue("nome")String nome){
        return livroService.lerCookie(nome);
    }
}//livroController