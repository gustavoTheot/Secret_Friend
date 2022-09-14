package br.amigosecreto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SistemaAmigo s1 = new SistemaAmigo(new ArrayList<Mensagem>(), new ArrayList<Amigo>());
        /*
        try {
            s1.cadastraAmigo("Jose", "jose@gmail.com");
            s1.cadastraAmigo("Maria", "maria@gmail.com");

            s1.configuraAmigoSecreto("jose@gmail.com", "jose@gmail.com");

            s1.enviarmensagemParaAlguem("Isso é um segredo meu amigo", "maria@gmail.com", "jose@gmail.com", true);
            s1.enviarMesagemParaTodos("Vocês todos vão saber", "maria@gmail.com", true);

            String pesquisarEmailAMigoSecreto = s1.pesquisaAmigo("maria@gmail.com");
            if(pesquisarEmailAMigoSecreto.equals("maria@gmail.com")){
                System.out.println("OK");
            }

        }catch (AmigoNaoSorteadoException e){
            JOptionPane.showInputDialog(null, e.getMessage());
        }catch (AmigoInexistenteExceptioin e){
            JOptionPane.showInputDialog(null, e.getMessage());
        }catch (Exception e){
            JOptionPane.showInputDialog(null, "Erro no programa. Tente novamente");
        }
        */


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
    }
}
