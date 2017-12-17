from unittest import TestCase
from Game import Game

class TestGame(TestCase):

    def setUp(self):
        self.g = Game()


    def roll_many(self, rolls, pins):
        for rollno in range(rolls):
            self.g.roll(pins)

    def rollSpare(self):
        self.g.roll(5)
        self.g.roll(5)

    def roll_strike(self):
        self.g.roll(10)

    def testGutterGame(self):

        self.roll_many(20,0)

        self.assertEqual(0, self.g.getScore())

    def testAllOnes(self):

        self.roll_many(20, 1)

        self.assertEqual(20, self.g.getScore())

    def testOneSpare(self):
        self.rollSpare()
        self.g.roll(3)
        self.roll_many(17,0)
        self.assertEqual(10+3+3, self.g.getScore())

    def testOneStrike(self):
        self.roll_strike()
        self.g.roll(3)
        self.g.roll(4)
        self.roll_many(16,0)

        self.assertEqual((10+3+4) + (3 + 4), self.g.getScore())

    def testPerfectGame(self):
        self.roll_many(12,10)

        self.assertEqual(300, self.g.getScore())


