package edu.umb.cs.cs680;

public class EventObject {

	private Object source;

	EventObject(Object source) {
		if(getSource() == source)
		{
			this.source = source;
		}
		
	}

	public Object getSource() {
		return this.source;
	}
}
