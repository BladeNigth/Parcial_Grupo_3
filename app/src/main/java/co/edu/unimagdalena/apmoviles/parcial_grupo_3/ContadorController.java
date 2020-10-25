package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ContadorController {
    private BaseDatos bd;
    private Context c;

    public ContadorController(Context c){
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }

    public void agregarContador(Contador contador){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            //valores.put(DefBD.col_id,"1");
            valores.put(DefBD.col_codcontador,contador.getCodcontador());
            valores.put(DefBD.col_medida,contador.getMedida());
            valores.put(DefBD.col_dir,contador.getDirr());
            valores.put(DefBD.col_valor,contador.getValor());
            valores.put(DefBD.col_fecha,contador.getFecha());
            long id =sql.insert(DefBD.tabla_contador,null,valores);
            Toast.makeText(c, "Contador Registrado", Toast.LENGTH_LONG).show();

        }catch (Exception ex){
            Toast.makeText(c, "Error Agregar Contador "+ ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarEstudiante(String cod){
        String args[] = new String[] {"1"};
        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_contador,null,"id=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

}
