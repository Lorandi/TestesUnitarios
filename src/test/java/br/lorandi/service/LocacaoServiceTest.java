package br.lorandi.service;

import br.lorandi.entidades.Filme;
import br.lorandi.entidades.Locacao;
import br.lorandi.entidades.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocacaoServiceTest {

    @Test
    public void alugarFilme_returnsValor_whenSuccessful() {
//		cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario1");
        Filme filme = new Filme("Filme1", 2, 5.0);
        String batata = "batata";

//		acao
        Locacao locacao = service.alugarFilme(usuario, filme);

//		verificacao
        assertTrue(locacao.getValor() == 5.0);
//        assertEquals(locacao.getValor(), 5.0);
        assertEquals(batata, "batata");
//		System.out.println(locacao.getValor()==4.0);
//		System.out.println(locacao.getDataLocacao());
//		System.out.println(locacao.getDataRetorno());

    }
}
