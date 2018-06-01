package model;

public class Plant extends LivingBeing {

    private static int totalPlants;

    public Plant(int y, int x) {
        super(y, x, "plant");
        totalPlants++;
    }

    public static int getTotalPlants() {
        return totalPlants;
    }
}
