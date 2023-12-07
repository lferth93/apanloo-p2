package uam.apanloo.biblioteca;

public class Fecha implements Comparable<Fecha>{

    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public int compareTo(Fecha o) {
        if (anio == o.anio){
            if(mes == o.mes)
                return dia- o.dia;
            
            return mes - o.mes;
        }
        return anio - o.anio;
    }

    @Override 
    public String toString(){
        return String.format("%d/%d/%d", dia, mes, anio);
    }

}
