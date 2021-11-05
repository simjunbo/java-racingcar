package racingcar.service.dto;

import racingcar.service.domain.Car;
import racingcar.utils.Preconditions;
import racingcar.value.Round;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Record {
    private final Round round;
    private final List<Car> cars;

    private Record(Round round, List<Car> cars) {
        Preconditions.checkNotNull(round, "round는 필수값입니다.");
        Preconditions.checkNotNull(cars, "cars는 필수값입니다.");

        this.round = round;
        this.cars = cars;
    }

    public static Record of(Round round, List<Car> cars) {
        return new Record(round, recordCar(cars));
    }

    private static List<Car> recordCar(List<Car> originCars) {
        return originCars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }

    public String getRoundWinnerName() {
        Integer maxPosition = Collections.max(getPositions());
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public Integer getCurrentRound() {
        return round.getRound();
    }

    public List<Car> getCars() {
        return cars;
    }
}
