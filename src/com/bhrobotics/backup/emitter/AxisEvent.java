package com.bhrobotics.backup.emitter;

import java.util.Hashtable;

import com.bhrobotics.backup.event.Event;

public class AxisEvent implements Event{
	private Hashtable data = new Hashtable();

	public AxisEvent(double state) {
		data.put("state", new Double(state));
	}
	
	public Hashtable getData() {
		return data;
	}
	
	public double getState() {
		return ((Double)data.get("state")).doubleValue();
	}

}
