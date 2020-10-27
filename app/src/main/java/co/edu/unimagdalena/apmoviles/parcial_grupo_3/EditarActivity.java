package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class EditarActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText dirrecion,valor;
    TextView CodCont;
    Spinner medida;
    Bundle datos;
    ContadorController cc;
    String dir,ccont,dmedida,dvalor,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        dirrecion = findViewById(R.id.edtdirr);
        valor = findViewById(R.id.edtvalor);
        medida = findViewById(R.id.mmedida);
        CodCont = findViewById(R.id.codcontador);
        cc = new ContadorController(this);
        datos = getIntent().getExtras();
        dir = datos.getString("dir");
        ccont = datos.getString("codC");
        dmedida = datos.getString("med");
        dvalor = datos.getString("val");
        id = datos.getString("id");
        dirrecion.setText(dir);
        valor.setText(dvalor);
        CodCont.setText(ccont);

        if(dmedida.equals("Agua")){
            String[] lista = {"Agua","Luz","Gas"};
            medida.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lista));
        }else if(dmedida.equals("Luz")){
            String[] lista = {"Luz","Agua","Gas"};
            medida.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lista));
        }else{
            String[] lista = {"Gas","Luz","Agua"};
            medida.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lista));
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menueditar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.logout:
                LoginActivity.logout(EditarActivity.this,"vacio");
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.modificar:
                cc.Modificar(dirrecion.getText().toString(),valor.getText().toString(),medida.getSelectedItem().toString(),CodCont.getText().toString());
                Intent lanzar = new Intent(this,ListadoActivity.class);
                startActivity(lanzar);
                finish();
                break;

            case R.id.eliminar:
                cc.Eliminar(ccont);
                Intent l = new Intent(this,ListadoActivity.class);
                startActivity(l);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, ListadoActivity.class);
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}