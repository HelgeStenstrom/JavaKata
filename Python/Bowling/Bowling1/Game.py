class Game:
    def __init__(self):
        self.rolls = []

    def roll(self, pins):
        self.rolls += [pins]

    def getScore(self):
        totScore = 0
        rollNo = 0
        for frame in range(10):
            if self.rolls[rollNo] == 10:
                totScore += self.rolls[rollNo] + self.rolls[rollNo+1] + self.rolls[rollNo+2]
                rollNo += 1
            else:
                thisFrame = self.rolls[rollNo] + self.rolls[rollNo+1]
                totScore += thisFrame
                if thisFrame == 10:
                    totScore += self.rolls[rollNo + 2]
                rollNo += 2
        return totScore
