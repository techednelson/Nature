package model;

public class Animal extends LivingBeing {

    private int speed;
    private int adjacentSpots;
    private int hungerResistance;

    public Animal(int y, int x, int speed, int hungerResistance, String type) {
        super(y, x, type);
        this.speed = speed;
        this.hungerResistance = hungerResistance;
    }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getAdjacentSpots() { return adjacentSpots; }

    public void setAdjacentSpots(int adjacentSpots) { this.adjacentSpots = adjacentSpots; }

    public int getHungerResistance() { return hungerResistance; }

    public void setHungerResistance(int hungerResistance) { this.hungerResistance = hungerResistance; }

}
