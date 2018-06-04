package services;

import model.LivingBeing;

public interface AnimalServices {

    void startLivingBeingFoodChain(LivingBeing[][] map);

    void printAnimalPopulation();

    /**
     * Also we need to know how many animals have been died and specifically how many they were eaten and how many died due to starvation!
     */
    void printDiedAnimals();
}
