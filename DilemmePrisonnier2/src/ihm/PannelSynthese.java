/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.util.Observable;
import java.util.Observer;
import modele.Partie;

/**
 *
 * @author Maïlys
 */
public class PannelSynthese extends javax.swing.JPanel implements Observer {

    
    public PannelSynthese() {
        partie1 = new Partie();
        initComponents();
    }
    public PannelSynthese(Partie partie) {
        initComponents();
        this.partie1 = partie;
        //indique qu'on observe la partie
        this.partie1.addObserver(PannelSynthese.this);
        
    }
    
    @Override
    public void update (Observable object,Object args){
        System.out.print(partie1.getNbCoups());
        if(partie1 == object){
            ReponseNbCoups.setText(partie1.getNbCoups()+"");
            ReponseScoreA.setText(partie1.getScoreA()+"");
            ReponseScoreB.setText(partie1.getScoreB()+"");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        partie1 = new modele.Partie();
        NbCoups = new javax.swing.JLabel();
        ScoreA = new javax.swing.JLabel();
        ScoreB = new javax.swing.JLabel();
        ReponseNbCoups = new javax.swing.JLabel();
        ReponseScoreA = new javax.swing.JLabel();
        ReponseScoreB = new javax.swing.JLabel();

        NbCoups.setText("Nb de Coups");

        ScoreA.setText("Score A");

        ScoreB.setText("Score B");

        ReponseNbCoups.setText("0");

        ReponseScoreA.setText("0");

        ReponseScoreB.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScoreB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(ReponseScoreB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ScoreA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NbCoups, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ReponseNbCoups, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ReponseScoreA, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(37, 37, 37)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NbCoups, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReponseNbCoups))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ReponseScoreA)
                    .addComponent(ScoreA, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ScoreB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ReponseScoreB, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NbCoups;
    private javax.swing.JLabel ReponseNbCoups;
    private javax.swing.JLabel ReponseScoreA;
    private javax.swing.JLabel ReponseScoreB;
    private javax.swing.JLabel ScoreA;
    private javax.swing.JLabel ScoreB;
    private modele.Partie partie1;
    // End of variables declaration//GEN-END:variables

}
