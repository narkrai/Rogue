package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.Message;

/**
 * JFrame qui va s'afficher lorsque le joueur perd
 * @author : Nicolas Nguyen
 */
@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class IHM_GameOver extends JFrame{
        
    private     String      msgTitre;           // String du titre
    private     JLabel      msgTitreLabel;      // JLabel pour le titre
    private     String      msg;                // String du message
    private     JTextArea   msgTextArea;        // JTextArea qui va contenir le message
    
    /**
     * M�thode constructeur de IHM_GameOver
     */
    public IHM_GameOver() {
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
        msgTitre = "<html><h2><b>Game Over!</b></h2></p></html>";
        msgTitreLabel.setText(msgTitre);
        pMsg.add(msgTitreLabel);
        
        // Messge
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
               
        // Panel des buttons
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
        
        // ActionListener sur le bouton Replay
        bReplay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
                IHM_GameUI.getInstance().newGame();
            }
        });
        
        // ActionListener sur le bouton CLose
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);                              // Ferme la frame
            }
        });
    }

    /**
     * Refresh le message de la frame
     * @param Message
     */
    public void refresh(Message m) {
        msg = m.getMessage();
        msgTextArea.setText(msg);
    }
}
