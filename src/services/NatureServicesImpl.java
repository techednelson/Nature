package services;

import model.Animal;
import model.LivingBeing;

public class NatureServicesImpl  implements NatureServices {

    @Override
    public void printNature(LivingBeing[][] map) {
        String animal;

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] != null) {
                    if(map[i][j] instanceof Animal) {
                        animal = map[i][j].getType();
                        switch(animal) {
                            case "lion":
                                System.out.print("L");
                                break;
                            case "tiger":
                                System.out.print("T");
                                break;
                            case "goat":
                                System.out.print("G");
                                break;
                            case "sheep":
                                System.out.print("S");
                                break;
                        }
                    }
                    else {
                        System.out.print("P");
                    }
                } else {
                    System.out.print(" ");
                }
            }
        }

    }


}
