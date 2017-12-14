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
            if (isStrike(frameIndex)) {  // Strike
                score += 10 +
                        strikeBonus(frameIndex);
                frameIndex++;
            }
            else {
                int frameScore = rolls[frameIndex] + rolls[frameIndex + 1];
                score += frameScore;
                if (frameScore == 10)
                    score += spareBunus(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int spareBunus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] +
                spareBunus(frameIndex);
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }
}
