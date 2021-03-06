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

    public Cursor allContadores(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor d = sql.rawQuery("select codcontador as _id, dirrecion, medida, valor, fecha from contador",null);
            return d;
        }catch (Exception ex){
            Toast.makeText(c, "Error en la consulta" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public Cursor FiltroAllcontadores(String m){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            if(m.equals("Agua")){
                Cursor d = sql.rawQuery("select codcontador as _id, dirrecion, medida, valor, fecha from contador where medida='Agua'",null);
                return d;
            }else if(m.equals("Luz")){
                Cursor d = sql.rawQuery("select codcontador as _id, dirrecion, medida, valor, fecha from contador where medida='Luz'",null);
                return d;
            }else if(m.equals("Gas")){
                Cursor d = sql.rawQuery("select codcontador as _id, dirrecion, medida, valor, fecha from contador where medida='Gas'",null);
                return d;
            }
            return null;
        }catch (Exception ex){
            Toast.makeText(c, "Error en la consulta" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public boolean buscarContador(String cod){
        String args[] = new String[]{cod};
        SQLiteDatabase sqL = bd.getReadableDatabase();
        Cursor c = sqL.query(DefBD.tabla_contador,null,"codcontador=?",args,null,null,null);
        if(c.getCount()>0){
            bd.close();
            return true;
        }else{
            return false;
        }
    }

    public void Modificar(String d,String v, String m,String cod){
        try{
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("dirrecion",d);
            values.put("medida",m);
            values.put("valor",v);
            String[] a = new String[]{cod};
            long BD = sql.update(DefBD.tabla_contador,values,"codContador=?",a);
            Toast.makeText(c, "El Contador ha sido Modificado", Toast.LENGTH_SHORT).show();
        }catch (Exception Ex){
            Toast.makeText(c, Ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void Eliminar(String cod){
        try{
            SQLiteDatabase sql =bd.getWritableDatabase();
            String args[] = new String[]{cod};
            long l = sql.delete(DefBD.tabla_contador,"codcontador=?",args);
            Toast.makeText(c, "Se ha Borrado El Contador", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
