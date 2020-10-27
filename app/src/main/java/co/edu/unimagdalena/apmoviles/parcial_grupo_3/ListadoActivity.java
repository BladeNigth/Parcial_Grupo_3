package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListadoActivity extends AppCompatActivity  implements View.OnClickListener {
    ListView listado;
    ContadorController contadorController;
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado = findViewById(R.id.lstlistado);
        contadorController = new ContadorController(this);
        Cursor vista = contadorController.allContadores();
        ContadorCursoAdapter ccursor = new ContadorCursoAdapter(this,vista,false);
        listado.setAdapter(ccursor);
        agregar = findViewById(R.id.btnAgregar);
        agregar.setOnClickListener(this);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView dir = view.findViewById(R.id.dirrtxt);
                TextView med = view.findViewById(R.id.medidatxt);
                TextView val = view.findViewById(R.id.valortxt);
                TextView codC = view.findViewById(R.id.codcontadortxt);
                Intent l = new Intent(getApplicationContext(),EditarActivity.class);
                l.putExtra("dir",dir.getText().toString());
                l.putExtra("med",med.getText().toString());
                l.putExtra("val",val.getText().toString());
                l.putExtra("codC",codC.getText().toString());
                startActivity(l);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregar:
                Intent i = new Intent(this,AgregarActivity.class);
                startActivity(i);
                finish();
                break;
        }
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
                LoginActivity.logout(ListadoActivity.this,"vacio");
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.Agua:
                Cursor vista = contadorController.FiltroAllcontadores("Agua");
                ContadorCursoAdapter ccursor = new ContadorCursoAdapter(this,vista,false);
                listado.setAdapter(ccursor);
                break;
            case R.id.Luz:
                Cursor vista1 = contadorController.FiltroAllcontadores("Luz");
                ContadorCursoAdapter ccursor1 = new ContadorCursoAdapter(this,vista1,false);
                listado.setAdapter(ccursor1);
                break;
            case R.id.Gas:
                Cursor vista2 = contadorController.FiltroAllcontadores("Gas");
                ContadorCursoAdapter ccursor2 = new ContadorCursoAdapter(this,vista2,false);
                listado.setAdapter(ccursor2);
        }

        return super.onOptionsItemSelected(item);
    }


}