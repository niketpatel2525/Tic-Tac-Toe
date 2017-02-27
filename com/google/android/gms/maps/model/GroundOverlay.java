package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.dm;
import com.google.android.gms.maps.model.internal.C0198c;

public final class GroundOverlay {
    private final C0198c qm;

    public GroundOverlay(C0198c delegate) {
        this.qm = (C0198c) dm.m392e(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.qm.m761a(((GroundOverlay) other).qm);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getBearing() {
        try {
            return this.qm.getBearing();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLngBounds getBounds() {
        try {
            return this.qm.getBounds();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getHeight() {
        try {
            return this.qm.getHeight();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.qm.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.qm.getPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getTransparency() {
        try {
            return this.qm.getTransparency();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.qm.getWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.qm.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.qm.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.qm.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.qm.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setBearing(float bearing) {
        try {
            this.qm.setBearing(bearing);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDimensions(float width) {
        try {
            this.qm.setDimensions(width);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDimensions(float width, float height) {
        try {
            this.qm.m760a(width, height);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setImage(BitmapDescriptor icon) {
        try {
            this.qm.m762h(icon.cs());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.qm.setPosition(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPositionFromBounds(LatLngBounds bounds) {
        try {
            this.qm.setPositionFromBounds(bounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTransparency(float transparency) {
        try {
            this.qm.setTransparency(transparency);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.qm.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float zIndex) {
        try {
            this.qm.setZIndex(zIndex);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
