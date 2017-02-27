package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class fu extends C0055b implements Moment {
    private fs sI;

    public fu(C0345d c0345d, int i) {
        super(c0345d, i);
    }

    private fs dC() {
        synchronized (this) {
            if (this.sI == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.sI = fs.CREATOR.m620C(obtain);
                obtain.recycle();
            }
        }
        return this.sI;
    }

    public fs dB() {
        return dC();
    }

    public /* synthetic */ Object freeze() {
        return dB();
    }

    public String getId() {
        return dC().getId();
    }

    public ItemScope getResult() {
        return dC().getResult();
    }

    public String getStartDate() {
        return dC().getStartDate();
    }

    public ItemScope getTarget() {
        return dC().getTarget();
    }

    public String getType() {
        return dC().getType();
    }

    public boolean hasId() {
        return dC().hasId();
    }

    public boolean hasResult() {
        return dC().hasId();
    }

    public boolean hasStartDate() {
        return dC().hasStartDate();
    }

    public boolean hasTarget() {
        return dC().hasTarget();
    }

    public boolean hasType() {
        return dC().hasType();
    }
}
