package services;

import model.LivingBeing;

public interface NatureServices {

    /**
     * in each turn the nature must be printed in order to know where the animals and plants are located
     */
    void printNature(LivingBeing[][] map);
}
