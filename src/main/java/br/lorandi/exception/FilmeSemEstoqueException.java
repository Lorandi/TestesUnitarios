package br.lorandi.exception;

public class FilmeSemEstoqueException extends Exception{
    public FilmeSemEstoqueException (String msn){
        super(msn);
    }
}
