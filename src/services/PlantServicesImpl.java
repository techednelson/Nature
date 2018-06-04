package services;

import model.Plant;

public class PlantServicesImpl implements PlantServices {

    @Override
    public void printRemainingPlants() {
        System.out.print("\n \t\t\t\t\t\t\t\t\t  Plants remaining: " + Plant.getTotalPlants() + "\n\n\n");
    }

    @Override
    public boolean isTherePlants() { return Plant.getTotalPlants() > 0; }
}
