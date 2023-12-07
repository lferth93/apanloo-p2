package uam.apanloo.biblioteca;

public class Direccion {
    String calle;
    int numero;
    String cp;
    Pais pais;

    public Direccion(String calle, int numero, String cp, String pais) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.pais = Pais.valueOf(pais);
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getPais() {
        return pais.toString();
    }
    public void setPais(String pais) {
        this.pais = Pais.valueOf(pais);
    }
}
