/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ADMIN
 */
public class MainForm1 extends javax.swing.JFrame implements Runnable {

    private int row = 8; //8
    private int col = 8;//8
    private ButtonEvent graphicsPanel;
    private boolean pause = false;
    private boolean resume = false;
    private int maxTime = 300;
    public int time = maxTime;

    /**
     * Creates new form MainForm
     */
    public MainForm1() {
        initComponents();
        createGraphicsPanel();

    }

    private JPanel createGraphicsPanel() {
        graphicsPanel = new ButtonEvent(this, row, col); // this,row col
        pnlIcon.setBackground(Color.gray);
        pnlIcon.add(graphicsPanel);
        return pnlIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIcon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pgbTime = new javax.swing.JProgressBar();
        btnNewGame = new javax.swing.JButton();
        btnHowToPlay = new javax.swing.JButton();
        btnAboutUs = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblSwap = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlIcon.setLayout(new java.awt.GridLayout());
        getContentPane().add(pnlIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 450, 380));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Screenshot 2021-12-13 233159.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 120));

        pgbTime.setOrientation(SwingConstants.VERTICAL);
        getContentPane().add(pgbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 23, 380));

        btnNewGame.setBackground(new java.awt.Color(255, 204, 0));
        btnNewGame.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNewGame.setText("NEW GAME");
        btnNewGame.setBorder(new javax.swing.border.MatteBorder(null));
        btnNewGame.setPreferredSize(new java.awt.Dimension(90, 23));
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });
        getContentPane().add(btnNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 11, 100, 30));

        btnHowToPlay.setBackground(new java.awt.Color(255, 204, 0));
        btnHowToPlay.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHowToPlay.setText("HOW TO PLAY");
        btnHowToPlay.setBorder(new javax.swing.border.MatteBorder(null));
        btnHowToPlay.setPreferredSize(new java.awt.Dimension(90, 23));
        getContentPane().add(btnHowToPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 11, 100, 30));

        btnAboutUs.setBackground(new java.awt.Color(255, 204, 0));
        btnAboutUs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAboutUs.setText("ABOUT US");
        btnAboutUs.setBorder(new javax.swing.border.MatteBorder(null));
        btnAboutUs.setPreferredSize(new java.awt.Dimension(90, 23));
        getContentPane().add(btnAboutUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 11, 100, 30));

        btnExit.setBackground(new java.awt.Color(255, 204, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.setBorder(new javax.swing.border.MatteBorder(null));
        btnExit.setPreferredSize(new java.awt.Dimension(90, 23));
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SCORE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 160, 70, 30));

        lblScore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("0");
        getContentPane().add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 40, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("SWAP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 73, 31));

        lblSwap.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSwap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSwap.setText("10");
        getContentPane().add(lblSwap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 63, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hinh-nen-pokemon-chibi_035414814.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
//        newGame();
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        graphicsPanel.changePosition();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainForm1 form = new MainForm1();
                form.setVisible(true);
                new Thread((Runnable) form).start();

            }
        });
    }

    public void newGame() {
        time = maxTime;
        graphicsPanel.removeAll();
        createGraphicsPanel();
//        pnlIcon.add(createGraphicsPanel(), BorderLayout.CENTER);
        pnlIcon.validate();
        pnlIcon.setVisible(true);
        lblScore.setText("0");
    }

//    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isPause()) {
                if (isResume()) {
                    time--;
                }
            } else {
                time--;
            }
            if (time == 0) {

                if (showDialogNewGame(
                        "Full time\nDo you want play again?", "Lose", 1) == true) {

                }
            }
            if (pgbTime != null) {
                pgbTime.setValue((int) ((double) time / maxTime * 100));
            }
        }
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isResume() {
        return resume;
    }

    public void setResume(boolean resume) {
        this.resume = resume;
    }

    public boolean showDialogNewGame(String message, String title, int t) {
        pause = true;
        resume = false;

        int select = JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                null, null);
        if (select == 0) {
            pause = false;

            newGame();
            return true;
        } else {
            if (t == 1) {
                System.exit(0);
                return false;
            } else {

                resume = true;
                return true;
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAboutUs;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHowToPlay;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblSwap;
    private javax.swing.JProgressBar pgbTime;
    private javax.swing.JPanel pnlIcon;
    // End of variables declaration//GEN-END:variables
}