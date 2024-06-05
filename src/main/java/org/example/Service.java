package org.example;

import java.util.ArrayList;

public class Service implements Statistique{

    private ArrayList<Voiture> voitures;

    private int nbRemises;

    public Service(){
        voitures = new ArrayList<Voiture>();
    }

    public Service(ArrayList<Voiture> voitures) {

        if(voitures.isEmpty()){
            this.voitures = voitures;
        }else{
            this.voitures = new ArrayList<Voiture>();
            for(int i=0;i<voitures.size();i++){
                ajouter(voitures.get(i));
            }
        }
    }

    @Override
    public void ajouter(Voiture voiture) {
        voitures.add(voiture);
        // Pas la meilleure option parce que ca créer une dépendance entre les constructeurs et ajouter()
        if(nbVoitures()%5==0){
            nbRemises += 1;
        }
    }

    /**
     * Pas fini, cela ne fait pas de remise pour chaque 5 voitures mais pour toutes les voitures si remises
     */
    @Override
    public int prix() throws ArithmeticException {

        System.out.println(nbRemises);
        if(nbVoitures()==0){
            throw new ArithmeticException("Il n'y a pas de voiture");
        }

        int prix = 0;
        int resNbRemises = nbRemises;
        float remiseTotal = 0;

        for(int i=0;i<nbVoitures();i++){
            double prixVoiture = voitures.get(i).getPrix();

            for(int e=0;e<resNbRemises;e++){
                System.out.println(remiseTotal);
                double remise = prixVoiture * 0.05f;
                if(remiseTotal+remise <= 20000){
                    prixVoiture -= remise;
                    remiseTotal += remise;
                }
            }

            prix += prixVoiture;
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
