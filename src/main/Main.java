package main;

import model.Animal;
import model.LivingBeing;
import model.Nature;
import model.Plant;
import services.*;

public class Main {

    public static void main(String[] args) {

        Nature nature = Nature.getNature();
        LivingBeing[][] map;
        LivingBeing animal;
        LivingBeing plant;


        // create an object for each service class implementation
        NatureServices natureService = new NatureServicesImpl();
        AnimalServices animalServices = new AnimalServicesImpl();
        PlantServices plantServices = new PlantSerrvicesImpl();


        // create Animals
        animal = new Animal(3, 2, 2, 2, 4, "lion");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(0, 7, 2, 2, 4, "lion");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(7, 3, 3, 2, 4, "tiger");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(4, 6, 3, 2, 4, "tiger");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(0, 3, 4, 1, 4, "goat");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(4, 7, 4, 1, 4, "goat");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(2, 5, 5, 1, 4, "sheep");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(3, 7, 5, 1, 4, "sheep");
        nature.addLivingBeingToMap(animal);


        // create plants
        plant = new Plant(5, 7);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(1, 4);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(2, 7);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(2, 5);
        nature.addLivingBeingToMap(plant);


        // create nature with 8X8 map and add the 8 animals and 4 plants
        map = nature.getMap();
        natureService.printNature(map);


        animalServices.printAnimalPopulation();
        plantServices.printRemainingPlants();


        animalServices.startLivingBeingFoodChain(map);
    }
}
