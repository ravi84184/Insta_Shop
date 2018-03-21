package ravi.com.instashop.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by arati on 22/3/17.
 */

public class PreferenceManager {

    public static PreferenceManager preferenceManager;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static PreferenceManager getInstance() {
        return preferenceManager;
    }

    public PreferenceManager(Context context) {
        preferenceManager = this;
        mSharedPreferences = context.getSharedPreferences(VariableBag.PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void clearPreferences() {
        mEditor.clear();
        mEditor.commit();
    }

    public void removePref(Context context, String keyToRemove) {
        mSharedPreferences = context.getSharedPreferences(VariableBag.PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mEditor.remove(keyToRemove);
        mEditor.commit();
    }

/*set preference for registration*/

    public String getRegisteredUserId() {
        String strUserId = mSharedPreferences.getString(VariableBag.USER_ID, "");
        return strUserId;
    }

    public void setRegisteredUserId(String strUserId) {
        mEditor.putString(VariableBag.USER_ID, strUserId).commit();
    }

    public void setKeyValue(String key, String value) {
        mEditor.putString(key, value).commit();
    }

    public String getKeyValue(String key) {
        String getValue = mSharedPreferences.getString(key, "");
        return getValue;
    }
}


