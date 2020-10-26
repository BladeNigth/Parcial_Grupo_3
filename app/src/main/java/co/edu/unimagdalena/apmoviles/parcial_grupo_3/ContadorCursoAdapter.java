package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ContadorCursoAdapter extends CursorAdapter {
    public ContadorCursoAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_adaptador,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id = view.findViewById(R.id.idtxt);
        TextView dir = view.findViewById(R.id.dirrtxt);
        TextView med = view.findViewById(R.id.medidatxt);
        TextView val = view.findViewById(R.id.valortxt);
        TextView codC = view.findViewById(R.id.codcontadortxt);
        TextView fech = view.findViewById(R.id.fechatxt);
        String Id = cursor.getString(0);
        String dirrecion = cursor.getString(1);
        String medida = cursor.getString(2);
        String valor = cursor.getString(3);
        String codcontador = cursor.getString(4);
        String fecha = cursor.getString(5);
        id.setText(Id);
        dir.setText(dirrecion);
        med.setText(medida);
        val.setText(valor);
        codC.setText(codcontador);
        fech.setText(fecha);
    }
}
