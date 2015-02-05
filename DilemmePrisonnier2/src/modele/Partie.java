/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Maïlys
 */
public class Partie extends Observable implements Serializable {

    private final ArrayList<Boolean> listA;
    private final ArrayList<Boolean> listB;
    String PATH = "C://Users/Maïlys/Desktop//partie.dat";

    /**
     * Permet de conserver chaque choix dans les listes. Permet de traiter le
     * choix, et d'attribuer les points. Utilisés pour PannelTableau.
     */
    public Partie() {
        listA = new ArrayList<>();
        listB = new ArrayList<>();
    }

    /**
     * Utilise les listes pour récupérer les choix. Traite le choix effectué, et
     * attribue points.
     *
     * @param aCoopere du cooperer. Doit etre boolean.
     * @param bCoopere du cooperer. Doit etre boolean.
     */
    public void cooperer(boolean aCoopere, boolean bCoopere) {
        listA.add(aCoopere);
        listB.add(bCoopere);
        setChanged();
        notifyObservers(this);
    }

    /**
     * Requiert listA !=0
     *
     * @return int
     */
    public int getNbCoups() {
        return listA.size();
    }

    /**
     * Actualise getScoreA en fonction du nouveau gainA.
     *
     * @return getScoreA double.
     */
    public double getScoreA() {
        int gainA = 0;
        for (int i = 0; i < listA.size(); i++) {
            gainA += getGainA(i);
        }
        return gainA;
    }

    public double getScoreB() {
        int gainB = 0;
        for (int i = 0; i < listB.size(); i++) {
            gainB += getGainB(i);
        }
        return gainB;
    }

    /**
     * Constructeur. Mets le niveau à 1 et le coup à noCoups. Requiert noCoups
     * != 0 .
     *
     * @param noCoups de Aacooperer. Doit etre non nul.
     * @return Aacoopere int.
     */
    public boolean AaCoopere(int noCoups) {
        return listA.get(noCoups);
    }

    public boolean BaCoopere(int noCoups) {
        return listB.get(noCoups);
    }

    /**
     * Constructeur. Met le niveau à 1 et le coups à noCoups. Requiert noCoups
     * != 0.
     *
     * @param noCoups du getGainA. Doit etre non nul.
     * @return double.
     */
    public double getGainA(int noCoups) {
        int gainA = 0;
        if (listA.get(noCoups) && listB.get(noCoups)) {
            gainA = 3;
        } else if (!listA.get(noCoups) && listB.get(noCoups)) {
            gainA = 5;
        } else if (listA.get(noCoups) && !listB.get(noCoups)) {
            gainA = 0;
        } else if (!listA.get(noCoups) && !listB.get(noCoups)) {
            gainA = 1;
        }
        return gainA;
    }

    public double getGainB(int noCoups) {
        int gainB = 0;
        if (listA.get(noCoups) && listB.get(noCoups)) {
            gainB = 3;
        } else if (!listA.get(noCoups) && listB.get(noCoups)) {
            gainB = 0;
        } else if (listA.get(noCoups) && !listB.get(noCoups)) {
            gainB = 5;
        } else if (!listA.get(noCoups) && !listB.get(noCoups)) {
            gainB = 1;
        }
        return gainB;
    }

    public void serialiser() throws FileNotFoundException, IOException {
        // Flux de communication
        FileOutputStream fos = new FileOutputStream(PATH);
        try ( // Branché sur un flux de traitement
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        }
    }

    public void deserialiser() throws FileNotFoundException, IOException, ClassNotFoundException {
        serialiser();
        Partie instance;

        // Flux de communication
        FileInputStream fichier = new FileInputStream(PATH);
        try ( // Branche sur un flux de traitement
                ObjectInputStream ois = new ObjectInputStream(fichier)) {
            instance = (Partie) ois.readObject();
        }
    }

}
