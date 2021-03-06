package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.HighScore;
import model.OptionData;
import model.Player;

/**
 * JFrame qui va se lancer quand le joueur trouve la sortie. Le congratule, lui indique son score et indique le high score
 * @author : Nicolas Nguyen
 */

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_Exit extends JFrame{
    
    private     String      msgTitre;           // String du titre
    private     JLabel      msgTitreLabel;      // JLabel pour le titre
    private     String      msg;                // String du message
    private     JTextArea   msgTextArea;        // JTextArea qui va contenir le message
    
    /**
     * Constructeur de la JFrame IHM_Exit
     */
    public IHM_Exit() {
        setTitle("Game Over!");
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false); 
        
        Border b = BorderFactory.createEmptyBorder(1,1,1,1);    // Bordure invisible
        Font font = new Font("Arial", Font.BOLD, 12);           // Police qui sera utilis� dans le JTextArea pour match la police des autres parties de l'interface

        JPanel pMsg = new JPanel();                             // JPanel pour toute la frame
        pMsg.setBorder(b);
        pMsg.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // Titre
        msgTitreLabel = new JLabel();
        msgTitreLabel.setHorizontalAlignment(JLabel.CENTER);
        msgTitre = "<html><h2><b><center>Congratulation!</center> <br>" +
                   "<center>You have beaten the game!</center></b></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);
        
        //Message
        msgTextArea = new JTextArea();
        msgTextArea.setColumns(17);
        msgTextArea.setRows(12);
        msgTextArea.setWrapStyleWord(true);
        msgTextArea.setLineWrap(true);
        msgTextArea.setEditable(false);  
        msgTextArea.setCursor(null);  
        msgTextArea.setOpaque(false);  
        msgTextArea.setFocusable(false);
        msgTextArea.setFont(font);
        pMsg.add(msgTextArea);
        
        this.add(pMsg, BorderLayout.CENTER);
        
        // JPanel des buttons
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bReplay = new JButton("Try again");
        JButton bClose = new JButton("Close");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        pButton.add(bReplay,c);
        c.gridx = 1;
        c.gridy = 0;
        pButton.add(bClose,c);
        this.add(pButton, BorderLayout.SOUTH);
        
        // ActionListener du bouton Replay
        bReplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
                IHM_GameUI.getInstance().newGame();
            }
        });
        
        // ActionListener du bouton Close
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
            }
        });
    }
    
    /**
     * Methode qui va refresh le message
     * @param Message
     */
    public void refresh() {
        int score = Player.getInstance().getGold()*2 + Player.getInstance().getStrength()*3;
        msg = "Your score : "+score+".";
        msgTextArea.setText(msg);
        
        HighScore hs = new HighScore(OptionData.getInstance().getPlayerName(), score);

        // Ecriture dans le fichier
        try {
            FileWriter write = new FileWriter("score.txt", true);
            PrintWriter text = new PrintWriter(write);
            text.println(hs.toString());
            text.flush();
            write.close();
        } 
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
