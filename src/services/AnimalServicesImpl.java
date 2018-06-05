package services;

import model.Animal;
import model.LivingBeing;
import model.Nature;
import model.Plant;

public class AnimalServicesImpl implements AnimalServices {

    private static  LivingBeing[][] currentMap;
    private int x;
    private int y;
    private String type;
    private int adjacentLocation;

    private void incrementAnimalAge(Animal animal) {
        animal.setAge();
    }

    private boolean checkAnimalHungerResistance(Animal animal) {
        return animal.getHungerResistance() >= 0;
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
                                    animal.getType()
                                );
        // check if there is available space at the right side of the animal
        } else if(currentMap[y][x+1] == null) {

            currentMap[y][x+1] = new Animal (
                                    y,
                                    x+1,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getType()
                                 );
        // check if there is available space at the button side of the animal
        } else if(currentMap[y-1][x] == null) {

            currentMap[y-1][x] = new Animal (
                                    y-1,
                                    x,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
                                    animal.getType()
                                );
        // check if there is available space at the top side of the animal
        } else if (currentMap[y+1][x] == null) {

            currentMap[y+1][x] = new Animal (
                                    y+1,
                                    x,
                                    animal.getAgeToGiveBirth(),
                                    animal.getSpeed(),
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
            Animal.setAnimalsEaten(); // increment number of animals eaten during current turn
            animal.setHungerResistance(); //Increment Animal resistance

        } else if(currentMap[y - 1][x] instanceof Animal &&
                currentMap[y - 1][x].getType().equals("goat") ||
                currentMap[y - 1][x].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y - 1][x]);
            Animal.setAnimalsEaten(); // increment number of animals eaten during current turn
            animal.setHungerResistance(); //Increment Animal resistance

        } else if(currentMap[y][x - 1] instanceof Animal &&
                currentMap[y][x - 1].getType().equals("goat") ||
                currentMap[y][x - 1].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y][x - 1]);
            Animal.setAnimalsEaten(); // increment number of animals eaten during current turn
            animal.setHungerResistance(); //Increment Animal resistance

        } else if(currentMap[y][x + 1] instanceof Animal &&
                currentMap[y][x + 1].getType().equals("goat") ||
                currentMap[y][x + 1].getType().equals("sheep"))
        {

            killAnimal((Animal)currentMap[y][x + 1]);
            Animal.setAnimalsEaten(); // increment number of animals eaten during current turn
            animal.setHungerResistance(); //Increment Animal resistance
        }

    }

    private void feedHerbivorous(Animal animal) {
        if(animal.isAnimalInSameLocationWithPlant()) {
            Plant.setTotalPlants(); // reduce total plant number
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
        // update nature map after animals have performed the 4 basic actions, eat. move, reproduce and die
        Nature.setMap(currentMap);
    }

    /**
     * In case 1,2,3 or 4, the method moveCarnivores will look for an adjacent spot available up, down, left or right
     * respectevetly.
     * @param animal
     */
    private void moveCarnivores(Animal animal) {
        boolean exit = false;
        y = animal.getY();
        x = animal.getX();

        while(!exit) {
            adjacentLocation = getLocationToMoveRandomly();
            switch (adjacentLocation) {
                case 1:
                    if(currentMap[y + 2][x] == null) {
                        currentMap[y][x] = null;
                        currentMap[y + 2][x] = animal;
                        exit = true;
                    } else if(currentMap[y + 1][x] == null) {
                        currentMap[y][x] = animal;
                        exit = true;
                    }
                    break;

                case 2:
                    if(currentMap[y - 2][x] == null) {
                        currentMap[y][x] = null;
                        currentMap[y - 2][x] = animal;
                        exit = true;
                    } else if(currentMap[y - 1][x] == null) {
                        currentMap[y][x] = animal;
                        exit = true;
                    }
                    break;

                case 3:
                    if(currentMap[y][x - 2] == null) {
                        currentMap[y][x] = null;
                        currentMap[y][x - 2] = animal;
                        exit = true;
                    } else if(currentMap[y][x - 1] == null) {
                        currentMap[y][x] = animal;
                        exit = true;
                    }
                    break;

                case 4:
                    if(currentMap[y][x + 2] == null) {
                        currentMap[y][x] = null;
                        currentMap[y][x + 2] = animal;
                        exit = true;
                    } else if(currentMap[y][x + 1] == null) {
                        currentMap[y][x] = animal;
                        exit = true;
                    }
                    break;
            }
        }


    }

    /**
     * In case 1,2,3 or 4, the method moveHerbivorous will look for an adjacent spot available up, down, left or rigth
     * respectevetly.
     * @param animal
     */
    private void moveHerbivorous(Animal animal) {
        boolean exit = false;
        y = animal.getY();
        x = animal.getX();

        while (!exit) {
            adjacentLocation = getLocationToMoveRandomly();
            switch (adjacentLocation) {

                case 1:
                    if(currentMap[y + 1][x] == null) {
                        currentMap[y][x] = null;
                        currentMap[y + 1][x] = animal;
                        exit = true;
                    } else if(currentMap[y + 1][x] instanceof Plant) {
                        currentMap[y][x] = null;
                        currentMap[y + 1][x] = animal;
                        animal.setAnimalInSameLocationWithPlant(true);
                        exit = true;
                    }
                    break;

                case 2:
                    if(currentMap[y - 1][x] == null) {
                        currentMap[y - 1][x] = animal;
                        exit = true;
                    } else if(currentMap[y - 1][x] instanceof Plant) {
                        currentMap[y][x] = null;
                        currentMap[y - 1][x] = animal;
                        animal.setAnimalInSameLocationWithPlant(true);
                        exit = true;
                    }
                    break;

                case 3:
                    if(currentMap[y][x - 1] == null) {
                        currentMap[y][x - 1] = animal;
                        exit = true;
                    } else if(currentMap[y][x - 1] instanceof Plant) {
                        currentMap[y][x] = null;
                        currentMap[y][x - 1] = animal;
                        animal.setAnimalInSameLocationWithPlant(true);
                        exit = true;
                    }
                    break;

                case 4:
                    if(currentMap[y][x + 1] == null) {
                        currentMap[y][x + 1] = animal;
                        exit = true;
                    } else if(currentMap[y][x + 1] instanceof Plant) {
                        currentMap[y][x] = null;
                        currentMap[y][x + 1] = animal;
                        animal.setAnimalInSameLocationWithPlant(true);
                        exit = true;
                    }
                    break;
            }
        }

    }

    private int getLocationToMoveRandomly() {
        return (int)(Math.random() + 1) * 4;
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
                       Animal.setDiedAnimalsForStarvation();
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
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t Total Animals alive: " + Animal.getTotalAnimals());
        System.out.print("\n\t\t\t\t\t\t Lions: " + Animal.getTotalLions());
        System.out.print("\tTigers: " + Animal.getTotalTigers());
        System.out.print("\tGoats: " + Animal.getTotalGoats());
        System.out.print("\tSheeps: " + Animal.getTotalSheeps());
    }

    /**
     * Also we need to know how many animals have been died and specifically how many they were eaten and how many died due to starvation!
     */
    @Override
    public void printDiedAnimals() {
        System.out.print("\n\t\t\t" + Animal.getDiedAnimalsForStarvation() + " animals died due to starvation");
        System.out.println("\t\t\t\t" + Animal.getAnimalsEaten() + " animals were eaten \n");
    }

    @Override
    public boolean isThereCarnivores() {
        return (Animal.getTotalLions() >= 0 | Animal.getTotalLions() >= 0);
    }
}
