package com.bhrobotics.backup.emitter;

import java.util.Hashtable;

import com.bhrobotics.backup.event.Event;

public class ButtonEvent implements Event {
	private Hashtable data = new Hashtable();
	
	public ButtonEvent(boolean state) {
		data.put("state", new Boolean(state));
	}
	
	public Hashtable getData() {
		return data;
	}
	
	public boolean getState() {
		return ((Boolean)data.get("state")).booleanValue();
	}

}
