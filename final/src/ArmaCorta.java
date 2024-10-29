public class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(int municiones, int alcance, String marca, int calibre String estado, Policia policia, boolean esAutomatica) {
        super(municiones, alcance, marca, calibre, estado, policia);
        this esAutomatica = esAutomatica;
    }
    public boolean isEsAutomatica() {
        return esAutomatica;
    }
    public void setEsAutomatica(boolean esAutomatica){
        this.esAutomatica = esAutomatica;
    }
    //Metodo para verificar si el arma puede disparar a mas de 200 mts
    public boolean puedeDispararAMasDe200m() {
        return getAlcance() > 200;
    }

    @Override
    public String toString(){
        return "ArmaCorta{" +
                "esAutomatica=" + esAutomatica +
                ", " + super.toString() +
                '}';
    }
}
