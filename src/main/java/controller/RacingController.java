package controller;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

public class RacingController {
    Cars cars = new Cars();

    public void startGame() {
        initCars();

        OutputView.printResultStartMessage();
        while (!cars.isCompleted()) {
            tryOnce();
        }

        OutputView.printWinnerMessage(cars.findWinner());
    }

    public void initCars() {
        InputView.inputCarNames().forEach(name
                -> cars.insertCar(new Car(name)));
        cars.setTryCount(InputView.inputTryCount());
    }

    public void tryOnce() {
        cars.moveAllCar();
        OutputView.printScores(cars.getScores());
    }
}
