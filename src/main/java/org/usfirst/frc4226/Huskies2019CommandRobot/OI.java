// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4226.Huskies2019CommandRobot;

import org.usfirst.frc4226.Huskies2019CommandRobot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4226.Huskies2019CommandRobot.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton run_LimeLight_Seek;
    public JoystickButton joystickButton1;
    public JoystickButton joystickButton3;
    public Joystick leftStick;
    public Joystick rightStick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //Some Variables to store Vision Target Data
    NetworkTable _netorktable_LimeLight;
    NetworkTableEntry _LimeLight_tx;
    NetworkTableEntry _LimeLight_ty;
    NetworkTableEntry _LimeLight_ta;
    double VisionTarget_x_error;
    double VisionTarget_y_error;
    double VisionTarget_area;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        rightStick = new Joystick(1);
        
        leftStick = new Joystick(0);
        
        joystickButton3 = new JoystickButton(leftStick, 3);
        joystickButton3.whileHeld(new DriveTrain_Shift_High());
        joystickButton1 = new JoystickButton(leftStick, 1);
        joystickButton1.whileHeld(new DriveTrain_Shift_Low());
        run_LimeLight_Seek = new JoystickButton(leftStick, 2);
        run_LimeLight_Seek.whileHeld(new Drive_Seek_With_LimeLight());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    //Set up NetworkTables Lime Light tages
    _netorktable_LimeLight = NetworkTableInstance.getDefault().getTable("limelight");
    _LimeLight_tx = _netorktable_LimeLight.getEntry("tx");
    _LimeLight_ty = _netorktable_LimeLight.getEntry("ty");
    _LimeLight_ta = _netorktable_LimeLight.getEntry("ta");


    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getleftStick() {
        return leftStick;
    }

    public Joystick getrightStick() {
        return rightStick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS


    public double getDriveTrainLeftSpeed(){
        return leftStick.getRawAxis(1)*-1;
    }

    public double getDriveTrainRightSpeed(){
        return leftStick.getRawAxis(5)*-1;
    }

    public double getCargoIntake_Power(){
        double kp = .5; // cut teh power by 50%
        return rightStick.getRawAxis(1) * kp;
    }

    public double getElevator_power(){
        double kp = .25; //cut the power by 25%
        return rightStick.getRawAxis(5) * kp;
    }


    /**
    * WE can go get some Vision Data
    */
    public double my_getLimeLight_tx_Data(){
        
        return VisionTarget_x_error = _LimeLight_tx.getDouble(0.0);
        //SmartDashboard.putNumber("LimelightX", VisionTarget_x_error);
       
    }
    public double my_getLimeLight_ty_Data(){
        
        return VisionTarget_y_error = _LimeLight_ty.getDouble(0.0);
        //SmartDashboard.putNumber("LimelightY", VisionTarget_y_error);
      
    }
    public double my_getLimeLight_ta_Data(){
        
        return VisionTarget_area = _LimeLight_ta.getDouble(0.0);
        //SmartDashboard.putNumber("LimelightArea", VisionTarget_area);
    }
}

