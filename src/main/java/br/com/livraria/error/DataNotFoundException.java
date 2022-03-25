package br.com.livraria.error;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String mensagem){
        super(mensagem);
    }
}
