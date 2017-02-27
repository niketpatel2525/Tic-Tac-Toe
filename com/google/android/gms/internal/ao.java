package com.google.android.gms.internal;

import com.sxnyodot.uefqvmio207964.C0304k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ao {
    public final String eP;
    public final List<String> eQ;
    public final String eR;
    public final String eS;
    public final List<String> eT;

    public ao(JSONObject jSONObject) throws JSONException {
        this.eP = jSONObject.getString(C0304k.ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.eQ = Collections.unmodifiableList(arrayList);
        this.eR = jSONObject.optString("allocation_id", null);
        this.eT = au.m185a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        this.eS = optJSONObject != null ? optJSONObject.toString() : null;
    }
}
