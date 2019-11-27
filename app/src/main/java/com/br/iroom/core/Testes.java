package com.br.iroom.core;

import com.br.iroom.model.Postagem;
import com.br.iroom.model.Salvo;
import com.br.iroom.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Testes {

    private static final Testes ourInstance = new Testes();

    private Usuario usuarioAtual;

    private Usuario usuarioConvidado;

    public static Testes getInstance() {
        return ourInstance;
    }

    private Testes() {
        this.usuarioAtual     = Core.getInstance().getUsuario();
        this.usuarioConvidado = new Usuario("Eloísa Bazzanella", "eloisa.bazzanella@gmail.com", "47-998521403", "Adora matemática");
    }

    public List<Postagem> getListPostagemFeed() {
        List<Postagem> postagens = new ArrayList<>();
        postagens.add(new Postagem(1, "Apartamento Beira Mar", "Apartamento localizado proximo ao mar"));
        postagens.add(new Postagem(2, "Apartamento Na Ladeira", "Barato pra um caramba"));
        postagens.add(new Postagem(3, "Divido apartamento 6 quartos", "Apartamento com custo baixissimo, 4 vagas disponiveis"));

        postagens.get(0).setUsuario(this.usuarioConvidado);
        postagens.get(1).setUsuario(this.usuarioConvidado);
        postagens.get(2).setUsuario(this.usuarioConvidado);

        return postagens;
    }

    public List<Salvo> getListPostagemSalvo() {
        List<Postagem> postagens = this.getListPostagemFeed();

        List<Salvo> salvos = new ArrayList<>();

        salvos.add(new Salvo(1, postagens.get(0), this.usuarioAtual));
        salvos.add(new Salvo(2, postagens.get(1), this.usuarioAtual));

        return salvos;
    }
}