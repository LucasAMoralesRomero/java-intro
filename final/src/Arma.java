public abstract class Arma {
    private int municiones;
    private int alcance;
    private String marca;
    private int calibre;
    private String estado;
    private Policia policia;

    public Arma(int municiones, int alcance, String marca, int calibre, String estado, Policia policia) {
        this.municiones = municiones;
        this.alcance = alcance;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
        this.policia = policia;
    }

    // Getters y Setters
    public int getMuniciones() {
        return municiones;
    }

    public void setMuniciones(int municiones) {
        this.municiones = municiones;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    // Metodo para verificar si el arma esta en condiciones para ser usada en un enfrentamiento
    public boolean estaEnCondiciones() {
        return estado.equals("EN USO") && calibre >= 9;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "municiones=" + municiones +
                ", alcance=" + alcance +
                ", marca='" + marca + '\'' +
                ", calibre=" + calibre +
                ", estado='" + estado + '\'' +
                ", policia=" + policia +
                '}';
    }
}
