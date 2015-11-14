package org.robockets.distancesensortester;

import java.util.Scanner;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SampleRobot;

/**
 * Robot class for the tester.
 */
public class Robot extends SampleRobot {
	Scanner portScanner = new Scanner(System.in);
	int port;
	OperationMode currentOpMode;
	AnalogInput sensor = new AnalogInput(port);
	
    public Robot() {
    	System.out.print("What port is the sensor you would like to test on?\n>");
    	port = portScanner.nextInt();
    	
    }

    /**
     * Nag the user to switch to test mode from autonomous mode.
     */
    public void autonomous() {
    	currentOpMode = OperationMode.AUTONOMOUS;
    	nagAboutMode();
    }

    /**
     * Nag the user to switch to test mode from opcontrol mode.
     */
    public void operatorControl() {
    	currentOpMode = OperationMode.OPERATOR_CONTROL;
    	nagAboutMode();
    }

    /**
     * Tests the sensors.
     */
    public void test() {
	    currentOpMode = OperationMode.TEST;
	    while(true) {
	    	System.out.println(sensor.getVoltage());
	    }
    }
    
    private void nagAboutMode() {
    	System.out.println(String.format("Switch to test mode! (Currently on %s)", currentOpMode));
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
