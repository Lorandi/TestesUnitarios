package br.lorandi.exception;

public class UsuarioSemNomeValido extends Exception{
    public UsuarioSemNomeValido(String msn){
        super(msn);
    }
}
