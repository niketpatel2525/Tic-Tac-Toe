package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.dm;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0170b.C0495a;
import com.google.android.gms.maps.internal.C0172d.C0499a;
import com.google.android.gms.maps.internal.C0173e.C0501a;
import com.google.android.gms.maps.internal.C0174f.C0503a;
import com.google.android.gms.maps.internal.C0175g;
import com.google.android.gms.maps.internal.C0176h.C0507a;
import com.google.android.gms.maps.internal.C0177i.C0509a;
import com.google.android.gms.maps.internal.C0178j.C0511a;
import com.google.android.gms.maps.internal.C0179k.C0513a;
import com.google.android.gms.maps.internal.C0180l.C0515a;
import com.google.android.gms.maps.internal.C0181m.C0517a;
import com.google.android.gms.maps.internal.C0182n.C0519a;
import com.google.android.gms.maps.internal.C0183o.C0521a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0485a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0198c;
import com.google.android.gms.maps.model.internal.C0199d;
import com.google.android.gms.maps.model.internal.C0201f;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate pf;
    private UiSettings pg;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C0503a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnInfoWindowClickListener pt;

        AnonymousClass10(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.pi = googleMap;
            this.pt = onInfoWindowClickListener;
        }

        public void m2020e(C0199d c0199d) {
            this.pt.onInfoWindowClick(new Marker(c0199d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C0499a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ InfoWindowAdapter pu;

        AnonymousClass11(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.pi = googleMap;
            this.pu = infoWindowAdapter;
        }

        public C0071b m2021f(C0199d c0199d) {
            return C0566c.m1773g(this.pu.getInfoWindow(new Marker(c0199d)));
        }

        public C0071b m2022g(C0199d c0199d) {
            return C0566c.m1773g(this.pu.getInfoContents(new Marker(c0199d)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C0519a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMyLocationChangeListener pv;

        AnonymousClass12(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.pi = googleMap;
            this.pv = onMyLocationChangeListener;
        }

        public void m2023d(C0071b c0071b) {
            this.pv.onMyLocationChange((Location) C0566c.m1772b(c0071b));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C06051 extends C0485a {
        final /* synthetic */ LocationSource ph;
        final /* synthetic */ GoogleMap pi;

        /* renamed from: com.google.android.gms.maps.GoogleMap.1.1 */
        class C04731 implements OnLocationChangedListener {
            final /* synthetic */ C0175g pj;
            final /* synthetic */ C06051 pk;

            C04731(C06051 c06051, C0175g c0175g) {
                this.pk = c06051;
                this.pj = c0175g;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.pj.m719g(C0566c.m1773g(location));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C06051(GoogleMap googleMap, LocationSource locationSource) {
            this.pi = googleMap;
            this.ph = locationSource;
        }

        public void activate(C0175g listener) {
            this.ph.activate(new C04731(this, listener));
        }

        public void deactivate() {
            this.ph.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C06062 extends C0517a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMyLocationButtonClickListener pl;

        C06062(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.pi = googleMap;
            this.pl = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.pl.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C06073 extends C0509a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMapLoadedCallback pm;

        C06073(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.pi = googleMap;
            this.pm = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.pm.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C06084 extends C0521a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ SnapshotReadyCallback pn;

        C06084(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.pi = googleMap;
            this.pn = snapshotReadyCallback;
        }

        public void m2024c(C0071b c0071b) throws RemoteException {
            this.pn.onSnapshotReady((Bitmap) C0566c.m1772b(c0071b));
        }

        public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
            this.pn.onSnapshotReady(snapshot);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C06095 extends C0501a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnCameraChangeListener po;

        C06095(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.pi = googleMap;
            this.po = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.po.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C06106 extends C0507a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMapClickListener pp;

        C06106(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.pi = googleMap;
            this.pp = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.pp.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C06117 extends C0511a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMapLongClickListener pq;

        C06117(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.pi = googleMap;
            this.pq = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.pq.onMapLongClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C06128 extends C0513a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMarkerClickListener pr;

        C06128(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.pi = googleMap;
            this.pr = onMarkerClickListener;
        }

        public boolean m2025a(C0199d c0199d) {
            return this.pr.onMarkerClick(new Marker(c0199d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C06139 extends C0515a {
        final /* synthetic */ GoogleMap pi;
        final /* synthetic */ OnMarkerDragListener ps;

        C06139(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.pi = googleMap;
            this.ps = onMarkerDragListener;
        }

        public void m2026b(C0199d c0199d) {
            this.ps.onMarkerDragStart(new Marker(c0199d));
        }

        public void m2027c(C0199d c0199d) {
            this.ps.onMarkerDragEnd(new Marker(c0199d));
        }

        public void m2028d(C0199d c0199d) {
            this.ps.onMarkerDrag(new Marker(c0199d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C0614a extends C0495a {
        private final CancelableCallback pw;

        C0614a(CancelableCallback cancelableCallback) {
            this.pw = cancelableCallback;
        }

        public void onCancel() {
            this.pw.onCancel();
        }

        public void onFinish() {
            this.pw.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.pf = (IGoogleMapDelegate) dm.m392e(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.pf.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0198c addGroundOverlay = this.pf.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0199d addMarker = this.pf.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.pf.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.pf.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0201f addTileOverlay = this.pf.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.pf.animateCamera(update.cs());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.pf.animateCameraWithDurationAndCallback(update.cs(), durationMs, callback == null ? null : new C0614a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.pf.animateCameraWithCallback(update.cs(), callback == null ? null : new C0614a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.pf.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate cu() {
        return this.pf;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.pf.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.pf.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.pf.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.pf.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.pf.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.pf.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.pg == null) {
                this.pg = new UiSettings(this.pf.getUiSettings());
            }
            return this.pg;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.pf.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.pf.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.pf.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.pf.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.pf.moveCamera(update.cs());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.pf.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.pf.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.pf.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setInfoWindowAdapter(new AnonymousClass11(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.pf.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setLocationSource(new C06051(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.pf.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.pf.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnCameraChangeListener(new C06095(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnInfoWindowClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMapClickListener(new C06106(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.pf.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMapLoadedCallback(new C06073(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMapLongClickListener(new C06117(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMarkerClickListener(new C06128(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMarkerDragListener(new C06139(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMyLocationButtonClickListener(new C06062(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.pf.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.pf.setOnMyLocationChangeListener(new AnonymousClass12(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.pf.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.pf.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.pf.snapshot(new C06084(this, callback), (C0566c) (bitmap != null ? C0566c.m1773g(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.pf.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
