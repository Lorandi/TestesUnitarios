package br.lorandi.service;

import static br.lorandi.utils.DataUtils.adicionarDias;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import br.lorandi.entidades.Filme;
import br.lorandi.entidades.Locacao;
import br.lorandi.entidades.Usuario;
import br.lorandi.exception.EntidadeNullException;
import br.lorandi.exception.FilmePrecisaTerUmNome;
import br.lorandi.exception.FilmeSemEstoqueException;
import br.lorandi.exception.UsuarioSemNomeValido;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, UsuarioSemNomeValido, FilmePrecisaTerUmNome, EntidadeNullException {

        Locacao locacao = new Locacao();

        Double valorTotal = 0.0;

        if (usuario == null) {
            throw new EntidadeNullException("Usuário é null");

        }

        if (filmes == null || filmes.isEmpty()) {
            throw new EntidadeNullException("Filme é null");
        }

        for (Filme filme : filmes) {
            if (filme.getEstoque() == 0) {
                throw new FilmeSemEstoqueException("Filme sem estoque");
            }

            if (filme.getNome().equals("")) {
                throw new FilmePrecisaTerUmNome("Filme precisa ter um nome");
            }

            locacao.getFilmes();

            valorTotal += filme.getPrecoLocacao();

        }


        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            throw new UsuarioSemNomeValido("Usuario deve ter nome válido");
        }

        locacao.setFilmes(filmes);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(valorTotal);



        //Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return locacao;
    }
}

