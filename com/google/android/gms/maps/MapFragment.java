package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0070a;
import com.google.android.gms.dynamic.C0072d;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.dm;
import com.google.android.gms.maps.internal.C0184p;
import com.google.android.gms.maps.internal.C0185q;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment extends Fragment {
    private final C0475b pH;
    private GoogleMap pI;

    /* renamed from: com.google.android.gms.maps.MapFragment.a */
    static class C0474a implements LifecycleDelegate {
        private final Fragment pJ;
        private final IMapFragmentDelegate pK;

        public C0474a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.pK = (IMapFragmentDelegate) dm.m392e(iMapFragmentDelegate);
            this.pJ = (Fragment) dm.m392e(fragment);
        }

        public IMapFragmentDelegate cD() {
            return this.pK;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.pJ.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0184p.m726a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.pK.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0566c.m1772b(this.pK.onCreateView(C0566c.m1773g(inflater), C0566c.m1773g(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.pK.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.pK.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.pK.onInflate(C0566c.m1773g(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.pK.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.pK.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.pK.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.pK.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.MapFragment.b */
    static class C0475b extends C0070a<C0474a> {
        private Activity fD;
        private final Fragment pJ;
        protected C0072d<C0474a> pL;

        C0475b(Fragment fragment) {
            this.pJ = fragment;
        }

        private void setActivity(Activity activity) {
            this.fD = activity;
            cE();
        }

        protected void m1536a(C0072d<C0474a> c0072d) {
            this.pL = c0072d;
            cE();
        }

        public void cE() {
            if (this.fD != null && this.pL != null && bP() == null) {
                try {
                    MapsInitializer.initialize(this.fD);
                    this.pL.m143a(new C0474a(this.pJ, C0185q.m729u(this.fD).m715f(C0566c.m1773g(this.fD))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapFragment() {
        this.pH = new C0475b(this);
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    protected IMapFragmentDelegate cD() {
        this.pH.cE();
        return this.pH.bP() == null ? null : ((C0474a) this.pH.bP()).cD();
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate cD = cD();
        if (cD == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = cD.getMap();
            if (map == null) {
                return null;
            }
            if (this.pI == null || this.pI.cu().asBinder() != map.asBinder()) {
                this.pI = new GoogleMap(map);
            }
            return this.pI;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.pH.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pH.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.pH.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.pH.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.pH.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.pH.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.pH.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.pH.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.pH.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.pH.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.pH.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
