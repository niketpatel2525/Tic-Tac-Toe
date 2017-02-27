package com.google.android.gms.internal;

import java.util.Map;

public final class af implements ai {
    private final ag ey;

    public af(ag agVar) {
        this.ey = agVar;
    }

    public void m1132a(cq cqVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            cn.m299q("App event with no name parameter.");
        } else {
            this.ey.m175a(str, (String) map.get("info"));
        }
    }
}
