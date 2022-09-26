package br.amigosecreto;

public class SistemaAmigoMapTest {

    public static void main(String[] args) throws AmigoJaExisteException, AmigoNaoSorteadoException, AmigoInexistenteException {
        SistemaAmigoMap sap = new SistemaAmigoMap();


        try{
            // cadastra
            sap.cadastraAmigo("Eduarda", "maria@gmail.com");
            sap.cadastraAmigo("Gustavo", "gustavo@gmail.com");

            // configura amigo
            sap.configuraAmigoSecreto("maria@gmail.com", "gustavo@gmail.com");

            // pesquisar todos amigos
            sap.pesquisarTodosAmigos();

            // pesquisar amigo
            //System.out.println("\npesquisa amigo: " + sap.pesquisaAmigo("maria@gmail.com") + "\n");

            // enviar mensagens
            sap.enviarMesagemParaTodos("Isso é uma noticia para todos", "maria@gmail.com", true);
            sap.enviarmensagemParaAlguem("Boa noite", "maria@gmail.com", "gustavo@gmail.com", false);
            sap.enviarmensagemParaAlguem("Bom dia", "gustavo@gmail.com", "maria@gmail.com", true);


            // pesquisar mensagens
            System.out.println("\nmensagem anonima: ");
            sap.pesquisarMensagensAnonimas();
            System.out.println("\ntodoas as mensagens: ");
            sap.pesquisarTodasMensagens();

            System.out.println(sap.pesquisaAmigoSecreto("maria@gmail.com"));


        }catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e){
            System.out.println(e.getMessage());
        }

    }

}
