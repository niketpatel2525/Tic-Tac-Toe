package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.C0049R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ei {
    private static final Pattern lT;
    private static final Pattern lU;

    static {
        lT = Pattern.compile("\\\\.");
        lU = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    }

    public static String m449I(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = lU.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case C0049R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case '\"':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case '/':
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case '\\':
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
