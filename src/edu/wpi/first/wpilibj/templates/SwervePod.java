/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Programming
 */
public class SwervePod {

    private final PotPID rotator;
    private final EncoderPID wheel;

    /**
     * Default Constructor for the Swerve Pod
     *
     * @param encoder
     * @param wheelMotor
     * @param pot
     * @param rotationMotor
     */
    public SwervePod(Encoder encoder, SpeedController wheelMotor, AnalogPotentiometer pot, SpeedController rotationMotor) {
        rotator = new PotPID(pot, rotationMotor);
        wheel = new EncoderPID(encoder, rotationMotor);
    }

    /**
     * Sets the position of the rotator
     *
     * @param pos
     */
    public void setRotator(double pos) {
        rotator.setSetpoint(pos);
    }

    public void wheelSpeed(double speed) {
        if (wheel.wasSpeedBased()) {
            wheel.setSetpoint(speed);
        } else {
            wheel.disable();
            wheel.useSpeed(true);
            wheel.setSetpoint(speed);
            wheel.enable();
        }
    }

    public void wheelDistance(double distance) {
        if (!wheel.wasSpeedBased()) {
            wheel.setSetpoint(distance);
        } else {
            wheel.disable();
            wheel.useSpeed(false);
            wheel.setSetpoint(distance);
            wheel.enable();
        }
    }

}
