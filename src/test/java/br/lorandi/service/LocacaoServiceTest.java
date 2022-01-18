package br.lorandi.service;

import br.lorandi.entidades.Filme;
import br.lorandi.entidades.Locacao;
import br.lorandi.entidades.Usuario;
import br.lorandi.exception.EntidadeNullException;
import br.lorandi.exception.FilmePrecisaTerUmNome;
import br.lorandi.exception.FilmeSemEstoqueException;
import br.lorandi.exception.UsuarioSemNomeValido;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.jupiter.api.Assertions.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    //		cenário
    LocacaoService service = new LocacaoService();
    Usuario usuario = new Usuario("Usuario1");
    Usuario usuario2 = new Usuario("");
    Usuario usuario3;

    Filme filme = new Filme("Filme1", 2, 5.0);
    Filme filme2 = new Filme("", 2, 5.0);
    Filme filme3;




    @Test
    public void alugarFilme_returnsValor_whenSuccessful() throws FilmePrecisaTerUmNome, UsuarioSemNomeValido, FilmeSemEstoqueException, EntidadeNullException {

//		acao
        Locacao locacao = service.alugarFilme(usuario, filme);

//		verificacao
        assertTrue(locacao.getValor() == 5.0);
        assertEquals(usuario.getNome(), "Usuario1");
        assertFalse(filme.getEstoque()<=0);
        assertSame(!usuario.getNome().equals("") && usuario.getNome() != null, true);
    }

    @Test
    public void alugarFilme_returnsException_whenEstoqueIs0() {

        // Action/
       assertEquals("Filme sem estoque", Assertions.assertThrows(FilmeSemEstoqueException.class,
               () -> service.alugarFilme(usuario, new Filme("Filme1", 0, 5.0))).getMessage());
    }

    @Test
    public void alugarFilme_returnsException_whenFilmeIsNoName(){
        assertEquals("Filme precisa ter um nome", assertThrows(FilmePrecisaTerUmNome.class,
                () -> service.alugarFilme(usuario, filme2)).getMessage());
    }


    @Test
    public void alugarFilme_returnsException_whenUsuarioNomeIsInvalid(){
        assertEquals("Usuario deve ter nome válido", assertThrows(UsuarioSemNomeValido.class,
                () -> service.alugarFilme(new Usuario(""),filme)).getMessage());

        assertEquals("Usuario deve ter nome válido", assertThrows(UsuarioSemNomeValido.class,
                () -> service.alugarFilme(usuario2,filme)).getMessage());
    }

    @Test
    public void alugarFilme_returnsPrecoLocacao_whenSuccessful(){
        assertEquals(true,filme.getPrecoLocacao() == 5.0 );

    }

    @Test
    public void alugarFilme_returnsEntidadeNullException_whenUsuarioNull(){
        assertEquals("Usuário é null", assertThrows(EntidadeNullException.class,
                () -> service.alugarFilme(usuario3,filme)).getMessage());
    }

    @Test
    public void alugarFilme_returnsEntidadeNullException_whenFilmeNull(){
        assertEquals("Filme é null", assertThrows(EntidadeNullException.class,
                () -> service.alugarFilme(usuario,filme3)).getMessage());
    }





}
