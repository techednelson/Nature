package services;

import model.Animal;
import model.LivingBeing;
import model.Plant;

public class AnimalServicesImpl implements AnimalServices {

    private static  LivingBeing[][] currentMap;
    private int x;
    private int y;
    private String type;

    private void incrementAnimalAge(Animal animal) {
        animal.setAge();
    }

    private boolean checkAnimalHungerResistance(Animal animal) {
        return animal.getHungerResistance() <= 0;
    }

    private void killAnimal(Animal animal) {

        y = animal.getY();
        x = animal.getX();

        currentMap[y][x] = null;
    }

    private boolean isAnimalReadyToGiveBirth(Animal animal) {
        return animal.getAge() >= animal.getAgeToGiveBirth();
    }

    private void givingBirthToAnimal(Animal animal) {

        y = animal.getY();
        x = animal.getX();

        //check if there is available space at the left side of the animal
        if(currentMap[y][x-1] == null) {

            currentMap[y][x-1] = new Animal (
                                    y,
                                    x-1,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                );
        // check if there is available space at the right side of the animal
        } else if(currentMap[y][x+1] == null) {

            currentMap[y][x+1] = new Animal (
                                    y,
                                    x+1,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                 );
        // check if there is available space at the button side of the animal
        } else if(currentMap[y-1][x] == null) {

            currentMap[y-1][x] = new Animal (
                                    y-1,
                                    x,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getHungerResistance(),
                                    animal.getType()
                                );
        // check if there is available space at the top side of the animal
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

    private void feedAnimal(Animal animal) {

        type = animal.getType();

        switch (type) {
            case "lion":
            case "tiger":
                feedCarnivores(animal);
                break;

            case "goat":
            case "sheep":
                feedHerbivorous(animal);
                break;
        }

    }

    private void feedCarnivores(Animal animal) {

        y = animal.getY();
        x = animal.getX();

        if(currentMap[y + 1][x] instanceof Animal &&
                currentMap[y + 1][x].getType().equals("goat") ||
                currentMap[y + 1][x].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y + 1][x]);

        } else if(currentMap[y - 1][x] instanceof Animal &&
                currentMap[y - 1][x].getType().equals("goat") ||
                currentMap[y - 1][x].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y - 1][x]);

        } else if(currentMap[y][x - 1] instanceof Animal &&
                currentMap[y][x - 1].getType().equals("goat") ||
                currentMap[y][x - 1].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y][x - 1]);

        } else if(currentMap[y][x + 1] instanceof Animal &&
                currentMap[y][x + 1].getType().equals("goat") ||
                currentMap[y][x + 1].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y][x + 1]);
        }

    }

    private void feedHerbivorous(Animal animal) {

        y = animal.getY();
        x = animal.getX();

        if(currentMap[y][x] instanceof Plant &&
                currentMap[y][x].equals(animal))
        {

            killAnimal((Animal)currentMap[y + 1][x]);

        } else if(currentMap[y - 1][x] instanceof Animal &&
                currentMap[y - 1][x].getType().equals("goat") ||
                currentMap[y - 1][x].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y - 1][x]);

        } else if(currentMap[y][x - 1] instanceof Animal &&
                currentMap[y][x - 1].getType().equals("goat") ||
                currentMap[y][x - 1].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y][x - 1]);

        } else if(currentMap[y][x + 1] instanceof Animal &&
                currentMap[y][x + 1].getType().equals("goat") ||
                currentMap[y][x + 1].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y][x + 1]);
        }

    }

    /**
     * In which adjacent location the animal will be moved, it must be random! it can turn also in the same position as started! Note that in order to move at least one adjacent location must be empty!
     */
    private void moveAnimal(Animal animal) {
        type = animal.getType();

        switch (type) {
            case "lion":
            case "tiger":
                moveCarnivores(animal);
                break;
            case "goats":
            case "sheeps":
                moveHerbivorous(animal);
                break;

        }
    }

    private void moveCarnivores(Animal animal) {

        y = animal.getY();
        x = animal.getX();

        if(currentMap[y + 2][x] == null) {

            currentMap[y + 2][x] = animal;

        } else if(currentMap[y + 1][x] == null) {

            currentMap[y + 1][x] = animal;

        } else if(currentMap[y - 2][x] == null) {

            currentMap[y - 2][x] = null;

        } else if(currentMap[y - 1][x] == null) {

            currentMap[y - 1][x] = animal;

        } else if(currentMap[y][x - 2] == null) {

            currentMap[y][x - 2] = null;

        } else if(currentMap[y][x - 1] == null) {

            currentMap[y][x - 1] = animal;

        } else if(currentMap[y][x + 2] == null) {

            currentMap[y][x + 2] = null;

        } else if(currentMap[y][x + 1] == null) {

            currentMap[y][x + 1] = animal;
        }

    }

    private void moveHerbivorous(Animal animal) {

        y = animal.getY();
        x = animal.getX();

        if(currentMap[y + 1][x] == null) {

            currentMap[y + 1][x] = animal;

        } else if(currentMap[y + 1][x] instanceof Plant) {

            animal = (Animal) currentMap[y + 1][x];

        } else if(currentMap[y - 1][x] == null) {

            currentMap[y - 1][x] = null;

        } else if(currentMap[y - 1][x] instanceof Plant) {

            animal = (Animal)currentMap[y - 1][x];

        } else if(currentMap[y][x - 1] == null) {

            currentMap[y][x - 1] = null;

        } else if(currentMap[y][x - 1] instanceof Plant) {

            animal = (Animal)currentMap[y][x - 1];

        } else if(currentMap[y][x + 1] == null) {

            currentMap[y][x + 1] = null;

        } else if(currentMap[y][x + 1] instanceof Plant) {

            animal = (Animal)currentMap[y][x + 1];
        }

    }


    @Override
    public void startLivingBeingFoodChain(LivingBeing[][] map) {
        currentMap = map;

        for(int i = 0; i < currentMap.length; i++) {

            for(int j = 0; j < currentMap[i].length; j++) {

               if(currentMap[i][j] != null && currentMap[i][j] instanceof Animal) {
                   Animal animal = (Animal) currentMap[i][j];

                   incrementAnimalAge(animal);

                   if(!checkAnimalHungerResistance(animal)) {
                       killAnimal(animal);
                   } else if(isAnimalReadyToGiveBirth(animal)) {
                       givingBirthToAnimal(animal);
                       feedAnimal(animal);
                       moveAnimal(animal);
                   } 

               }
            }
        }
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
