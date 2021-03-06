/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.bhrobotics.backup;


import com.bhrobotics.backup.emitter.ButtonEmitter;
import com.bhrobotics.backup.event.Event;
import com.bhrobotics.backup.event.Observer;
import com.bhrobotics.backup.observer.StubObserver;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class BackupBot extends IterativeRobot {
    Joystick joystick;
    MotorModule left;
    MotorModule right;
    DigitalInput valve;
    Relay compressor;
    
    public void robotInit() {
	joystick = new Joystick(1);
	left = new MotorModule(1,3,1,3);
	right = new MotorModule(2,4,2,4);
	valve = new DigitalInput(1,1);
	compressor = new Relay(1,1);
	ButtonEmitter emitter = new ButtonEmitter();
	emitter.addObserver(new StubObserver());
	emitter.addObserver(new Observer() {
			public void call(Event event) {
				System.out.println("hello");
			}
		});
    }
    
    public void disabledInit() {
    	compressor.set(Relay.Value.kOff);
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    if(valve.get()) {
    	compressor.set(Relay.Value.kForward);
    } else {
    	compressor.set(Relay.Value.kOff);
    }
	double angle = joystick.getDirectionRadians();
	double magnitude = 0;
	if(joystick.getMagnitude() > 0.1) {
	    magnitude = (1 - joystick.getRawAxis(3))/2;
	}
	double x = magnitude * Math.sin(angle);
	double y = magnitude * Math.cos(angle);
	
	if(joystick.getRawButton(3)) {
	   /* left.setHighSpeed();
	    right.setHighSpeed(); */
	    System.out.println("button 3");
	} else if(joystick.getRawButton(4)) {
	    /* left.setLowSpeed();
	    right.setLowSpeed(); */
	    System.out.println("button 4");
	} else {}
	
	left.set(y - x);
	right.set(y + x);
	System.out.println(debugString());
    }
    
    public String debugString() {
	return "[left]:" + left.get() + "[right]:" + right.get();  
    }
}