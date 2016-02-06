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
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Claw extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController clawVertical = RobotMap.clawClawVertical;
    private final SpeedController pivot = RobotMap.clawPivot;
    private final AnalogPotentiometer pivotPosition = RobotMap.clawPivotPosition;
    public final DigitalInput bottomLimit = RobotMap.clawBottomLimit;
    public final DigitalInput topLimit = RobotMap.clawTopLimit;
    private final DoubleSolenoid clawSolenoid = RobotMap.clawClawSolenoid;
    private int last = 10000;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void clawPivot(double clawPivotSpeed) {   //Allows the claw to pivot
    	pivot.set(clawPivotSpeed);
    }
    
    public void clawPivotStop() {    
    	pivot.set(0);
    }
    
    public void clawMove(double clawMoveSpeed) {  //Moves the claw vertically
    	clawVertical.set(clawMoveSpeed);
    }
    
    public void clawMoveStop() {
    	clawVertical.set(0);
    }
    
    public void clawOpen() {    // Opens the claw with the Solenoid
    	if (clawSolenoid.get() == DoubleSolenoid.Value.kReverse || clawSolenoid.get() == DoubleSolenoid.Value.kOff){
    		clawSolenoid.set(DoubleSolenoid.Value.kForward);
    	} else if (clawSolenoid.get() == DoubleSolenoid.Value.kForward){
    		clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    	Timer.delay(0.1);
    }
    
    public void clawSolenoidStop() {         
    	clawSolenoid.set(DoubleSolenoid.Value.kOff);
    }
 
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

