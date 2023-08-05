package com.catchypet;

public enum State {
	 ACTIVE(0),
	    DELETED(1);

	    private final int value;

	    State(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
}
