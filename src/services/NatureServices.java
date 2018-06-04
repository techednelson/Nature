package services;

import model.LivingBeing;

public interface NatureServices {

    void printNature(LivingBeing[][] map);

    void incrementTurn();

    void printTurn();
}
