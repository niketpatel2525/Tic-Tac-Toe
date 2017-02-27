package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DetectedActivity.ON_FOOT /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                return true;
            case DetectedActivity.ON_BICYCLE /*1*/:
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return false;
            default:
                return true;
        }
    }
}
