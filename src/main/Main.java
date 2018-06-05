package main;

import model.Animal;
import model.LivingBeing;
import model.Nature;
import model.Plant;
import services.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Nature nature = Nature.getNature();
        LivingBeing[][] map;
        LivingBeing animal;
        LivingBeing plant;


        // create an object for each service class implementation
        NatureServices natureService = new NatureServicesImpl();
        AnimalServices animalServices = new AnimalServicesImpl();
        PlantServices plantServices = new PlantServicesImpl();


        // create Animals and add then to 8x8 nature map
        animal = new Animal(3, 2, 2, 2,  "lion");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(0, 7, 2, 2, "lion");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(7, 3, 3, 2,  "tiger");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(4, 6, 3, 2,  "tiger");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(0, 3, 4, 1,  "goat");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(4, 7, 4, 1,  "goat");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(2, 5, 5, 1,  "sheep");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(3, 7, 5, 1,  "sheep");
        nature.addLivingBeingToMap(animal);


        // create 4 plants and add then to 8x8 nature map
        plant = new Plant(5, 7);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(1, 4);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(2, 7);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(2, 5);
        nature.addLivingBeingToMap(plant);

        boolean exit = false;
        while (!exit) {

            // get and print nature map when turn begins
            natureService.incrementTurn();
            map = nature.getMap();
            natureService.printTurn();
            natureService.printNature(map);
            animalServices.printAnimalPopulation();
            plantServices.printRemainingPlants();


            animalServices.startLivingBeingFoodChain(map);


            // get and print nature map  before turn ends
            map = nature.getMap();
            natureService.printNature(map);
            animalServices.printDiedAnimals();

            if(!animalServices.isThereCarnivores() || !plantServices.isTherePlants()) {
                exit = true;
            }

            System.out.println("\n Please press twice enter to continue");
            br.readLine();

        }

        System.out.println("\n Game Over");

    }

}
