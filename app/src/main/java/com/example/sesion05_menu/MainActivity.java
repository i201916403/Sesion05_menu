package com.example.sesion05_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.idMenAlumno){
            Intent intent = new Intent(this, AlumnoActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.idMenAutor){
            Intent intent = new Intent(this, AutorActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.idMenLibro){
            Intent intent = new Intent(this, LibroActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}