package services;

import model.Plant;

public class PlantSerrvicesImpl implements PlantServices {

    @Override
    public void movePlant() {

    }

    @Override
    public void eatPlant() {

    }

    @Override
    public void printRemainingPlants() {
        System.out.print("\nPlants remaining: " + Plant.getTotalPlants());
    }
}
