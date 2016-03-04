package com.shida.joke.event;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by zpf on 2015/4/7.
 */
public class BusProvider {
    private static final Bus BUS = new Bus(ThreadEnforcer.MAIN);

    private BusProvider() {

    }
    public static Bus getInstance() {
        return BUS;
    }
}
