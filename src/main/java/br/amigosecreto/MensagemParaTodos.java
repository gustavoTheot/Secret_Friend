package br.amigosecreto;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima );
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonimo() == true){
            return "Mensagem para todos:" + getTexto();
        }else{
            return "Mensagem de " + getEmailRemetente() + "para todos." + getTexto();
        }


    }
}
