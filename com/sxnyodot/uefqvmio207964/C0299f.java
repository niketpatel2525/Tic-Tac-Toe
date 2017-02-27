package com.sxnyodot.uefqvmio207964;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.GravityCompat;

/* renamed from: com.sxnyodot.uefqvmio207964.f */
final class C0299f {
    C0299f() {
    }

    static void m1015a(Context context, String str) throws Exception {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                System.out.println("Browser not found.");
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent2.setFlags(268435456);
        intent2.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
        context.startActivity(intent2);
    }

    static void m1017b(Context context, String str) throws Exception {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    static void m1016a(Context context, String str, String str2) throws Exception {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", str2);
        intent.putExtra("sms_body", str);
        context.startActivity(intent);
    }
}
