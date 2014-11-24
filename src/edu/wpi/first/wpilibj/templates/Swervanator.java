/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Watchdog;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Swervanator extends IterativeRobot {

    private static final Encoder FRONT_LEFT_ENCODER = new Encoder(1,2);
    private static final Encoder FRONT_RIGHT_ENCODER = new Encoder(3,4);
    private static final Encoder BACK_LEFT_ENCODER = new Encoder(5,6);
    private static final Encoder BACK_RIGHT_ENCODER = new Encoder(7,8);

    private static final Jaguar FRONT_LEFT_WHEEL = new Jaguar(1);
    private static final Jaguar FRONT_RIGHT_WHEEL = new Jaguar(1);
    private static final Jaguar BACK_LEFT_WHEEL = new Jaguar(1);
    private static final Jaguar BACK_RIGHT_WHEEL = new Jaguar(1);
    
    private static final AnalogPotentiometer FRONT_LEFT_POT = new AnalogPotentiometer(1);
    private static final AnalogPotentiometer FRONT_RIGHT_POT = new AnalogPotentiometer(2);
    private static final AnalogPotentiometer BACK_LEFT_POT = new AnalogPotentiometer(3);
    private static final AnalogPotentiometer BACK_RIGHT_POT = new AnalogPotentiometer(4);
    
    private static final Jaguar FRONT_LEFT_ROTATOR = new Jaguar(1);
    private static final Jaguar FRONT_RIGHT_ROTATOR = new Jaguar(2);
    private static final Jaguar BACK_LEFT_ROTATOR = new Jaguar(3);
    private static final Jaguar BACK_RIGHT_ROTATOR = new Jaguar(4);
    
    private static final SwervePod FRONT_LEFT = new SwervePod(FRONT_LEFT_ENCODER, FRONT_LEFT_WHEEL, FRONT_LEFT_POT, FRONT_LEFT_ROTATOR);
    private static final SwervePod FRONT_RIGHT = new SwervePod(FRONT_RIGHT_ENCODER, FRONT_RIGHT_WHEEL, FRONT_RIGHT_POT, FRONT_RIGHT_ROTATOR);
    private static final SwervePod BACK_LEFT = new SwervePod(BACK_LEFT_ENCODER, BACK_LEFT_WHEEL, BACK_LEFT_POT, BACK_LEFT_ROTATOR);
    private static final SwervePod BACK_RIGHT = new SwervePod(BACK_RIGHT_ENCODER, BACK_RIGHT_WHEEL, BACK_RIGHT_POT, BACK_RIGHT_ROTATOR);
    
    private static final OperatorInputs OPERATOR_INPUTS = new OperatorInputs();
    private CrabDrive crabDrive;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        crabDrive = new CrabDrive(FRONT_LEFT,FRONT_RIGHT,BACK_LEFT,BACK_RIGHT,OPERATOR_INPUTS);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        crabDrive.drive();
        Watchdog.getInstance().feed();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Watchdog.getInstance().feed();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
