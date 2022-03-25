package br.com.livraria.repository;

import br.com.livraria.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {

}
