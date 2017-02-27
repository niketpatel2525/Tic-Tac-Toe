package com.google.android.gms.common.data;

import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.data.f */
public abstract class C0346f<T> extends DataBuffer<T> {
    private boolean jA;
    private ArrayList<Integer> jB;

    protected C0346f(C0345d c0345d) {
        super(c0345d);
        this.jA = false;
    }

    private void aN() {
        synchronized (this) {
            if (!this.jA) {
                int count = this.jf.getCount();
                this.jB = new ArrayList();
                if (count > 0) {
                    this.jB.add(Integer.valueOf(0));
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String c = this.jf.m1097c(primaryDataMarkerColumn, 0, this.jf.m1102q(0));
                    int i = 1;
                    while (i < count) {
                        String c2 = this.jf.m1097c(primaryDataMarkerColumn, i, this.jf.m1102q(i));
                        if (c2.equals(c)) {
                            c2 = c;
                        } else {
                            this.jB.add(Integer.valueOf(i));
                        }
                        i++;
                        c = c2;
                    }
                }
                this.jA = true;
            }
        }
    }

    private int m1103u(int i) {
        return (i < 0 || i == this.jB.size()) ? 0 : i == this.jB.size() + -1 ? this.jf.getCount() - ((Integer) this.jB.get(i)).intValue() : ((Integer) this.jB.get(i + 1)).intValue() - ((Integer) this.jB.get(i)).intValue();
    }

    protected abstract T m1104a(int i, int i2);

    public final T get(int position) {
        aN();
        return m1104a(m1105t(position), m1103u(position));
    }

    public int getCount() {
        aN();
        return this.jB.size();
    }

    protected abstract String getPrimaryDataMarkerColumn();

    int m1105t(int i) {
        if (i >= 0 && i < this.jB.size()) {
            return ((Integer) this.jB.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }
}
