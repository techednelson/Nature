package services;

import model.Animal;
import model.LivingBeing;

public class NatureServicesImpl  implements NatureServices {

    @Override
    public void printNature(LivingBeing[][] map) {


        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] != null) {


                    System.out.print(" ");
                }
                System.out.print(" ");
            }
        }

    }


}
