package model;

public class Stair extends Item {
    
    
    Room pointeur = null;
    final char CHARACTER = '<';



    @Override
    public Message Action(Player p) {
        Message res = null;
        return res;
    }
    
    public Stair(Room p) {
    
        this.pointeur = p;
       
    }   
        public Room getPointeur() {
        return pointeur;
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
