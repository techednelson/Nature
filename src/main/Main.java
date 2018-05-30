package main;

import model.Animal;
import model.LivingBeing;
import model.Nature;
import model.Plant;
import services.NatureServices;
import services.NatureServicesImpl;

public class Main {

    public static void main(String[] args) {

        //model variables
        Nature nature = Nature.getNature();
        LivingBeing[][] map;
        Animal animal;
        Plant plant;

        //services variables
        NatureServices natureService = new NatureServicesImpl();

        //Animals
        animal = new Animal(3, 2, 2, 4, "lion");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(1, 7, 2, 4, "lion");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(8, 3, 2, 4, "tiger");
        nature.addLivingBeingToMap(animal);
        animal = new Animal(4, 6, 2, 4, "tiger");
        nature.addLivingBeingToMap(animal);

        //Plants
        plant = new Plant(5, 7);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(1, 4);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(3, 8);
        nature.addLivingBeingToMap(plant);
        plant = new Plant(2, 5);
        nature.addLivingBeingToMap(plant);

        map = nature.getMap();
        natureService.printNature(map);
    }
}