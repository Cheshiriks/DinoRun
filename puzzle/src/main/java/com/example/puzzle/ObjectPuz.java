package com.example.puzzle;

import android.graphics.Rect;

public abstract class ObjectPuz {

    protected int maxScreenX;
    protected int maxScreenY;
    protected int minScreenX;
    protected int minScreenY;

    protected double x;
    protected double y;
    protected double speed;

    protected Rect hitBox;
    protected double radius;

    public int getMaxScreenX() {
        return maxScreenX;
    }

    public int getMaxScreenY() {
        return maxScreenY;
    }

    public int getMinScreenX() {
        return minScreenX;
    }

    public int getMinScreenY() {
        return minScreenY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public Rect getHitBox() {
        return hitBox;
    }

    public double getRadius() {
        return radius;
    }


    public void setMaxScreenX(int maxScreenX) {
        this.maxScreenX = maxScreenX;
    }

    public void setMaxScreenY(int maxScreenY) {
        this.maxScreenY = maxScreenY;
    }

    public void setMinScreenX(int minScreenX) {
        this.minScreenX = minScreenX;
    }

    public void setMinScreenY(int minScreenY) {
        this.minScreenY = minScreenY;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setHitBox(Rect hitBox) {
        this.hitBox = hitBox;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
