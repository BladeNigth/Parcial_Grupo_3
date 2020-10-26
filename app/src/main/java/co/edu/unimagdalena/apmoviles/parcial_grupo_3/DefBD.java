package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import java.util.Date;

public class DefBD {

        public static final String nameDb ="ServiciosPublicos";
        public static final String tabla_contador = "contador";
        public static final String col_dir = "dirrecion";
        public static final String col_codcontador = "codcontador";
        public static final String col_valor = "valor";
        public static final String col_medida = "medida";
        public static final String col_fecha = "fecha";

    public static final String create_tabla_contador = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_contador + " ( " +
            DefBD.col_codcontador + " text primary key," +
            DefBD.col_medida + " text," +
            DefBD.col_dir + " text," +
            DefBD.col_valor + " text," +
            DefBD.col_fecha + " text" +
            ");";

}
