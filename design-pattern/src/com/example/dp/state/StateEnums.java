package com.example.dp.state;

import java.util.HashMap;
import java.util.Map;

public enum StateEnums {

    A("A", new ConcreteStateA()),
    B("B", new ConcreteStateB());

    private final String code;
    private final State state;

    private static final Map<String, StateEnums> map = new HashMap<>();

    StateEnums(String code, State state) {
        this.code = code;
        this.state = state;
    }

    static {
        for(StateEnums e : StateEnums.values()){
            map.put(e.code, e);
        }
    }

    public static StateEnums get(final String code) {
        StateEnums e = map.get(code);
        if (e == null){
            throw new IllegalArgumentException( "MSG:M070");
        }
        return e;
    }

    public State getState() {
        return state;
    }
}
