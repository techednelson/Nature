package services;

import model.Animal;
import model.LivingBeing;
import model.Nature;

public class NatureServicesImpl  implements NatureServices {

    @Override
    public void printNature(LivingBeing[][] map) {
        String animal;
        System.out.println("\n\t\t\t\t\t\t\t Nature Map \n");
        System.out.println("=====================================" +
                            "===================================");
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] != null) {

                    if(map[i][j] instanceof Animal) {

                        animal = map[i][j].getType();

                        switch(animal) {
                            case "lion":
                                System.out.print("{ Lion  }");
                                break;
                            case "tiger":
                                System.out.print("{ Tiger }");
                                break;
                            case "goat":
                                System.out.print("{ Goat  }");
                                break;
                            case "sheep":
                                System.out.print("{ Sheep }");
                                break;
                        }
                    }
                    else // instanceof Plant
                        System.out.print("{ Plant }");
                }
                else // map[i][j] == null
                    System.out.print("{       }");

                // condition checks if a whole row with 8 spots has been printed
                if(j == 7) System.out.println();
            }
        }
        System.out.println("=====================================" +
                            "===================================");
    }

    @Override
    public void incrementTurn() {
        Nature.setTurn();
    }

    @Override
    public void printTurn() {
        System.out.println(Nature.getTurn());
    }


}
