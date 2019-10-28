package com.br.iroom.view;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.br.iroom.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Classe principal de Activity do Sistema
 * @author Jean Poffo
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ImageView imageViewFotoPerfil;
    private TextView textViewNomeUsuario;
    private TextView textViewBiografiaUsuario;

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public AppBarConfiguration getAppBarConfiguration() {
        return appBarConfiguration;
    }

    public void setAppBarConfiguration(AppBarConfiguration appBarConfiguration) {
        this.appBarConfiguration = appBarConfiguration;
    }

    public ImageView getImageViewFotoPerfil() {
        return imageViewFotoPerfil;
    }

    public void setImageViewFotoPerfil(ImageView imageViewFotoPerfil) {
        this.imageViewFotoPerfil = imageViewFotoPerfil;
    }

    public TextView getTextViewNomeUsuario() {
        return textViewNomeUsuario;
    }

    public void setTextViewNomeUsuario(TextView textViewNomeUsuario) {
        this.textViewNomeUsuario = textViewNomeUsuario;
    }

    public TextView getTextViewBiografiaUsuario() {
        return textViewBiografiaUsuario;
    }

    public void setTextViewBiografiaUsuario(TextView textViewBiografiaUsuario) {
        this.textViewBiografiaUsuario = textViewBiografiaUsuario;
    }
    // </editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageViewFotoPerfil = findViewById(R.id.imageViewFotoPerfil);
        this.textViewNomeUsuario = findViewById(R.id.textViewNomeUsuario);
        this.textViewNomeUsuario = findViewById(R.id.textViewBiografiaUsuario);

        this.initAppBar();
        this.setDadosUsuarioAppBar();
    }

    private void initAppBar() {
        setSupportActionBar(findViewById(R.id.toolbar));

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_feed, R.id.nav_mensagens, R.id.nav_salvos, R.id.nav_configuracoes)
                                                     .setDrawerLayout(findViewById(R.id.drawer_layout))
                                                     .build();

        NavigationView navigationView = findViewById(R.id.nav_view);
        NavController navController   = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void setDadosUsuarioAppBar() {
        //FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //this.textViewNomeUsuario.setText(firebaseUser.getDisplayName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.searchable, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}