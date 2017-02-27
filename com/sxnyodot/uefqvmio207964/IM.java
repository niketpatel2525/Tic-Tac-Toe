package com.sxnyodot.uefqvmio207964;

interface IM extends C0302i {
    public static final String ALLOW_OFF_SCREEN = "allowOffscreen";
    public static final String ALLOW_ORIENTATION_CHANGE = "allowOrientationChange";
    public static final String ANIMATION_TYPE = "animationType";
    public static final String ANIMATION_TYPE_FADE = "fade";
    public static final String ANIMATION_TYPE_LEFT_TO_RIGHT = "left_to_right";
    public static final String ANIMATION_TYPE_TOP_DOWN = "top_down";
    public static final String CUSTOM_CLOSE_POSITION = "customClosePosition";
    public static final String CUSTOM_CLOSE_POSITION_BOTTOM_CENTER = "bottom-center";
    public static final String CUSTOM_CLOSE_POSITION_BOTTOM_LEFT = "bottom-left";
    public static final String CUSTOM_CLOSE_POSITION_BOTTOM_RIGHT = "bottom-right";
    public static final String CUSTOM_CLOSE_POSITION_CENTER = "center";
    public static final String CUSTOM_CLOSE_POSITION_TOP_CENTER = "top-center";
    public static final String CUSTOM_CLOSE_POSITION_TOP_LEFT = "top-left";
    public static final String CUSTOM_CLOSE_POSITION_TOP_RIGHT = "top-right";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_READY = "ready";
    public static final String EVENT_SIZE_CHANGE = "sizeChange";
    public static final String EVENT_STATE_CHANGE = "stateChange";
    public static final String EVENT_VIEWABLE_CHANGE = "viewableChange";
    public static final String FORCE_ORIENTATION = "forceOrientation";
    public static final String HEIGHT = "height";
    public static final int INLINE_HEIGHT = 60;
    public static final int INLINE_WIDTH = 468;
    public static final String IS_MODAL = "isModal";
    public static final String MRAID_EVENT_CREATE_CALENDER = "92";
    public static final String MRAID_EVENT_DOWNLOAD_APP = "77";
    public static final String MRAID_EVENT_ERROR = "89";
    public static final String MRAID_EVENT_EXPAND = "94";
    public static final String MRAID_EVENT_IMPRESSION = "90";
    public static final String MRAID_EVENT_INLINE_VIDEO = "99";
    public static final String MRAID_EVENT_OPEN = "96";
    public static final String MRAID_EVENT_PLAY_VIDEO = "91";
    public static final String MRAID_EVENT_RESIZE = "95";
    public static final String MRAID_EVENT_SHOW_LOCATION = "79";
    public static final String MRAID_EVENT_SMS = "98";
    public static final String MRAID_EVENT_STORE_PICTURE = "93";
    public static final String MRAID_EVENT_TEL = "97";
    public static final String OFF_SET_X = "offsetX";
    public static final String OFF_SET_Y = "offsetY";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_NONE = "none";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String PLACEMENT_TYPE = "placementType";
    public static final String PLACEMENT_TYPE_INLINE = "inline";
    public static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";
    public static final String STATE_DEFAULT = "default";
    public static final String STATE_EXPANDED = "expanded";
    public static final String STATE_HIDDEN = "hidden";
    public static final String STATE_LOADING = "loading";
    public static final String STATE_RESIZED = "resized";
    public static final String TAG = "PrmMraid";
    public static final String USE_CUSTOM_CLOSE = "useCustomClose";
    public static final String WIDTH = "width";

    public enum MRAID_AD_TYPE {
        MRW,
        MRA,
        MRCM,
        MRCC,
        MRIV,
        MRCE,
        MRFSV,
        MRAW,
        MRSP
    }

    void m1616a();

    void m1617a(String str);

    void m1618a(String str, String str2);

    void m1619b();

    void m1620b(String str);

    void m1621c();

    void m1622d();

    void m1623e();

    void m1624f();

    void setState(String str);

    void setViewable(boolean z);
}
