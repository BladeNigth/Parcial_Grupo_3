package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    String med;
    EditText dirr,cContador,vcontador;
    Spinner medidas;
    Button agregar;
    Contador c;
    ContadorController cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        dirr = findViewById(R.id.dirr);
        cContador = findViewById(R.id.ncontador);
        vcontador = findViewById(R.id.valor);
        agregar = findViewById(R.id.btnAgregar);
        medidas = (Spinner) findViewById(R.id.medida);
        medidas.setOnItemSelectedListener(this);
        agregar.setOnClickListener(this);
        cc = new ContadorController(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregar:
                if(TextUtils.isEmpty(dirr.getText().toString()) || TextUtils.isEmpty(cContador.getText().toString())
                    || TextUtils.isEmpty(vcontador.getText().toString())) {
                    Toast.makeText(this, "no puede haber Datos Vacios en el Formulario", Toast.LENGTH_SHORT).show();

                }else{
                    med = medidas.getSelectedItem().toString();
                    String fecha = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    c = new Contador(cContador.getText().toString(),med,dirr.getText().toString()
                            ,Integer.parseInt(vcontador.getText().toString()),fecha);
                    cc.agregarContador(c);
                }





                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.logout:
                LoginActivity.logout(AgregarActivity.this,"vacio");
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}