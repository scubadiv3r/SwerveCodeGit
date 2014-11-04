/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author John
 */
public class CrabDrive extends DriveTrain {
    public CrabDrive(SwervePod frontLeft, SwervePod frontRight, SwervePod backLeft, SwervePod backRight, OperatorInputs oi)
    {
        super(frontLeft,frontRight,backLeft,backRight,oi);
    }
    
    public void drive() {
        double speed = this.joystickMagnitude();
        double direction = this.joystickDirection();
        
        this.setFrontLeftRotator(direction);
        this.setFrontRightRotator(direction);
        this.setBackLeftRotator(direction);
        this.setBackRightRotator(direction);
        
        this.setFrontLeftSpeed(speed);
        this.setFrontRightSpeed(speed);
        this.setBackLeftSpeed(speed);
        this.setBackRightSpeed(speed);
    }
}
