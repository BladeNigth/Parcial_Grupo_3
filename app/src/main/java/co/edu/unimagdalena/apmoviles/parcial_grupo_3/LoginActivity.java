package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,pass;
    Button iniciar;
    private static final String string_Preference = "datos_login";
    private static final String string_Preference_Usuario = "usuario";
    private static final String string_Preference_Password = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(obtener().equals("vacio")){

        }else{
            Intent i = new Intent(this,ListadoActivity.class);
            startActivity(i);
            finish();
        }
        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        iniciar = findViewById(R.id.login);
        iniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                if(TextUtils.isEmpty(user.getText().toString())||TextUtils.isEmpty(pass.getText().toString())){
                    Toast.makeText(this, "no puede haber datos vacion en el formulario", Toast.LENGTH_SHORT).show();
                }else {
                    sharedpreference();
                    Intent i = new Intent(this, ListadoActivity.class);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }

    public void sharedpreference(){
        SharedPreferences preferences = getSharedPreferences(string_Preference,MODE_PRIVATE);
        preferences.edit().putString(string_Preference_Usuario,user.getText().toString()).apply();
    }

    public String obtener(){
        SharedPreferences preferences = getSharedPreferences(string_Preference,MODE_PRIVATE);
        return preferences.getString(string_Preference_Usuario,"vacio");
    }
    public static void logout(Context c,String a){
        SharedPreferences preferences = c.getSharedPreferences(string_Preference,MODE_PRIVATE);
        preferences.edit().putString(string_Preference_Usuario,a).apply();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}