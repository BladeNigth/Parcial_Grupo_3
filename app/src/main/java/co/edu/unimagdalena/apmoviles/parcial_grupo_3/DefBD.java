package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

import java.util.Date;

public class DefBD {

        public static String nameDb ="ServiciosPublicos";
        public static String tabla_contador = "contador";
        public static String col_dir = "dirrecion";
        public static String col_codcontador = "codcontador";
        public static String col_valor = "valor";
        public static String col_medida = "medida";
        public static String col_fecha = "fecha";

    public static final String create_tabla_contador = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_contador + " ( " +
            DefBD.col_codcontador + "text primary key," +
            DefBD.col_medida + "text," +
            DefBD.col_dir + "text," +
            DefBD.col_valor + "numeric," +
            DefBD.col_fecha + "real" +
            ");";

            ;

}
