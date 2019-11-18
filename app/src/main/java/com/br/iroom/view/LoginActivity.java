package com.br.iroom.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.br.iroom.R;
import com.br.iroom.core.Core;
import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

/**
 * Classe de Main Activity da Aplicação
 * @author Jean Poffo
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build(), new AuthUI.IdpConfig.GoogleBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                      .createSignInIntentBuilder()
                      .setAvailableProviders(providers)
                      .setLogo(R.mipmap.ic_logo_bed)
                      .setTheme(R.style.AppTheme)
                      .build(),
                1
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Core.getInstance().init(this.getApplicationContext());

                Toast.makeText(this, "Bem Vindo " + Core.getInstance().getUsuario().getNome(), Toast.LENGTH_LONG).show();

                startActivity(new Intent(this, MainActivity.class));
            }
            else {
                Toast.makeText(this, "Login incorreto!", Toast.LENGTH_LONG).show();
            }
        }
    }
}