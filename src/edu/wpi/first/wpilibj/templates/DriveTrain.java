/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Programming
 */
public abstract class DriveTrain {

    private final SwervePod frontLeft;
    private final SwervePod frontRight;
    private final SwervePod backLeft;
    private final SwervePod backRight;
    
    public DriveTrain(SwervePod frontLeft, SwervePod frontRight, SwervePod backLeft, SwervePod backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    abstract public void drive();

    public void setFrontLeftSpeed(double speed) {
        frontLeft.wheelSpeed(speed);
    }

    public void setFrontRightSpeed(double speed) {
        frontRight.wheelSpeed(speed);
    }

    public void setBackLeftSpeed(double speed) {
        backLeft.wheelSpeed(speed);
    }

    public void setBackRightSpeed(double speed) {
        backLeft.wheelSpeed(speed);
    }

    public void setWheelSpeed(double speed) {
        backRight.wheelSpeed(speed);
    }

    public void setFrontLeftRotator(double pos) {
        frontLeft.setRotator(pos);
    }

    public void setFrontRightRotator(double pos) {
        frontRight.setRotator(pos);
    }

    public void setBackLeftRotator(double pos) {
        backLeft.setRotator(pos);
    }

    public void setBackRightRotator(double pos) {
        backRight.setRotator(pos);
    }
}
