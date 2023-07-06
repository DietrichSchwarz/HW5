package edu.hillel.competitions.participants;

public abstract class Participant implements RunAble, JumpAble {

    private final String name;
    private final int runLength;
    private final int jumpHeight;

    public int getRunLength() {
        return runLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    int totalDistance;
    int totalObstacles;

    public Participant(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run() {
        System.out.println("\n" + name + " is running...");
    }

    @Override
    public void jump() {
        System.out.println("\n" + name + " is jumping...");
    }

    public void result() {
        System.out.println("Total distance successfully covered = " + getTotalDistance() + " m. Total obstacles successfully overcome = " + getTotalObstacles());
    }

    public String getName() {
        return name;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void addPassedDistance(int passedDistance) {
        this.totalDistance += passedDistance;
    }

    public int getTotalObstacles() {
        return totalObstacles;
    }

    public void addPassedObstacle() {
        this.totalObstacles++;
    }
}