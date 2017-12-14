/*
 * Copyright (c) 2017. Helge Stenström
 */

package helge;

public class Game {
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame=0; frame<10; frame++) {
            int frameScore =  rolls[frameIndex] + rolls[frameIndex+1];
            score += frameScore;
            if (frameScore == 10)
                score += rolls[frameIndex+2];
            frameIndex += 2;
        }
        return score;
    }
}
