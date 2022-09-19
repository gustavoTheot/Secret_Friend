package br.amigosecreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetentem, String emailDestinatario, boolean anonimo){
        super(texto, emailRemetentem, anonimo);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        if(ehAnonimo() == true){
            return "Mensagem para: " + this.emailDestinatario + "Texto: " + getTexto();
        }else{
            return "Mensagem de:" + getEmailRemetente() + "para" + getEmailDestinatario() + "Texto:" + getTexto();
        }


    }
}
