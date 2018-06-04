package services;

import model.LivingBeing;

public interface AnimalServices {

    void startLivingBeingFoodChain(LivingBeing[][] map);

    void printAnimalPopulation();

    void printDiedAnimals();

    boolean isThereCarnivores();
}
