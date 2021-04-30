package com.example.sesion05_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sesion05_menu.entity.Alumno;

public class AlumnoActivity extends AppCompatActivity {

    EditText nombre,apellido,dni,correo,fechanac,fechareg;
    Button btnregis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

    nombre = findViewById(R.id.txtNombre);
    apellido = findViewById(R.id.txtApellido);
    dni = findViewById(R.id.txtdni);
    correo = findViewById(R.id.txtCorreo);
    fechanac = findViewById(R.id.txtFechaNac);
    fechareg = findViewById(R.id.txtFechaReg);
    btnregis = findViewById(R.id.btnRegistrar);

    btnregis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nom=nombre.getText().toString();
            String ape=apellido.getText().toString();
            String d= dni.getText().toString();
            String email=correo.getText().toString();
            String fnac=fechanac.getText().toString();
            String freg=fechareg.getText().toString();

            if(!nom.matches("[a-zA-ZáéíóúÁÉÍÓÚ\\s]{2,45}"))
            {
                mensaje("\"El nombre es de 2 a 45 caracteres\"");
                return;
            }else if (!ape.matches("[a-zA-ZáéíóúÁÉÍÓÚ\\s]{2,45}"))
            {
                mensaje("\"El apellido es de 2 a 45 caracteres\"");
                return;
            }else if(!d.matches("[0-9]{8}")) {
                mensaje("\"El dni es de 8 caracteres\"");
                return;
            }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches())
            {
                mensaje("\"Correo invalido\"");
                return;
            }else if (!fnac.matches("([0-9]+|([0-9]{2}+[/]+[0-9]{2}+[/]+[0-9]{4}))")){
                mensaje("\"Ingresar fecha de nacimiento así dd/mm/aaaa\"");
                return;

            }else if(!freg.matches("([0-9]+|([0-9]{2}+[/]+[0-9]{2}+[/]+[0-9]{4}))")){
                mensaje("\"Ingresar fecha de registro así dd/mm/aaaa\"");
                return;

            }else
            {
                Alumno a = new Alumno();
                a.setNombre(nom);
                a.setApellido(ape);
                a.setDni(d);
                a.setCorreo(email);
                a.setFechanac(fnac);
                a.setFechareg(freg);

                String msj ="Bienvenido(A) :D \n";
                msj += "Nombre: "+a.getNombre()+"\n";
                msj += "Apellido: "+a.getApellido()+"\n";
                msj += "Dni: "+a.getDni()+"\n";
                msj += "Correo: "+a.getCorreo()+"\n";
                msj += "Fecha de nacimiento: "+a.getFechanac()+"\n";
                msj += "Fecha de registro: "+a.getFechareg()+"\n";
                mensaje(msj);
            }

        }
    });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.idMenAlumno){
            Intent intent = new Intent(this, LibroActivity.class);
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

    public void mensaje(String msj){
        AlertDialog.Builder alert = new AlertDialog.Builder( this);
        alert.setTitle("Confirmación");
        alert.setMessage(msj);
        alert.show();
    }
}