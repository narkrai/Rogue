package DefaultPackage;

import controller.Game;

import view.IHM_GameUI;

public class Main {
    
    private static Main instance = null;
    
    public static void main(String[] args ) {
        Game.getInstance();
        IHM_GameUI gui = new IHM_GameUI();
        gui.setVisible(true);
        
    }
    

}
