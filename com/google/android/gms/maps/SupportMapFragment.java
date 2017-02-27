package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
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

public class SupportMapFragment extends Fragment {
    private GoogleMap pI;
    private final C0479b pT;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.a */
    static class C0478a implements LifecycleDelegate {
        private final IMapFragmentDelegate pK;
        private final Fragment pU;

        public C0478a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.pK = (IMapFragmentDelegate) dm.m392e(iMapFragmentDelegate);
            this.pU = (Fragment) dm.m392e(fragment);
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
            Bundle arguments = this.pU.getArguments();
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

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.b */
    static class C0479b extends C0070a<C0478a> {
        private Activity fD;
        protected C0072d<C0478a> pL;
        private final Fragment pU;

        C0479b(Fragment fragment) {
            this.pU = fragment;
        }

        private void setActivity(Activity activity) {
            this.fD = activity;
            cE();
        }

        protected void m1539a(C0072d<C0478a> c0072d) {
            this.pL = c0072d;
            cE();
        }

        public void cE() {
            if (this.fD != null && this.pL != null && bP() == null) {
                try {
                    MapsInitializer.initialize(this.fD);
                    this.pL.m143a(new C0478a(this.pU, C0185q.m729u(this.fD).m715f(C0566c.m1773g(this.fD))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public SupportMapFragment() {
        this.pT = new C0479b(this);
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    protected IMapFragmentDelegate cD() {
        this.pT.cE();
        return this.pT.bP() == null ? null : ((C0478a) this.pT.bP()).cD();
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
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.pT.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pT.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.pT.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.pT.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.pT.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.pT.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.pT.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.pT.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.pT.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.pT.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.pT.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
