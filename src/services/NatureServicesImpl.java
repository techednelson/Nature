package services;

import model.Animal;
import model.Nature;

public class NatureServicesImpl  implements NatureServices {

    @Override
    public void printNature() {
        Animal animal;
        String type;
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t Nature Map \n");
        System.out.println("=====================================================" +
                "===================================================");
        for(int i = 0; i < Nature.map().length; i++) {
            for(int j = 0; j < Nature.map()[i].length; j++) {
                if(Nature.map()[i][j] != null) {

                    if(Nature.map()[i][j] instanceof Animal) {
                        animal = (Animal) Nature.map()[i][j];
                        type = Nature.map()[i][j].getType();

                        switch(type) {
                            case "lion":
                                System.out.print("{  Lion     }");
                                break;
                            case "tiger":
                                System.out.print("{  Tiger    }");
                                break;
                            case "goat":
                                if(animal.isAnimalInSameLocationWithPlant())
                                    System.out.print("{Goat/Plant }");
                                else
                                    System.out.print("{  Goat     }");
                                break;
                            case "sheep":
                                if(animal.isAnimalInSameLocationWithPlant())
                                    System.out.print("{Sheep/Plant}");
                                else
                                    System.out.print("{  Sheep    }");
                                break;
                        }
                    }
                    else // instanceof Plant
                        System.out.print("{  Plant    }");
                }
                else // map[i][j] == null
                    System.out.print("{           }");

                // condition checks if a whole row with 8 spots has been printed
                if(j == 7) System.out.println();
            }
        }
        System.out.println("=====================================================" +
                            "===================================================");
    }

    @Override
    public void incrementTurn() {
        Nature.setTurn();
    }

    @Override
    public void printTurn() {
        System.out.println("\n Turn: " + Nature.getTurn());
    }


}
