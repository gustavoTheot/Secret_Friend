package br.amigosecreto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAll {

    SistemaAmigo sistema;

    @BeforeEach
    void setUp()  {
        this.sistema = new SistemaAmigo();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistema.pesquisarTodasMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigo("ayla@teste.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        try {
            sistema.pesquisaAmigo("ayla@teste.com");
            fail("Deveria falhar pois não existe ainda");
        } catch (AmigoInexistenteException e) {
            //Ok
        }
        try {
            sistema.cadastraAmigo("ayla", "ayla@teste.com");
            Amigo a = sistema.pesquisaAmigo("ayla@teste.com");
            assertEquals("ayla", a.getNome());
            assertEquals("ayla@teste.com", a.getEmail());
        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }


    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistema.pesquisarTodasMensagens().isEmpty());
        sistema.enviarMesagemParaTodos("texto", "ayla@dcx.ufpb.br", true);
        ArrayList<Mensagem> mensagensAchadas = sistema.pesquisarTodasMensagens();
        assertTrue(mensagensAchadas.size()==1);
        assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("ayla@dcx.ufpb.br"));
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        assertTrue(sistema.pesquisarTodasMensagens().isEmpty());
        sistema.enviarmensagemParaAlguem("texto", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
        ArrayList<Mensagem> mensagensAchadas = sistema.pesquisarTodasMensagens();
        assertEquals(1, mensagensAchadas.size());
        assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
        assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        assertTrue(sistema.pesquisarTodasMensagens().isEmpty());
        sistema.enviarmensagemParaAlguem("texto 1", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisarMensagensAnonimas().isEmpty());
        sistema.enviarmensagemParaAlguem("texto 2", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
        assertTrue(sistema.pesquisarMensagensAnonimas().size()==1);
    }

    @Test
    void testPesquisaTodasAsMensagens() {
        assertTrue(sistema.pesquisarTodasMensagens().isEmpty());
        sistema.enviarmensagemParaAlguem("texto 1", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisarMensagensAnonimas().size()==1);
        sistema.enviarmensagemParaAlguem("texto 2", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", true);
        assertTrue(sistema.pesquisarTodasMensagens().size()==2);
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigoSecreto("ayla@dcx.ufpb.br"));
        try {
            sistema.cadastraAmigo("Ayla", "ayla@dcx.ufpb.br");
            sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecreto("ayla@dcx.ufpb.br", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecreto("ana@dcx.ufpb.br", "ayla@dcx.ufpb.br");
            assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecreto("ayla@dcx.ufpb.br"));
            assertEquals("ayla@dcx.ufpb.br", sistema.pesquisaAmigoSecreto("ana@dcx.ufpb.br"));
        } catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }
    }


}