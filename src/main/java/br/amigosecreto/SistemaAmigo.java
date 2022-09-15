package br.amigosecreto;

import java.util.ArrayList;

public class SistemaAmigo {
    private ArrayList<Mensagem> mensagens;
    private ArrayList<Amigo> amigos;

    public SistemaAmigo(ArrayList<Mensagem> mensagems, ArrayList<Amigo> amigos) {
        this.mensagens = mensagems;
        this.amigos = amigos;
    }

    // falta arrumar
    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo a1 = new Amigo(nomeAmigo, emailAmigo, "");
        this.amigos.add(a1);
    }

    public String pesquisaAmigo(String email){
        for(Amigo a : this.amigos){
            if(a.getEmail().equals(email)) {
                System.out.println("Nome: " +a.getNome()+ " Email: " +a.getEmail());
            }
        }
        return email;
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
            if(m.ehAnonimo() == true){
                System.out.println(m);
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
    public void configuraAmigoSecreto(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        boolean ehAmigo = false;
        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                ehAmigo = true;
                System.out.println(a);
            }
            if(!ehAmigo){
                throw new AmigoInexistenteException("Amigo inexistente");
            }
        }
    }

    public String pesquisaAmigoSecreto(String emailDaPessoa) throws AmigoNaoSorteadoException, AmigoInexistenteException {
        boolean amigoExiste = false;
        boolean emailPessoaExist = false;
        String amigoSecreto = "";

        for(Amigo a: this.amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                emailPessoaExist = true;
                if(a.getEmailAmigoSorteado() != ""){
                    amigoSecreto = a.getEmailAmigoSorteado();
                    amigoExiste = true;
                }
            }else if(!amigoExiste){
                throw new AmigoNaoSorteadoException("Amigo não configurado");
            }else if(!emailPessoaExist){
                throw new AmigoInexistenteException("Pessoa inexistente");
            }
        }

        return amigoSecreto;
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
