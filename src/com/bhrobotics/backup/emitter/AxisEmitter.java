package com.bhrobotics.backup.emitter;

import java.util.Enumeration;
import java.util.Vector;

import com.bhrobotics.backup.event.Observer;

public class AxisEmitter {
	private Vector observers = new Vector();
	private double axisValue = 0;
	
	public void addObserver(Observer observer) {
		observers.addElement(observer);
	}
	
	public void alert() {
		Enumeration e = observers.elements();
		while(e.hasMoreElements()) {
			((Observer)e.nextElement()).call(new AxisEvent(axisValue));
		}
	}

}
