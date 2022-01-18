package br.lorandi.service;

import static br.lorandi.utils.DataUtils.adicionarDias;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import br.lorandi.entidades.Filme;
import br.lorandi.entidades.Locacao;
import br.lorandi.entidades.Usuario;
import br.lorandi.exception.EntidadeNullException;
import br.lorandi.exception.FilmePrecisaTerUmNome;
import br.lorandi.exception.FilmeSemEstoqueException;
import br.lorandi.exception.UsuarioSemNomeValido;

public class LocacaoService {


    public Locacao alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueException, UsuarioSemNomeValido, FilmePrecisaTerUmNome, EntidadeNullException {

        if (usuario == null){
            throw new EntidadeNullException("Usuário é null");

        }

        if (filme == null){
            throw new EntidadeNullException("Filme é null");
        }

        if( filme.getEstoque() == 0){
            throw new FilmeSemEstoqueException("Filme sem estoque");
        }

        if(usuario.getNome() == null || usuario.getNome().equals("")){
            throw new UsuarioSemNomeValido("Usuario deve ter nome válido");
        }

        if( filme.getNome().equals("")){
            throw new FilmePrecisaTerUmNome("Filme precisa ter um nome");
        }

        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());


        //Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return locacao;
    }
}

