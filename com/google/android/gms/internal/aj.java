package com.google.android.gms.internal;

import com.sxnyodot.uefqvmio207964.C0304k;
import java.util.Map;

public final class aj implements ai {
    private static boolean m1140a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m1141b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return ci.ao();
            }
            if ("l".equalsIgnoreCase(str)) {
                return ci.an();
            }
        }
        return -1;
    }

    public void m1142a(cq cqVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            cn.m299q("Action missing from an open GMSG.");
            return;
        }
        cr aw = cqVar.aw();
        if (C0304k.EVENT_EXPAND.equalsIgnoreCase(str)) {
            if (cqVar.az()) {
                cn.m299q("Cannot expand WebView that is already expanded.");
            } else {
                aw.m317a(m1140a(map), m1141b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get("u");
            if (str != null) {
                aw.m318a(m1140a(map), m1141b(map), str);
            } else {
                aw.m319a(m1140a(map), m1141b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else {
            aw.m313a(new be((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
