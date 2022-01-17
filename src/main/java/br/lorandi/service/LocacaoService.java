package br.lorandi.service;

import static br.lorandi.utils.DataUtils.adicionarDias;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import br.lorandi.entidades.Filme;
import br.lorandi.entidades.Locacao;
import br.lorandi.entidades.Usuario;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) {
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

