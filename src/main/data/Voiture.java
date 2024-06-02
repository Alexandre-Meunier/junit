package data;

public class Voiture {

    private String marque;
    private int prix;

    public Voiture(String marque, int prix) {
        setMarque(marque);
        setPrix(prix);
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) throws ArithmeticException {
        if(prix < 0){
            throw new ArithmeticException("Prix négatif!");
        }
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "marque = " + marque + ", prix = " + prix;
    }
}
