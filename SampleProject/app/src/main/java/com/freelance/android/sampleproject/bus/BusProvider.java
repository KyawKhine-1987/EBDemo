package com.freelance.android.sampleproject.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class BusProvider {

    private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

    public BusProvider() {
    }

    public static Bus getInstance() {
        return BUS;
    }
}
