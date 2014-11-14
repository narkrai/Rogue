package model;

import controller.Game;

public class Monster extends Character {
    private int strength;
    private int gold;
    private String name;
    private int level;
    
    final char CHARACTER = '!';

    public Monster() {
        super();
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return this.gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Monster(String name, int strength, int gold, int level) {
        super();
        this.strength = strength;
        this.gold = gold;
        this.name = name;
        this.level = level;
    }


    public Message Action(Player p) {
        Message res = null;
        double proba = p.getStrength() / (p.getStrength() + this.getStrength());
        if (Math.random() <= proba) {
            res = new Message(1, "Vous avez battu "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold()+ "pi�ces d'or.");
        }
        else {
            res = new Message(2, "Vous avez perdu contre "+this.getName()+" de force "+this.getStrength()+". Vous recevez "+this.getGold() +"pi�ces d'or.");
        }
        return res;
    }

    @Override
    public char getCHARACTER() {
        
        return this.CHARACTER;
    }
}
