package com.example.corgirun.clases;

import com.example.corgirun.objects.Coin;
import com.example.corgirun.objects.Corgi;
import com.example.corgirun.objects.Ghost;
import com.example.corgirun.objects.Slime;
import com.example.corgirun.objects.Witch;
import com.example.puzzle.CollisionDetectPuz;
import com.example.puzzle.ObjectPuz;

public class CollisionDetect extends CollisionDetectPuz {

	public static boolean collisionDetect(Corgi object1, ObjectPuz object2) {

		if (!object1.isDuckDown()) {
			object1Xo = object1.getX() + 4;
			object1Yo = object1.getY() + 4;

			object1Weight = object1.getWeight() - 9;
			object1Height = object1.getHeight() - 7;

			object1X = object1Xo + object1Weight;
			object1Y = object1Yo + object1Height;
		}
		if (object1.isDuckDown()) {
			object1Xo = object1.getX() + 6;
			object1Yo = object1.getY() + 8;

			object1Weight = object1.getWeight() - 6;
			object1Height = object1.getHeight() - 12;

			object1X = object1Xo + object1Weight;
			object1Y = object1Yo + object1Height;
		}

		if (object2 instanceof Ghost) {
			object2Xo = object2.getX() + 8;
			object2Yo = object2.getY() + 6;

			object2Weight = object2.getWeight() - 21;
			object2Height = object2.getHeight() - 9;

			object2X = object2Xo + object2Weight;
			object2Y = object2Yo + object2Height;
		}

		if (object2 instanceof Slime) {
			object2Xo = object2.getX() + 4;
			object2Yo = object2.getY() + 10;

			object2Weight = object2.getWeight() - 8;
			object2Height = object2.getHeight() - 13;

			object2X = object2Xo + object2Weight;
			object2Y = object2Yo + object2Height;

			double headXo = object2.getX() + 9;
			double headYo = object2.getY() + 5;
			double headX = headXo + 14;
			double headY = headYo + 5;

			if ((object1Xo > object2Xo && object1Xo < object2X) || (object1X > object2Xo && object1X < object2X)) {
				if ((object1Yo > object2Yo && object1Yo < object2Y) || (object1Y > object2Yo && object1Y < object2Y)) {
					return true;
				}
			}
			if ((object1Xo > headXo && object1Xo < headX) || (object1X > headXo && object1X < headX)) {
				if ((object1Yo > headYo && object1Yo < headY) || (object1Y > headYo && object1Y < headY) || (headYo >= object1Yo && headYo <= object1Y)) {
					return true;
				}
			}
		}

		if (object2 instanceof Witch) {

			object2Xo = object2.getX() + 12;
			object2Yo = object2.getY();

			object2Weight = object2.getWeight() - 24;
			object2Height = object2.getHeight();

			object2X = object2Xo + object2Weight;
			object2Y = object2Yo + object2Height;

			double broomXo = object2.getX();
			double broomYo = object2.getY() + 33;
			double broomX = broomXo + object2.getWeight();
			double broomY = broomYo + 2;

			if ((object1Xo > object2Xo && object1Xo < object2X) || (object1X > object2Xo && object1X < object2X)) {
				if ((object1Yo > object2Yo && object1Yo < object2Y) || (object1Y > object2Yo && object1Y < object2Y)) {
					return true;
				}
			}
			if ((object1Xo > broomXo && object1Xo < broomX) || (object1X > broomXo && object1X < broomX)) {
				if ((object1Yo > broomYo && object1Yo < broomY) || (object1Y > broomYo && object1Y < broomY) || (broomYo >= object1Yo && broomYo <= object1Y)) {
					return true;
				}
			}
			return false;

		}

		if (object2 instanceof Coin) {
			object2Xo = object2.getX() + 3;
			object2Yo = object2.getY() + 3;

			object2Weight = object2.getWeight() - 6;
			object2Height = object2.getHeight() - 6;

			object2X = object2Xo + object2Weight;
			object2Y = object2Yo + object2Height;
		}

		if ((object1Xo > object2Xo && object1Xo < object2X) || (object1X > object2Xo && object1X < object2X)) {
			if ((object1Yo > object2Yo && object1Yo < object2Y) || (object1Y > object2Yo && object1Y < object2Y) || (object2Yo >= object1Yo && object2Yo <= object1Y)) {
				return true;
			}
		}
		return false;

	}

}
