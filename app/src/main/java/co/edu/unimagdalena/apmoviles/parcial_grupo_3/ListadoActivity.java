package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListadoActivity extends AppCompatActivity  implements View.OnClickListener {
    Button Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        Logout = findViewById(R.id.logout);
        Logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logout:
                LoginActivity.logout(ListadoActivity.this,"vacio");
                Intent i = new Intent(this,LoginActivity.class);
                startActivity(i);
                break;
        }
    }

}