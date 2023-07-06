package edu.hillel.competitions.obstacles;

import edu.hillel.competitions.participants.Participant;

public class Wall implements Obstacle {
    final String name = "Wall";
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        //Початок стрибків
        participant.jump();
        //Якщо перешкоду подолано. Додаємо кількість перешкод
        if (participant.getJumpHeight() >= height) {
            System.out.println("Participant " + participant.getName() + " overcame " + name + " " + height + " m");
            participant.addPassedObstacle();
            return true;
        }
        //Якщо перешкоду не подолано.
        System.out.println("Participant " + participant.getName() + " didn't overcome " + name + " " + height + " m");
        return false;
    }
}