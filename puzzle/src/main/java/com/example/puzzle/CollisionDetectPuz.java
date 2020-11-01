package com.example.puzzle;

public class CollisionDetectPuz {

	public static double object1Xo;
	public static double object1Yo;

	public static double object1X;
	public static double object1Y;

	public static double object2Xo;
	public static double object2Yo;

	public static double object2X;
	public static double object2Y;

	public static double radiusObject1;
	public static double radiusObject2;

	public static double object1Weight;
	public static double object1Height;

	public static double object2Weight;
	public static double object2Height;

	public static double dx;
	public static double dy;

	public static double distanceObjects;

	//Определяем столкновение по ширине и высоте объекта
	public static boolean collisionDetect(ObjectPuz object1, ObjectPuz object2) {

		object1Xo = object1.getX();
		object1Yo = object1.getY();

		object2Xo = object2.getX();
		object2Yo = object2.getY();

		object1Weight = object1.getWeight();
		object1Height = object1.getHeight();

		object2Weight = object2.getWeight();
		object2Height = object2.getHeight();

		object1X = object1Xo + object1Weight;
		object1Y = object1Yo + object1Height;

		object2X = object2Xo + object2Weight;
		object2Y = object2Yo + object2Height;

		if ((object1Xo > object2Xo && object1Xo < object2X) || (object1X > object2Xo && object1X < object2X)) {
			if ((object1Yo > object2Yo && object1Yo < object2Y) || (object1Y > object2Yo && object1Y < object2Y)) {
				return true;
			}
		}
		return false;

	}

	//определяем столкновение по радиусу объектов
	public static boolean collisionDetectToRadius(ObjectPuz object1, ObjectPuz object2) {
		object1X = object1.getHitBox().centerX();
		object1Y = object1.getHitBox().centerY();

		object2X = object2.getHitBox().centerX();
		object2Y = object2.getHitBox().centerY();

		radiusObject1 = object1.getRadius();
		radiusObject2 = object2.getRadius();

		dx = object1X - object2X;
		dy = object1Y - object2Y;

		distanceObjects = Math.sqrt(dx*dx + dy*dy);

		if (distanceObjects < radiusObject1 + radiusObject2) {
			return true;
		}
		return false;
	}

}
