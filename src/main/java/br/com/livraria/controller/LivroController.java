package br.com.livraria.controller;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<LivroRequest>pegarTodosLivros(){
        return livroService.pegarTodosLivros().stream().map(livro -> LivroMapper.livroToRequest(livro)).collect(Collectors.toList());
    }

    @GetMapping("/v1/livro/{livroId}")
    public LivroRequest pegarLivro(@PathVariable("livroId") String livroId){
        return LivroMapper.livroToRequest(livroService.getLivroById(livroId));
    }

    @GetMapping("/v1/livroid")
    public List<Livro>pegarTodosLivrosId(){
        return livroService.pegarTodosLivrosId();
    }

    @PutMapping("/v1/livro/{livroId}")
    public Livro update(@PathVariable("livroId") String livroId, @Valid @RequestBody LivroRequest livro){
        return livroService.atualizar(livroId,LivroMapper.mapperToImpl(livro));
    }

    @DeleteMapping("/v1/livro/{livroId}")
    public void deletarLivro(@PathVariable("livroId") String livroId){
        livroService.deletar(livroId);
    }

    @DeleteMapping("/v1/livro")
    public void deletarMaisDeUmLivro(@RequestParam("livroId") List<String> livroId){
        livroService.deletarMaisDeUm(livroId);
    }

    @GetMapping("/v1/cookie")
    public String lerCookie(@CookieValue("nome")String nome){
        return livroService.lerCookie(nome);
    }
}//livroController