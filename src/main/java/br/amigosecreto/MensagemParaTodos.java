package br.amigosecreto;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima );
    }

    public String getTextoCompletoAExibir(){
        String mensagem = "";
        if(ehAnonimo() == true){
            mensagem = "Mensagem para todos:" + getTexto();
        }else{
            mensagem = "Mensagem de " + getEmailRemetente() + "para todos." + getTexto();
        }

        return mensagem;
    }
}
