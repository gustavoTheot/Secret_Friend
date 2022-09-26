package br.amigosecreto;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        SistemaAmigo s1 = new SistemaAmigo(new ArrayList<Mensagem>(), new ArrayList<Amigo>());
        try{

            s1.cadastraAmigo("Jose", "jose@gmail.com");
            s1.cadastraAmigo("Maria", "maria@gmail.com");

            s1.pesquisarTodosAmigos();

            s1.configuraAmigoSecreto("maria@gmail.com", "jose@gmail.com");

            s1.enviarmensagemParaAlguem("Maria cade você?", "maria@gmail.com", "jose@gmail.com", true);
            s1.enviarMesagemParaTodos("Bom dia a todos", "maria@gmail.com", false);

            ArrayList<Mensagem> msgAnonimas = s1.pesquisarMensagensAnonimas();
            for(Mensagem m : msgAnonimas){
                System.out.println(m.getTextoCompletoAExibir());
            }

            Amigo searchEmail = s1.pesquisaAmigo("maria@gmail.com");
            if(searchEmail.equals("maria@gmail.com")) {
                System.out.println("OK");
            }

            s1.pesquisaAmigoSecreto("maria@gmail.com");

            System.out.println("Todas mensagens");
            s1.pesquisarTodasMensagens();

        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Erro no programa. Tente novamente");
        }
        
    }
}
