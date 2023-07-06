package edu.hillel.competitions;

import edu.hillel.competitions.obstacles.Obstacle;
import edu.hillel.competitions.obstacles.Racetrack;
import edu.hillel.competitions.obstacles.Wall;
import edu.hillel.competitions.participants.Cat;
import edu.hillel.competitions.participants.Human;
import edu.hillel.competitions.participants.Participant;
import edu.hillel.competitions.participants.Robot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Participant> participants = new ArrayList<>();
        ArrayList<Obstacle> obstacles = new ArrayList<>();

        //Створюємо учасників
        participants.add(new Human("Stepan", 200, 3));
        participants.add(new Human("Ivan", 7000, 4));
        participants.add(new Cat("Boston",500,5));
        participants.add(new Cat("Keks",75,1));
        participants.add(new Robot("R2D2",3000,0));
        participants.add(new Robot("Destroyer3000",50000,50));

        //Створюємо перешкоди
        obstacles.add(new Racetrack(25));
        obstacles.add(new Wall(1));
        obstacles.add(new Racetrack(50));
        obstacles.add(new Wall(2));
        obstacles.add(new Racetrack(100));
        obstacles.add(new Wall(5));
        obstacles.add(new Racetrack(5000));
        obstacles.add(new Wall(25));
        obstacles.add(new Racetrack(10000));

        for (Participant participant : participants) {
            System.out.println();
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    participant.result();
                    break;
                }
                participant.result();
            }
        }
    }
}