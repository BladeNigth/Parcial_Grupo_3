package co.edu.unimagdalena.apmoviles.parcial_grupo_3;

public class Contador {
    private String codcontador;
    private String medida;
    private String dirr;
    private int valor;
    private String fecha;

    public Contador(String codcontador, String medida, String dirr, int valor, String fecha) {
        this.codcontador = codcontador;
        this.medida = medida;
        this.dirr = dirr;
        this.valor = valor;
        this.fecha = fecha;
    }

    public String getCodcontador() {
        return codcontador;
    }

    public void setCodcontador(String codcontador) {
        this.codcontador = codcontador;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDirr() {
        return dirr;
    }

    public void setDirr(String dirr) {
        this.dirr = dirr;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "codcontador='" + codcontador + '\'' +
                ", medida='" + medida + '\'' +
                ", dirr='" + dirr + '\'' +
                ", valor=" + valor +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
