package com.sxnyodot.uefqvmio207964;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;

public class Base64 {
    private static final char[] f155a;
    private static final byte[] f156b;
    private static final String systemLineSeparator;

    static {
        int i;
        int i2 = 0;
        systemLineSeparator = System.getProperty("line.separator");
        f155a = new char[64];
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            f155a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            f155a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            f155a[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        f155a[i3] = '+';
        i3 = i + 1;
        f155a[i] = '/';
        f156b = new byte[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        for (int i4 = 0; i4 < f156b.length; i4++) {
            f156b[i4] = (byte) -1;
        }
        while (i2 < 64) {
            f156b[f155a[i2]] = (byte) i2;
            i2++;
        }
    }

    public static String encodeString(String s) {
        return new String(encode(s.getBytes()));
    }

    public static String encodeLines(byte[] in) {
        return encodeLines(in, 0, in.length, 76, systemLineSeparator);
    }

    public static String encodeLines(byte[] in, int iOff, int iLen, int lineLen, String lineSeparator) {
        int i = (lineLen * 3) / 4;
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder(((((iLen + i) - 1) / i) * lineSeparator.length()) + (((iLen + 2) / 3) * 4));
        int i2 = 0;
        while (i2 < iLen) {
            int min = Math.min(iLen - i2, i);
            stringBuilder.append(encode(in, iOff + i2, min));
            stringBuilder.append(lineSeparator);
            i2 += min;
        }
        return stringBuilder.toString();
    }

    public static char[] encode(byte[] in) {
        return encode(in, 0, in.length);
    }

    public static char[] encode(byte[] in, int iLen) {
        return encode(in, 0, iLen);
    }

    public static char[] encode(byte[] in, int iOff, int iLen) {
        int i = ((iLen * 4) + 2) / 3;
        char[] cArr = new char[(((iLen + 2) / 3) * 4)];
        int i2 = iOff + iLen;
        int i3 = 0;
        while (iOff < i2) {
            int i4;
            int i5;
            char c;
            int i6 = iOff + 1;
            int i7 = in[iOff] & MotionEventCompat.ACTION_MASK;
            if (i6 < i2) {
                i4 = in[i6] & MotionEventCompat.ACTION_MASK;
                i6++;
            } else {
                i4 = 0;
            }
            if (i6 < i2) {
                i5 = i6 + 1;
                i6 = in[i6] & MotionEventCompat.ACTION_MASK;
            } else {
                i5 = i6;
                i6 = 0;
            }
            int i8 = i7 >>> 2;
            i7 = ((i7 & 3) << 4) | (i4 >>> 4);
            i4 = ((i4 & 15) << 2) | (i6 >>> 6);
            int i9 = i6 & 63;
            i6 = i3 + 1;
            cArr[i3] = f155a[i8];
            i3 = i6 + 1;
            cArr[i6] = f155a[i7];
            if (i3 < i) {
                c = f155a[i4];
            } else {
                c = '=';
            }
            cArr[i3] = c;
            i4 = i3 + 1;
            if (i4 < i) {
                c = f155a[i9];
            } else {
                c = '=';
            }
            cArr[i4] = c;
            i3 = i4 + 1;
            iOff = i5;
        }
        return cArr;
    }

    public static String decodeString(String s) {
        return new String(decode(s));
    }

    public static byte[] decodeLines(String s) {
        char[] cArr = new char[s.length()];
        int i = 0;
        for (int i2 = 0; i2 < s.length(); i2++) {
            char charAt = s.charAt(i2);
            if (!(charAt == ' ' || charAt == '\r' || charAt == '\n' || charAt == '\t')) {
                int i3 = i + 1;
                cArr[i] = charAt;
                i = i3;
            }
        }
        return decode(cArr, 0, i);
    }

    public static byte[] decode(String s) {
        return decode(s.toCharArray());
    }

    public static byte[] decode(char[] in) {
        return decode(in, 0, in.length);
    }

    public static byte[] decode(char[] in, int iOff, int iLen) {
        if (iLen % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (iLen > 0 && in[(iOff + iLen) - 1] == '=') {
            iLen--;
        }
        int i = (iLen * 3) / 4;
        byte[] bArr = new byte[i];
        int i2 = iOff + iLen;
        int i3 = 0;
        while (iOff < i2) {
            int i4;
            int i5;
            int i6 = iOff + 1;
            char c = in[iOff];
            int i7 = i6 + 1;
            char c2 = in[i6];
            if (i7 < i2) {
                i6 = i7 + 1;
                i4 = in[i7];
                i7 = i6;
            } else {
                i4 = 65;
            }
            if (i7 < i2) {
                i6 = i7 + 1;
                i7 = in[i7];
                i5 = i6;
            } else {
                i5 = i7;
                i7 = 65;
            }
            if (c > '\u007f' || c2 > '\u007f' || i4 > TransportMediator.KEYCODE_MEDIA_PAUSE || i7 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = f156b[c];
            byte b2 = f156b[c2];
            byte b3 = f156b[i4];
            byte b4 = f156b[i7];
            if (b < null || b2 < null || b3 < null || b4 < null) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i6 = (b << 2) | (b2 >>> 4);
            int i8 = ((b2 & 15) << 4) | (b3 >>> 2);
            i4 = ((b3 & 3) << 6) | b4;
            i7 = i3 + 1;
            bArr[i3] = (byte) i6;
            if (i7 < i) {
                i6 = i7 + 1;
                bArr[i7] = (byte) i8;
            } else {
                i6 = i7;
            }
            if (i6 < i) {
                i7 = i6 + 1;
                bArr[i6] = (byte) i4;
            } else {
                i7 = i6;
            }
            i3 = i7;
            iOff = i5;
        }
        return bArr;
    }

    private Base64() {
    }
}
