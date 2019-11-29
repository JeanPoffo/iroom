package com.br.iroom.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.br.iroom.R;
import com.br.iroom.controller.ControllerBaseActivity;
import com.br.iroom.controller.ControllerMain;
import com.br.iroom.model.Usuario;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Classe principal de Activity do Sistema
 * @author Jean Poffo
 */
public class MainActivity extends AppCompatActivity implements BindDataView {

    private static final int ADICIONAR_REQUEST_CODE = 10;

    private AppBarConfiguration appBarConfiguration;
    private CircleImageView imageViewFotoPerfil;
    private TextView textViewNomeUsuario;
    private TextView textViewBiografiaUsuario;

    private ControllerBaseActivity controller;

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public AppBarConfiguration getAppBarConfiguration() {
        return appBarConfiguration;
    }

    public CircleImageView getImageViewFotoPerfil() {
        return imageViewFotoPerfil;
    }

    public TextView getTextViewNomeUsuario() {
        return textViewNomeUsuario;
    }

    public TextView getTextViewBiografiaUsuario() {
        return textViewBiografiaUsuario;
    }

    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setupAppBar();
        this.setupNavigationView();

        this.controller = new ControllerMain(this);

//        startActivity(new Intent(this.getApplicationContext(), FiltroActivity.class));
    }

    private void setupAppBar() {
        setSupportActionBar(findViewById(R.id.toolbar));

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_feed, R.id.nav_mensagens, R.id.nav_salvos, R.id.nav_configuracoes)
                                                     .setDrawerLayout(findViewById(R.id.drawer_layout))
                                                     .build();

        NavigationView navigationView = findViewById(R.id.nav_view);
        NavController navController   = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void setupNavigationView() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView               = navigationView.getHeaderView(0);
        this.imageViewFotoPerfil      = headerView.findViewById(R.id.imageViewFotoPerfil);
        this.textViewNomeUsuario      = headerView.findViewById(R.id.textViewNomeUsuario);
        this.textViewBiografiaUsuario = headerView.findViewById(R.id.textViewBiografiaUsuario);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_item_buscar:
                startActivity(new Intent(this.getApplicationContext(), FiltroActivity.class));
                return true;

            case R.id.action_item_adicionar:
                startActivityForResult(new Intent(this.getApplicationContext(), AdicionarPostagemActivity.class), ADICIONAR_REQUEST_CODE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADICIONAR_REQUEST_CODE && resultCode == RESULT_OK) {
            RecyclerView recyclerViewPostagens = findViewById(R.id.recyclerViewPostagens);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void bindDataToModel(Object entidade) {}

    @Override
    public void bindDataFromModel(Object entidade) {
        Usuario usuario = (Usuario) entidade;
        this.imageViewFotoPerfil.setImageBitmap(usuario.getFotoPerfil());
        this.textViewNomeUsuario.setText(usuario.getNome());
        this.textViewBiografiaUsuario.setText(usuario.getEmail());
    }
}