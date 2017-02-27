package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR;
    private final int iM;
    String tH;
    String tI;
    String tK;
    Address tL;
    Address tM;
    String[] tN;
    LoyaltyWalletObject[] tZ;
    OfferWalletObject[] ua;

    static {
        CREATOR = new C0219g();
    }

    public MaskedWallet() {
        this.iM = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects) {
        this.iM = versionCode;
        this.tH = googleTransactionId;
        this.tI = merchantTransactionId;
        this.tN = paymentDescriptions;
        this.tK = email;
        this.tL = billingAddress;
        this.tM = shippingAddress;
        this.tZ = loyaltyWalletObjects;
        this.ua = offerWalletObjects;
    }

    public int describeContents() {
        return 0;
    }

    public Address getBillingAddress() {
        return this.tL;
    }

    public String getEmail() {
        return this.tK;
    }

    public String getGoogleTransactionId() {
        return this.tH;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.tZ;
    }

    public String getMerchantTransactionId() {
        return this.tI;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.ua;
    }

    public String[] getPaymentDescriptions() {
        return this.tN;
    }

    public Address getShippingAddress() {
        return this.tM;
    }

    public int getVersionCode() {
        return this.iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0219g.m788a(this, dest, flags);
    }
}
