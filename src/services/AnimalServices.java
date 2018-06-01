package services;

import model.LivingBeing;

public interface AnimalServices {

    void gettingOldAnimal(LivingBeing[][] map);

    void feedAnimal();

    /**
     * In which adjacent location the animal will be moved, it must be random! it can turn also in the same position as started! Note that in order to move at least one adjacent location must be empty!
     */
    void moveAnimal();

    /**the exact population of the animals must be printed before each animal makes its move
     * the population for each animal species must be printed but also populations of the total animals and the categories of the animals.
     */
    void printAnimalPopulation();

    /**
     * Also we need to know how many animals have been died and specifically how many they were eaten and how many died due to starvation!
     */
    void printDiedAnimals();
}
