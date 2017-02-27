package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.dm;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR;
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String oa;
    private final byte[] ob;
    private final int oc;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1 */
    static class C00811 implements Creator<RealTimeMessage> {
        C00811() {
        }

        public RealTimeMessage[] m160U(int i) {
            return new RealTimeMessage[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m161x(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m160U(x0);
        }

        public RealTimeMessage m161x(Parcel parcel) {
            return new RealTimeMessage(null);
        }
    }

    static {
        CREATOR = new C00811();
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.oa = (String) dm.m392e(senderParticipantId);
        this.ob = (byte[]) ((byte[]) dm.m392e(messageData)).clone();
        this.oc = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.ob;
    }

    public String getSenderParticipantId() {
        return this.oa;
    }

    public boolean isReliable() {
        return this.oc == RELIABLE;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.oa);
        parcel.writeByteArray(this.ob);
        parcel.writeInt(this.oc);
    }
}
