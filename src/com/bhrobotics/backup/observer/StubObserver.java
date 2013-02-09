package com.bhrobotics.backup.observer;

import com.bhrobotics.backup.emitter.ButtonEvent;
import com.bhrobotics.backup.event.Event;
import com.bhrobotics.backup.event.Observer;

public class StubObserver implements Observer {

	public void call(Event event) {
		System.out.println(((ButtonEvent)event).getState());
	}

}
