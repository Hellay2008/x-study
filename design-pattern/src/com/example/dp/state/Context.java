package com.example.dp.state;

public class Context {
    private State state;

    public String handle(String name){
        return state.handle(name);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
