package br.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap(Map<String, Mensagem> mensagens, Map<String, Amigo> amigos) {
        this.mensagens = mensagens;
        this.amigos = amigos;
    }


    public SistemaAmigoMap(){
        this.mensagens = new HashMap<>();
        this.amigos = new HashMap<>();
    }


    public Map<String, Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Map<String, Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Map<String, Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(Map<String, Amigo> amigos) {
        this.amigos = amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException, AmigoNaoSorteadoException{
        if(!this.amigos.containsKey(emailAmigo)){
            Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
            this.amigos.put(emailAmigo, novoAmigo);
        }else{
            throw new AmigoJaExisteException("Amigo já existente");
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
            Amigo a = this.amigos.get(emailAmigo);
            if(a==null) {
                throw new AmigoInexistenteException("Amigo inexistente");
            }else {
                return a;
            }
    }

    public void enviarMesagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem m1 = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.put("", m1);
    }

    public void addMensagem(Mensagem m){
        this.mensagens.put(null, m);
    }

    public void enviarmensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem m1 = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.put(emailRemetente, m1);
    }

    public ArrayList<Mensagem> pesquisarMensagensAnonimas(){
        ArrayList<Mensagem> pesquisamensagensAnonimas = new ArrayList<>();

        for(Mensagem m : this.mensagens.values()){
            if(m.ehAnonimo()){
                pesquisamensagensAnonimas.add(m);
                System.out.println(pesquisamensagensAnonimas);
            }
        }

        return pesquisamensagensAnonimas;
    }

    public HashMap<String, Mensagem> pesquisarTodasMensagens(){
        HashMap<String, Mensagem> mensagemHashMap = new HashMap<>();
        for(Mensagem m : this.mensagens.values()){
            mensagemHashMap.put("", m);
            System.out.println(m);
        }


        return mensagemHashMap;
    }

    public void configuraAmigoSecreto(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        boolean amigoExiste = false;

        for(Amigo a: this.amigos.values()){
            if(a.getEmail().equals(emailDaPessoa)){
                for(Amigo amigoSecreto : this.amigos.values()){
                    if(amigoSecreto.getEmail().equals(emailAmigoSorteado)){
                        a.setEmailAmigoSorteado(emailAmigoSorteado);
                        amigoExiste = true;
                        //System.out.println("\nEmail da pessoa: " + a.getEmail() + "\nNome da Pessoa: " + a.getNome() + "\nEmail do amigo sorteado: " + a.getEmailAmigoSorteado() );
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
        for(Amigo a: this.amigos.values()){
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
        for(Amigo a : this.amigos.values()){
            System.out.println(a);
        }


    }



}
