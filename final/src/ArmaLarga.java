public class ArmaLarga extends Arma {
    private boolean selloRENAR;
    private String descripcionUso;
    private int nivel;

    public ArmaLarga(int municiones, int alcance, String marca, int calibre, String estado, Policia policia, boolean selloRENAR, String descripcionUso, int nivel) {
        super(municiones, alcance, marca, calibre, estado, policia);
        this.selloRENAR = selloRENAR;
        this.descripcionUso = descripcionUso;
        this.nivel = nivel;
    }

    public boolean isSelloRENAR() {
        return selloRENAR;
    }

    public void setSelloRENAR(boolean selloRENAR) {
        this.selloRENAR = selloRENAR;
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public void setDescripcionUso(String descripcionUso) {
        this.descripcionUso = descripcionUso;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // Método para comparar armas largas
    public boolean esMayorQue(ArmaLarga otraArma) {
        return this.nivel > otraArma.getNivel();
    }

    @Override
    public String toString() {
        return "ArmaLarga{" +
                "selloRENAR=" + selloRENAR +
                ", descripcionUso='" + descripcionUso + '\'' +
                ", nivel=" + nivel +
                ", " + super.toString() +
                '}';
    }
}