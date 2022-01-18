package br.lorandi.service;

import br.lorandi.entidades.Filme;
import br.lorandi.entidades.Locacao;
import br.lorandi.entidades.Usuario;
import br.lorandi.exception.EntidadeNullException;
import br.lorandi.exception.FilmePrecisaTerUmNome;
import br.lorandi.exception.FilmeSemEstoqueException;
import br.lorandi.exception.UsuarioSemNomeValido;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocacaoServiceTest {

    private static Integer count;

    @BeforeAll
    public static void setupClass() {
        count = 0;
        System.out.println();
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Acabou!!!");
    }

    @BeforeEach
    public void setup() {
        count++;
    }

    @AfterEach
    public void tearDown() {
        System.out.println("contador: " + count + "\n");
    }


    //		cenário
    LocacaoService service = new LocacaoService();
    Usuario usuario = new Usuario("Usuario1");
    Usuario usuario2 = new Usuario("");
    Usuario usuario3;

    List<Filme> filmes1 = Arrays.asList(new Filme("Filme1", 2, 5.0));
    List<Filme> filmes2 = Arrays.asList(new Filme("Filme1", 0, 5.0));
    List<Filme> filmes3 = Arrays.asList(new Filme("", 2, 5.0));
    List<Filme> filmes4;
//    List<Filme> filmes3 = Arrays.asList(new Filme ("", 2, 5.0));


    @Rule
    public ErrorCollector error = new ErrorCollector();


    @Test
    public void alugarFilme_returnsEntidadeNullException_whenFilmeNull() {
        assertEquals("Filme é null", assertThrows(EntidadeNullException.class,
                () -> service.alugarFilme(usuario, filmes4)).getMessage());
    }

    @Test
    public void alugarFilme_returnsValor_whenSuccessful() throws FilmePrecisaTerUmNome, UsuarioSemNomeValido,
            FilmeSemEstoqueException, EntidadeNullException {
//		acao
        Locacao locacao = service.alugarFilme(usuario, filmes1);

        boolean semEstoque = false;

        for(Filme filme : filmes1){
            if(filme.getEstoque() < 1){
                semEstoque = true;
                break;
            }
        }

//		verificacao
        assertTrue(locacao.getValor() == 5.0);
        assertEquals(usuario.getNome(), "Usuario1");
        assertFalse(semEstoque);
        assertSame(!usuario.getNome().equals("") && usuario.getNome() != null, true);

    }


    @Test
    public void alugarFilme_returnsException_whenEstoqueIs0() {

        // Action/
        assertEquals("Filme sem estoque", Assertions.assertThrows(FilmeSemEstoqueException.class,
                () -> service.alugarFilme(usuario,filmes2)).getMessage());
    }

    @Test
    public void alugarFilme_returnsException_whenFilmeIsNoName() {
        assertEquals("Filme precisa ter um nome", assertThrows(FilmePrecisaTerUmNome.class,
                () -> service.alugarFilme(usuario, filmes3)).getMessage());
    }


    @Test
    public void alugarFilme_returnsException_whenUsuarioNomeIsInvalid() {
        assertEquals("Usuario deve ter nome válido", assertThrows(UsuarioSemNomeValido.class,
                () -> service.alugarFilme(new Usuario(""), filmes1)).getMessage());

        assertEquals("Usuario deve ter nome válido", assertThrows(UsuarioSemNomeValido.class,
                () -> service.alugarFilme(usuario2, filmes1)).getMessage());
    }

    @Test
    public void alugarFilme_returnsPrecoLocacao_whenSuccessful() throws FilmePrecisaTerUmNome, UsuarioSemNomeValido, FilmeSemEstoqueException, EntidadeNullException {
        assertEquals(true, service.alugarFilme(usuario, filmes1).getValor() == 5.0);

    }

    @Test
    public void alugarFilme_returnsEntidadeNullException_whenUsuarioNull() {
        assertEquals("Usuário é null", assertThrows(EntidadeNullException.class,
                () -> service.alugarFilme(usuario3, filmes1)).getMessage());
    }
}
