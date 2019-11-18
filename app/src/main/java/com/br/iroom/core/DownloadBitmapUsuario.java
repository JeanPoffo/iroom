package com.br.iroom.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.br.iroom.model.Usuario;

import java.io.IOException;
import java.net.URL;

public class DownloadBitmapUsuario extends AsyncTask<Uri, Void, Bitmap> {

    private Usuario usuario;

    public DownloadBitmapUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    protected Bitmap doInBackground(Uri... uris) {
        try {
            return BitmapFactory.decodeStream(new URL(uris[0].toString()).openConnection().getInputStream());
        }
        catch (IOException e) {
            Log.d("I/O Exception", e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        this.usuario.setFotoPerfil(bitmap);
    }
}