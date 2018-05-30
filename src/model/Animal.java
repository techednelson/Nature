package model;

public class Animal extends LivingBeing {

    private int speed;
    private int adjacentSpots;
    private int hungerResistance;
    private String type;

    public Animal(int y, int x, int speed, int hungerResistance, String type) {
        super(y, x);
        this.speed = speed;
        this.hungerResistance = hungerResistance;
        this.type = type;
    }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getAdjacentSpots() { return adjacentSpots; }

    public void setAdjacentSpots(int adjacentSpots) { this.adjacentSpots = adjacentSpots; }

    public int getHungerResistance() { return hungerResistance; }

    public void setHungerResistance(int hungerResistance) { this.hungerResistance = hungerResistance; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

}
