package com.br.iroom.core;

import com.br.iroom.model.Postagem;
import com.br.iroom.model.Salvo;
import com.br.iroom.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class LocalDatabase {

    private static LocalDatabase instance;

    private Usuario usuarioAtual;

    private Usuario usuarioConvidado;

    private List<Postagem> postagens;

    private List<Salvo> salvos;

    public static synchronized LocalDatabase getInstance() {
        if(instance == null) {
            instance = new LocalDatabase();
        }
        return instance;
    }

    private LocalDatabase() {
        this.usuarioAtual     = Core.getInstance().getUsuario();
        this.usuarioConvidado = new Usuario("Eloísa Bazzanella", "eloisa.bazzanella@gmail.com", "47-998521403", "Adora matemática");
        this.postagens        = initPostagens();
        this.salvos           = initSalvos();
    }

    public List<Postagem> getListPostagemFeed() {
        return postagens;
    }

    public List<Salvo> getListPostagemSalvo() {
        List<Salvo> salvosUsuario = new ArrayList<>();
        for(Salvo salvo : salvos) {
            if(salvo.getUsuario().getFirebaseUser().getUid() == usuarioAtual.getFirebaseUser().getUid()) {
                salvosUsuario.add(salvo);
            }
        }
        return salvosUsuario;
    }

    public synchronized void addPostagem(Postagem postagem) {
        postagem.setCodigo(nextCodigoPostagem());
        postagens.add(postagem);
    }

    private List<Postagem> initPostagens() {
        List<Postagem> postagens = new ArrayList<>();

        postagens.add(new Postagem(1, "Apartamento Beira Mar", "Apartamento localizado proximo ao mar"));
        postagens.add(new Postagem(2, "Apartamento Na Ladeira", "Barato pra um caramba"));
        postagens.add(new Postagem(3, "Divido apartamento 6 quartos", "Apartamento com custo baixissimo, 4 vagas disponiveis"));

        postagens.get(0).setUsuario(this.usuarioConvidado);
        postagens.get(1).setUsuario(this.usuarioConvidado);
        postagens.get(2).setUsuario(this.usuarioConvidado);

        return postagens;
    }

    private List<Salvo> initSalvos() {
        List<Salvo> salvos = new ArrayList<>();

        salvos.add(new Salvo(1, postagens.get(0), this.usuarioAtual));
        salvos.add(new Salvo(2, postagens.get(1), this.usuarioAtual));

        return salvos;
    }

    public synchronized void removeSalvo(Salvo salvo) {
        int indice = salvos.indexOf(salvo);
        if(indice >= 0) {
            salvos.remove(indice);
        }
    }

    public synchronized void addPostagemSalvo(Postagem postagem) {
        Salvo salvo = new Salvo();
        salvo.setCodigo(nextCodigoSalvo());
        salvo.setPostagem(postagem);
        salvo.setUsuario(this.usuarioAtual);
        salvos.add(salvo);
    }

    private Long nextCodigoPostagem() {
        Long codigo = 0L;
        for(Postagem postagem : postagens) {
            if(postagem.getCodigo() > codigo) {
                codigo = postagem.getCodigo();
            }
        }
        return codigo + 1;
    }

    private long nextCodigoSalvo() {
        Long codigo = 0L;
        for(Salvo salvo : salvos) {
            if(salvo.getCodigo() > codigo) {
                codigo = salvo.getCodigo();
            }
        }
        return codigo + 1;
    }
}