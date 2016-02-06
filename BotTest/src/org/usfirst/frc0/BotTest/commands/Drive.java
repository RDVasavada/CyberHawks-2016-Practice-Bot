// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc0.BotTest.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc0.BotTest.Robot;


public class Drive extends Command {
	
	// Amount of steps to take to get to full speed
	private double steps = 3;
	
	// The current speed of the motors
	double currentRightSpeed = 0;
    double currentLeftSpeed = 0;
    
    /* The raw speed the of the motors without smooth acceleration, the
    speed of the Joystick */
	double fullRightSpeed = 0;
	double fullLeftSpeed = 0;

	public Drive() {
		// Requires the Chassis subsystem
		requires(Robot.chasis);
	}
   
	protected void initialize() {
    }
    
	protected void execute() {
    	
    	// Sets the fullSpeeds to the speed of the motors
		fullLeftSpeed = Robot.oi.getLeftSpeed();
    	fullRightSpeed = Robot.oi.getRightSpeed();
    	
    	// Produces a weighted average of currentSpeed and fullSpeed
    	currentRightSpeed = ((currentRightSpeed * steps)+ fullRightSpeed) / 2;
    	currentLeftSpeed = ((currentLeftSpeed * steps) + fullLeftSpeed) / 2;
    	
    	// Sets the motor speeds to the currentSpeeds
    	Robot.chasis.move(currentRightSpeed, currentLeftSpeed);
    	System.out.println(currentRightSpeed + " | " + currentLeftSpeed);
    	
    	// Checks if the strafeSolenoid is activated
    	if (Robot.chasis.stafeSolenoid.get() != DoubleSolenoid.Value.kForward) {
    		// Sets the speed of the strafeMotor
    		Robot.chasis.chasisStrafe(Robot.oi.rightJoy.getX());
    	}
    	
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    	Robot.chasis.stop();
    }
    protected void interrupted() {
    }
}