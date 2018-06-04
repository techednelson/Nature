package services;

import model.Plant;

public class PlantSerrvicesImpl implements PlantServices {

    @Override
    public void printRemainingPlants() {
        System.out.print("\nPlants remaining: " + Plant.getTotalPlants());
    }

    @Override
    public boolean isTherePlants() { return Plant.getTotalPlants() > 0; }
}
