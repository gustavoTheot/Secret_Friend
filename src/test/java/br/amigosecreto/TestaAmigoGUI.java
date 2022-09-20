package br.amigosecreto;

import javax.swing.*;

public class TestaAmigoGUI {
    public static void main(String[] args) throws AmigoJaExisteException, AmigoNaoSorteadoException {
        int maxMensagens = Integer.parseInt(JOptionPane.showInputDialog("Digite o máximo de mensagens suportadas pelo sistema"));

        SistemaAmigo s = new SistemaAmigo();

        int maxAmigos = Integer.parseInt(JOptionPane.showInputDialog("Digite o máximo de amigos suportadas"));
        for(int k = 0; k< maxAmigos; k++){
            String nome = JOptionPane.showInputDialog("Digite o nome da pessoa");
            String email = JOptionPane.showInputDialog("Digite o email da pessoa");

            try{
                s.cadastraAmigo(nome, email);
            }catch (AmigoJaExisteException | AmigoNaoSorteadoException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        //ArrayList<Amigo> allAmigos = s.pesquisarTodosAmigos();
        for(int k =0; k<maxAmigos; k++){
            String emailDaPessoa = JOptionPane.showInputDialog("Digite o email da pessoa");
            String emailAmigoSecreto = JOptionPane.showInputDialog("Digite o email do amigo secreto da pessoa");
            try {
                s.configuraAmigoSecreto(emailDaPessoa, emailAmigoSecreto);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        String textoMensagem = JOptionPane.showInputDialog("Digite o texto da mensagem");
        String emailRemetente = JOptionPane.showInputDialog("Digite o do remetente");
        s.enviarMesagemParaTodos(textoMensagem, emailRemetente, false);

    }
}
