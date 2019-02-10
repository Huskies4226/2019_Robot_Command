// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4226.Huskies2019CommandRobot.subsystems;


import org.usfirst.frc4226.Huskies2019CommandRobot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Spark motorLeft1;
    private Spark motorLeft2;
    private SpeedControllerGroup leftSpeedControllerGroup;
    private Spark motorRight1;
    private Spark motorRight2;
    private SpeedControllerGroup rightSpeedControllerGroup;
    private DifferentialDrive differentialDrive1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        motorLeft1 = new Spark(0);
        addChild("motorLeft1",motorLeft1);
        motorLeft1.setInverted(false);
        
        motorLeft2 = new Spark(1);
        addChild("motorLeft2",motorLeft2);
        motorLeft2.setInverted(false);
        
        leftSpeedControllerGroup = new SpeedControllerGroup(motorLeft1, motorLeft2  );
        addChild("Left Speed Controller Group",leftSpeedControllerGroup);
        
        
        motorRight1 = new Spark(2);
        addChild("motorRight1",motorRight1);
        motorRight1.setInverted(false);
        
        motorRight2 = new Spark(3);
        addChild("motorRight2",motorRight2);
        motorRight2.setInverted(false);
        
        rightSpeedControllerGroup = new SpeedControllerGroup(motorRight1, motorRight2  );
        addChild("Right Speed Controller Group",rightSpeedControllerGroup);
        
        
        differentialDrive1 = new DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup);
        addChild("Differential Drive 1",differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveWithJoysticks());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void my_Drive_Tank(double leftSpeed, double rightSpeed) {
        differentialDrive1.tankDrive(leftSpeed, rightSpeed, true);
    }

    public void my_Drive_Arcade(double xSpeed, double zRotation) {
        differentialDrive1.arcadeDrive(xSpeed, zRotation);
    }
}

