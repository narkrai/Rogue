package model;

public class Player extends Character {
    private int gold;
    private int strength;
    private String name;

    /**
     * @aggregation composite
     */
    private static Player uniquePlayer = null;
    
    public static Player getInstance(){
        if (uniquePlayer == null) {
            try {
            uniquePlayer = new Player();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        return uniquePlayer;
    }

    public Player(int gold, int strength, String name) {
        super();
        this.gold = gold;
        this.strength = strength;
        this.name = name;
    }

    public Player() {
        super();
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int Action(Player p) {
        return 0;
    }
}