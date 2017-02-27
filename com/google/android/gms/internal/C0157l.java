package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.l */
public class C0157l {
    private final SecureRandom dB;
    private final C0154j di;

    /* renamed from: com.google.android.gms.internal.l.a */
    public class C0156a extends Exception {
        final /* synthetic */ C0157l dC;

        public C0156a(C0157l c0157l) {
            this.dC = c0157l;
        }

        public C0156a(C0157l c0157l, Throwable th) {
            this.dC = c0157l;
            super(th);
        }
    }

    public C0157l(C0154j c0154j, SecureRandom secureRandom) {
        this.di = c0154j;
        this.dB = secureRandom;
    }

    static void m672a(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m673b(String str) throws C0156a {
        try {
            byte[] a = this.di.m668a(str, false);
            if (a.length != 32) {
                throw new C0156a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0157l.m672a(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0156a(this, e);
        }
    }

    public byte[] m674c(byte[] bArr, String str) throws C0156a {
        if (bArr.length != 16) {
            throw new C0156a(this);
        }
        try {
            byte[] a = this.di.m668a(str, false);
            if (a.length <= 16) {
                throw new C0156a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0156a(this, e);
        } catch (Throwable e2) {
            throw new C0156a(this, e2);
        } catch (Throwable e22) {
            throw new C0156a(this, e22);
        } catch (Throwable e222) {
            throw new C0156a(this, e222);
        } catch (Throwable e2222) {
            throw new C0156a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0156a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0156a(this, e222222);
        }
    }
}
