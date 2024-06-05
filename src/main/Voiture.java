import java.util.Objects;

public class Voiture {

    private String marque;
    private double prix;

    public Voiture(String marque, double prix) {
        setMarque(marque);
        setPrix(prix);
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws ArithmeticException {
        if(prix < 0){
            throw new ArithmeticException("Prix négatif!");
        }
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "marque = " + marque + ", prix = " + prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return getPrix() == voiture.getPrix() && Objects.equals(getMarque(), voiture.getMarque());
    }
}
