package br.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private ArrayList<Mensagem> mensagens;
    private ArrayList<Amigo> amigos;

    public SistemaAmigo(ArrayList<Mensagem> mensagems, ArrayList<Amigo> amigos) {
        this.mensagens = mensagems;
        this.amigos = amigos;
    }

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }


    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(ArrayList<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public ArrayList<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Amigo> amigos) {
        this.amigos = amigos;
    }

    // falta arrumar
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException, AmigoNaoSorteadoException{
        boolean existe = false;

        for(Amigo a : this.amigos){
            if (a.getEmail().equals(emailAmigo)){
                throw new AmigoJaExisteException("Email do amigo já existe");
            }
        }

        if(!existe){
            Amigo a1 = new Amigo(nomeAmigo, emailAmigo);
            this.amigos.add(a1);
        }

    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        for(Amigo a : amigos){
            if(a.getEmail().equals(emailAmigo)) {
                return a;
            }
        }

        throw new AmigoInexistenteException("Não foi encontrado nenhum usuário com esse email " + emailAmigo);
    }

    // falta arrumar
    public void enviarMesagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem m2 = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(m2);
    }

    public void addMensagem(Mensagem m){
        this.mensagens.add(m);
    }

    // ok
    public void enviarmensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem m1 = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(m1);
    }

    public ArrayList<Mensagem> pesquisarMensagensAnonimas(){
        ArrayList<Mensagem> pesquisamensagensAnonimas = new ArrayList<>();

        for(Mensagem m : this.mensagens){
            if(m.ehAnonimo()){
                pesquisamensagensAnonimas.add(m);
            }
        }

        return pesquisamensagensAnonimas;
    }

    public ArrayList<Mensagem> pesquisarTodasMensagens(){
        ArrayList<Mensagem> pesquisarTodasMensagens = new ArrayList<>();

        for(Mensagem m: this.mensagens){
            System.out.println(m);
            pesquisarTodasMensagens.add(m);
        }

        return pesquisarTodasMensagens;
    }

    // falta arrumar
    public void configuraAmigoSecreto(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        boolean amigoExiste = false;

        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                for(Amigo amigoSecreto : this.amigos){
                    if(amigoSecreto.getEmail().equals(emailAmigoSorteado)){
                        a.setEmailAmigoSorteado(emailAmigoSorteado);
                        amigoExiste = true;
                        System.out.println("\nEmail da pessoa: " + a.getEmail() + "\nNome da Pessoa: " + a.getNome() + "\nEmail do amigo sorteado: " + a.getEmailAmigoSorteado() );
                    }
                }
                break;
            }
        }

        if(!amigoExiste) {
            throw new AmigoInexistenteException("Amigo não encontrada para a configuração do amigo secreto");
        }
    }

    public String pesquisaAmigoSecreto(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{

        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                String amigoSecreto = a.getEmailAmigoSorteado();
                if(amigoSecreto == null){
                    throw new AmigoNaoSorteadoException("Amigo não configurado");
                }else{
                    return amigoSecreto;
                }
            }
        }

        throw new AmigoInexistenteException("Pessoa inexistente");

    }

    // plus
    public void pesquisarTodosAmigos(){
        for(Amigo a: this.amigos){
            System.out.println(a);
        }
    }


    @Override
    public String toString() {
        String amigos = "";

        for(Amigo a: this.amigos){
            amigos = a.toString();
        }

        return amigos;
    }

}
