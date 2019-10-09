package com.br.iroom.view.feed;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;
import com.br.iroom.model.Postagem;
import com.br.iroom.view.adapter.PostagemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Activity do Feed de postagens
 * @author Jean Poffo
 * @since 09/10/2019
 */
public class FeedActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPostagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_feed);

        this.recyclerViewPostagens = findViewById(R.id.recyclerViewPostagens);
        this.recyclerViewPostagens.setLayoutManager(new LinearLayoutManager(this));

        this.testRecyclerViewPost();
    }

    private void testRecyclerViewPost() {
        List<Postagem> postagens = new ArrayList<>();
        postagens.add(new Postagem(1, "Apartamento Beira Mar", "Apartamento localizado proximo ao mar"));
        postagens.add(new Postagem(2, "Apartamento Na Ladeira", "Barato pra um caramba"));
        postagens.add(new Postagem(3, "Divido apartamento 6 quartos", "Apartamento com custo baixissimo, 4 vagas disponiveis"));

        this.recyclerViewPostagens.setAdapter(new PostagemAdapter(this, postagens));
    }
}