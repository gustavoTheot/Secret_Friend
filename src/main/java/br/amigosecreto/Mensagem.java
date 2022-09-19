package br.amigosecreto;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem(String texto, String emailRemetente, boolean anonima){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public String getTexto(){
        return texto;
    }

    public String getEmailRemetente(){
        return emailRemetente;
    }


    public void setTexto(String texto){
        this.texto = texto;
    }

    public void setEmailRemetente(String emailRemetente){
        this.emailRemetente = emailRemetente;
    }

    public abstract String getTextoCompletoAExibir();


    public boolean ehAnonimo(){
        return this.anonima;
    }

    @Override
    public String toString() {
        return "Remetente: " +getEmailRemetente() + "\nTexto: " +getTexto() + "\nAnonimidade: " +ehAnonimo()+ "\n";
    }
}
