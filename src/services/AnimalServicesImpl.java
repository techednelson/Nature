package services;

import model.Animal;
import model.LivingBeing;

public class AnimalServicesImpl implements AnimalServices {

    private Animal animal;
    private static  LivingBeing[][] currentMap;

    private void killAnimal(Animal animal) {

        int x = animal.getY();
        int y = animal.getX();

        currentMap[y][x] = null;
    }

    private boolean isAnimalReadyToGiveBirth(Animal animal) {
        return animal.getAge() >= animal.getAgeToGiveBirth();
    }


    private void givingBirthToAnimal(Animal animal) {

        int x = animal.getY();
        int y = animal.getX();

        if(currentMap[y][x-1] == null) {

            currentMap[y][x-1] = new Animal (
                                    y,
                                    x-1,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                );

        } else if(currentMap[y][x+1] == null) {

            currentMap[y][x+1] = new Animal (
                                    y,
                                    x+1,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                 );

        } else if(currentMap[y-1][x] == null) {

            currentMap[y-1][x] = new Animal (
                                    y-1,
                                    x,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                );

        } else if (currentMap[y+1][x] == null) {

            currentMap[y+1][x] = new Animal (
                                    y+1,
                                    x,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                );

        } else
            System.out.println("Unfortunately a new " + animal.getType() +
                    " just died for lack of adjacent empty location");
    }

    @Override
    public void gettingOldAnimal(LivingBeing[][] map) {
        currentMap = map;

        for(int i = 0; i < currentMap.length; i++) {

            for(int j = 0; j < currentMap[i].length; j++) {

               if(currentMap[i][j] != null && currentMap[i][j] instanceof Animal) {
                   animal = (Animal) currentMap[i][j];

                   // check Animal's hunger resistance
                   killAnimal(animal);

                   // Increment animal's age by one year
                   animal.setAge();

                   // check if animal has age to give birth
                   if(isAnimalReadyToGiveBirth(animal)) {
                      givingBirthToAnimal(animal);
                   }
               }
            }
        }
    }

    @Override
    public void feedAnimal() {

    }

    /**
     * In which adjacent location the animal will be moved, it must be random! it can turn also in the same position as started! Note that in order to move at least one adjacent location must be empty!
     */
    @Override
    public void moveAnimal() {

    }

    /**the exact population of the animals must be printed before each animal makes its move
     * the population for each animal species must be printed but also populations of the total animals and the categories of the animals.
     */
    @Override
    public void printAnimalPopulation() {
        System.out.print("\nTotal Animals: " + Animal.getTotalAnimals());
        System.out.print("\tLions: " + Animal.getTotalLions());
        System.out.print("\tTigers: " + Animal.getTotalTigers());
        System.out.print("\tGoats: " + Animal.getTotalGoats());
        System.out.print("\tSheeps: " + Animal.getTotalSheeps());
    }

    /**
     * Also we need to know how many animals have been died and specifically how many they were eaten and how many died due to starvation!
     */
    @Override
    public void printDiedAnimals() {

    }

}
