/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6731.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public abstract class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	private static Joystick stick1 = new Joystick(1);
	private static Joystick stick2 = new Joystick(0);
	private static double forward;
	private static double rotation;
	private static double turnFactor;
	private NetworkTableEntry turnEntry;
	
	public static double getForward() {
		forward = stick1.getZ() + stick2.getZ();
		return forward;
	}
	
	public static double getRotation() {
		rotation = stick1.getY() + stick2.getY();
		return rotation;
	}
	public static double getTurnFactor() {
			return turnFactor;
	}
	public void dataInit() {
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable table = inst.getTable("datatable");
		turnEntry = table.getEntry("turn");
		turnFactor = turnEntry.getDouble(0.0);
	}
}
