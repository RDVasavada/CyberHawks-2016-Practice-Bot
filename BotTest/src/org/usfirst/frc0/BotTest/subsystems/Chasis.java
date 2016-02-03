// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc0.BotTest.subsystems;

import org.usfirst.frc0.BotTest.RobotMap;
import org.usfirst.frc0.BotTest.commands.*;
import org.usfirst.frc0.BotTest.commands.Drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class Chasis extends Subsystem {
	private Talon RDrive;
	private Talon LDrive;
	

	public static void init(){
		
	}

	public Chasis(){
	}
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController rightMotor = RobotMap.chasisRightMotor;
    private final SpeedController leftMotor = RobotMap.chasisLeftMotor;
    private final SpeedController strafeMotor = RobotMap.chasisStrafeMotor;
    private final DoubleSolenoid stafeSolenoid = RobotMap.chasisStafeSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
public void move(double RSpeed, double LSpeed){
	RDrive.set(RSpeed);
	LDrive.set(LSpeed);
}
public void stop(){
	LDrive.set(0);
	RDrive.set(0);
    }
}

