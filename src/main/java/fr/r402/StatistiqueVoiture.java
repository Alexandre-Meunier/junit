package fr.r402;

import java.util.ArrayList;

public class StatistiqueVoiture implements Statistique {

    private ArrayList<Voiture> voitures;

    public StatistiqueVoiture(){
        voitures = new ArrayList<Voiture>();
    }

    @Override
    public void ajouter(Voiture voiture) {
        voitures.add(voiture);
    }

    /**
     * Pas fini, cela ne fait pas de remise pour chaque 5 voitures mais pour toutes les voitures si remises
     */
    @Override
    public int prix() throws ArithmeticException {

        int nbVoitures = nbVoitures();
        System.out.println(nbVoitures());

        if(nbVoitures==0){
            throw new ArithmeticException("Il n'y a pas de voiture");
        }

        int prix = 0;
        boolean remise=false;
        int remisePrix=0;

        System.out.println("nb1 : " + nbVoitures + "; nb2 : " + nbVoitures());

        while(nbVoitures%5!=0){
            prix += (int) voitures.get(nbVoitures-1).getPrix();
            nbVoitures-=1;
            remise = true;
        }
        System.out.println(prix);

        if(remise){
            while(nbVoitures>=0){
                System.out.println(nbVoitures);
                Voiture voiture = voitures.get(nbVoitures);

                int r = (int) (voiture.getPrix() * 0.05);
                remisePrix += r;
                prix += (int) (voiture.getPrix() * 0.95);

                System.out.println("prix : " + prix);
                nbVoitures -= 1;

            }
        }

        return prix;
    }

    public ArrayList<Voiture> getVoitures(){
        return voitures;
    }

    @Override
    public String toString() {
        String s = "Service : \n";
        for(int i=0;i<nbVoitures();i++){
            s += "data.Voiture " + (i+1) + " : " + voitures.get(i).toString() + " \n";
        }
        return s;
    }

    private int nbVoitures(){
        return voitures.size();
    }
}
