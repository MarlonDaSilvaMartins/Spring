package br.com.livraria.controller;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.livraria.service.LivroService;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class LivroController {
    LivroService livroService;

    @PostMapping("/v1/livro")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroResponse salvarLivro(@Valid @RequestBody LivroRequest livro){
        return LivroMapper.livroToResponse(livroService.salvar(LivroMapper.mapperToImpl(livro)));
    }

    @GetMapping("/v1/livro")
    @ResponseStatus(HttpStatus.OK)
    public List<LivroResponse>pegarTodosLivros(){
        return livroService.pegarTodosLivros().stream().map(LivroMapper::livroToResponse).collect(Collectors.toList());
    }

    @GetMapping("/v1/livro/{livroId}")
    @ResponseStatus(HttpStatus.OK)
    public LivroResponse pegarLivro(@PathVariable("livroId") String livroId){
        return LivroMapper.livroToResponse(livroService.getLivroById(livroId));
    }

    @PutMapping("/v1/livro/{livroId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LivroResponse update(@PathVariable("livroId") String livroId, @Valid @RequestBody LivroRequest livro){
        return LivroMapper.livroToResponse(livroService.atualizar(livroId,LivroMapper.mapperToImpl(livro)));
    }

    @DeleteMapping("/v1/livro/{livroId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarLivro(@PathVariable("livroId") String livroId){
        livroService.deletar(livroId);
    }

    @DeleteMapping("/v1/livro")
    @ResponseStatus(HttpStatus.OK)
    public void deletarMaisDeUmLivro(@RequestParam("livroId") List<String> livroId){
        livroService.deletarMaisDeUm(livroId);
    }

    @GetMapping("/v1/cookie")
    @ResponseStatus(HttpStatus.OK)
    public String lerCookie(@CookieValue("nome")String nome){
        return livroService.lerCookie(nome);
    }
}//livroController