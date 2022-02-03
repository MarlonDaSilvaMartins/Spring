package br.com.livraria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.livraria.model.Livro;

public interface LivroRepository extends MongoRepository<Livro,String> {

}
