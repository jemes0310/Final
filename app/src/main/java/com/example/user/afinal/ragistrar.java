package com.example.user.afinal;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.afinal.database.Usuarios;
import com.example.user.afinal.database.UsuariosReferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ragistrar extends AppCompatActivity implements View.OnClickListener {
EditText nombre,apellido,correo,telefono,contraseña,fecha;
Button nregistrar;
TextView nrlogin;
ProgressDialog mensaje;
private FirebaseAuth mAuth;
DatabaseReference usuariosR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth= FirebaseAuth.getInstance();
        FirebaseDatabase pasientes=FirebaseDatabase.getInstance();
        usuariosR=pasientes.getReference(UsuariosReferences.Usuarios_Reference);
        nombre=(EditText) findViewById(R.id.agregarNombre);
        apellido=(EditText) findViewById(R.id.agregarApellido);
        correo=(EditText) findViewById(R.id.agregarCorreo);
        telefono=(EditText) findViewById(R.id.agregarTelefono);
        contraseña=(EditText) findViewById(R.id.agregarContraseña);
        fecha=(EditText) findViewById(R.id.fechaNacimiento);
        nregistrar=(Button) findViewById(R.id.registrar);
        nrlogin=(TextView) findViewById(R.id.rLogin);

        mensaje= new ProgressDialog(this);
        nregistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    registrarUsuario();
    }

    private void registrarUsuario() {
        final String nnombre= nombre.getText().toString().trim();
        final String napellido= apellido.getText().toString().trim();
        final String ncorreo= correo.getText().toString().trim();
        final String ntelefono= telefono.getText().toString().trim();
        final String ncontraseña= contraseña.getText().toString().trim();
        final String nfecha= fecha.getText().toString().trim();

        if (TextUtils.isEmpty(ncorreo)){
            Toast.makeText(this,"Por favor ingrese un correo electronico", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(ncontraseña)){
            Toast.makeText(this,"Por favor ingrese la contraseña", Toast.LENGTH_LONG).show();
            return;
        }
        mensaje.setMessage("Espere mentras realizamos su solicitud");
        mensaje.show();

        mAuth.createUserWithEmailAndPassword(ncorreo,ncontraseña)
                .addOnCompleteListener(ragistrar.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                        }else {
                            Toast.makeText(getApplicationContext(),"Algo salio mal vuelva a intentarlo",Toast.LENGTH_LONG).show();
                            Usuarios usurio= new Usuarios(nnombre,napellido,ncorreo,ntelefono,nfecha);
                            usuariosR.push().setValue(usurio);
                        }
                        mensaje.dismiss();
                    }
                });
    }
}
