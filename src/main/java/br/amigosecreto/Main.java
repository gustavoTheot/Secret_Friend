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

            s1.pesquisarMensagensAnonimas();

            Amigo searchEmail = s1.pesquisaAmigo("maria@gmail.com");
            if(searchEmail.equals("maria@gmail.com")) {
                System.out.println("OK");
            }

            s1.pesquisaAmigoSecreto("maria@gmail.com");

        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Erro no programa. Tente novamente");
        }


         /*
        try {
            s1.cadastraAmigo("Jose", "jose@gmail.com");
            s1.cadastraAmigo("Maria", "maria@gmail.com");
            s1.cadastraAmigo("Eduarda", "meduarda@gmail.com");
            s1.cadastraAmigo("Pablo", "pablo@gmail.com");
            s1.cadastraAmigo("Sidnei", "sidnei@gmail.com");


            s1.enviarmensagemParaAlguem("Isso é um segredo meu amigo", "maria@gmail.com", "jose@gmail.com", true);
            s1.enviarMesagemParaTodos("Vocês todos vão saber", "maria@gmail.com", true);

            // Pesquisa amigo secreto
            String pesquisarEmailAMigoSecreto = s1.pesquisaAmigo("maria@gmail.com");
            if (pesquisarEmailAMigoSecreto.equals("maria@gmail.com")) {
                System.out.println("OK");
            }

            // Pesquisa amigo pelo email
            System.out.println("\n==============Amigo pelo email==============\n");
            s1.pesquisaAmigo("maria@gmail.com");

            // Pesquisa todos os amigos
            System.out.println("\n==============Todos os amigos==============");
            s1.pesquisarTodosAmigos();

            // Pesquisar mensagem anonima
            System.out.println("\n==============Mensagens Anonimas==============\n");
            s1.pesquisarMensagensAnonimas();

            // Pesquisa todas as mensagens
            System.out.println("==============Todas as mensagens==============\n");
            s1.pesquisarTodasMensagens();

            // Configurar amigo secreto
            System.out.println("==============Confi amigo secreto==============");
            s1.configuraAmigoSecreto("meduarda@gmail.com", "pablo@gmail.com");
            s1.configuraAmigoSecreto("jose@gmail.com", "maria@gmail.com");


            // Pesquisa amigo secreto
            System.out.println("\n==============Pesquisa amigo secreto==============\n");
            s1.pesquisaAmigoSecreto("meduarda@gmail.com");



        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Erro no programa. Tente novamente");
        }




        s1.cadastraAmigo("Eduarda", "meduarda@gmail.com");
        s1.cadastraAmigo("Pablo", "pablo@gmail.com");
        s1.cadastraAmigo("Sidnei", "sidnei@gmail.com");

        //MensagemParaAlguem m1 = new MensagemParaAlguem("Você sabia que eu te amo", "gustavotheot@gmail.com", "mrodriques@gmail.com", true);
        s1.enviarmensagemParaAlguem("Você sabia que eu te amo", "gustavotheot@gmail.com", "meduarda@gmail.com", true);
        s1.enviarmensagemParaAlguem("É um teste", "pablo@gmail.com", "gustavo@gmail.com", true);
        s1.enviarmensagemParaAlguem("Mensagem não anonima", "pablo@gmail.com", "gustavo@gmail.com", false);

        // Pesquisa amigo pelo email
        System.out.println("\n==============Amigo pelo email==============\n");
        s1.pesquisaAmigo("meduarda@gmail.com");

        // Pesquisa todos os amigos

        System.out.println("\n==============Todos os amigos==============");
        s1.pesquisarTodosAmigos();

        // Pesquisar mensagem anonima
        System.out.println("\n==============Mensagens Anonimas==============\n");
        s1.pesquisarMensagensAnonimas();

        // Pesquisa todas as mensagens
        System.out.println("==============Todas as mensagens==============\n");
        s1.pesquisarTodasMensagens();

        // Configurar amigo secreto
        System.out.println("==============Confi amigo secreto==============\n");
        s1.configuraAmigoSecreto("pablo@gmail.com", "gustavo@gmail.com");


        // Pesquisa todos os amigos
        System.out.println("\n==============Todos os amigos==============");
        s1.pesquisarTodosAmigos();
         */

    }
}
