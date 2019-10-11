package com.br.iroom.view;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.br.iroom.R;
import com.google.android.material.navigation.NavigationView;

/**
 * Classe principal de Activity do Sistema
 * @author Jean Poffo
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        appBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_feed, R.id.nav_mensagens, R.id.nav_salvos, R.id.nav_configuracoes)
                                                     .setDrawerLayout(findViewById(R.id.drawer_layout))
                                                     .build();

        NavigationView navigationView = findViewById(R.id.nav_view);
        NavController navController   = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
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