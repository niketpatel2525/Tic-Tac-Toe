package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0053a implements ServiceConnection {
    boolean iN;
    private final BlockingQueue<IBinder> iO;

    public C0053a() {
        this.iN = false;
        this.iO = new LinkedBlockingQueue();
    }

    public IBinder aG() throws InterruptedException {
        if (this.iN) {
            throw new IllegalStateException();
        }
        this.iN = true;
        return (IBinder) this.iO.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.iO.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
