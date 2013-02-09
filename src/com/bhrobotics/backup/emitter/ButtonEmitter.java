package com.bhrobotics.backup.emitter;

import java.util.Enumeration;
import java.util.Vector;

import com.bhrobotics.backup.event.Emitter;
import com.bhrobotics.backup.event.Observer;

public class ButtonEmitter implements Emitter {	
	private Vector observers = new Vector();
	private boolean isPressed = false;
	
	public void addObserver(Observer observer) {
		observers.addElement(observer);
	}

	public void alert() {
		Enumeration e = observers.elements();
		while(e.hasMoreElements()) {
			((Observer)e.nextElement()).call(new ButtonEvent(isPressed));
		}
	}
}