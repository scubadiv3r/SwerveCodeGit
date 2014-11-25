/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Programming
 */
public class EncoderPID extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.01;
    private static final double Kd = 0.0;
    private final SpeedController motor;
    private final Encoder encoder;
    private boolean isSpeedBased;

    // Initialize your subsystem here
    public EncoderPID(Encoder encoder, SpeedController motor) {
        super("SpeedPID", Kp, Ki, Kd);
        this.encoder = encoder;
        this.motor = motor;
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    /**
     * Makes the PID use speed if true else use distance
     *
     * @param isSpeedBased
     */
    public void useSpeed(boolean isSpeedBased) {
        this.isSpeedBased = isSpeedBased;
    }
    
    public boolean wasSpeedBased(){
        return isSpeedBased;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * Sends data from encoder to PID Subsystem
     *
     * @return encoder rate
     */
    protected double returnPIDInput() {
        if (isSpeedBased) {
            return encoder.getRate();
        } else {
            return encoder.getDistance();
        }
    }

    /**
     * Sends data from PID Subsystem to motor
     *
     * @param output to motor
     */
    protected void usePIDOutput(double output) {
        motor.set(output);
    }
}
