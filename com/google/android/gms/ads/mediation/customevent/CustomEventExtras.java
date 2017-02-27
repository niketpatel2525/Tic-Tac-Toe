package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class CustomEventExtras implements NetworkExtras {
    private final HashMap<String, Object> in;

    public CustomEventExtras() {
        this.in = new HashMap();
    }

    public Object getExtra(String label) {
        return this.in.get(label);
    }

    public void setExtra(String label, Object value) {
        this.in.put(label, value);
    }
}
