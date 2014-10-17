/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author Programming
 */
public class PotPID extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    private final AnalogPotentiometer pot;
    private final SpeedController motor;

    public PotPID(AnalogPotentiometer pot, SpeedController motor) {
        super("angularPID", Kp, Ki, Kd);
        this.pot = pot;
        this.motor = motor;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * sends data to PID Controller from the potentiometer
     * 
     * @return potentiometer angle
     */
    protected double returnPIDInput() {
        return pot.get();
    }
    
    public double getPotValue() {
        return pot.get();
    }

    /**
     * sends data to the motor from the PID Controller
     * 
     * @param output speed to set the motor
     */
    protected void usePIDOutput(double output) {
        motor.set(output);
    }
}
