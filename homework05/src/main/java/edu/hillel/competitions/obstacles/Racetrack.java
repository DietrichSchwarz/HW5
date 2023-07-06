package edu.hillel.competitions.obstacles;

import edu.hillel.competitions.participants.Participant;

public class Racetrack implements Obstacle {
    final String name = "Racetrack";
    private final int length;

    public Racetrack(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        //Початок бігу
        participant.run();
        //Якщо перешкоду подолано. Додаємо пройдену дистанцію і кількість перешкод
        if (participant.getRunLength() >= length) {
            System.out.println("Participant " + participant.getName() + " overcame " + name + " " + length + " m");
            participant.addPassedDistance(length);
            participant.addPassedObstacle();
            return true;
        }
        //Якщо перешкоду не подолано. Додаємо пройдену дистанцію і дистанцію на яку може бігти учасник
        System.out.println("Participant " + participant.getName() + " didn't overcome " + name + " " + length + " m");
        return false;
    }
}