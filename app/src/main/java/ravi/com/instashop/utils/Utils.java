/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package ravi.com.instashop.utils;

import android.content.Context;
import android.content.CursorLoader;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.DrawableCompat;


import java.util.HashMap;
import java.util.Map;

import ravi.com.instashop.R;

public class Utils {

    public static final String ATTRIBUTE_TTF_KEY = "ttf_name";

    public static final String ATTRIBUTE_SCHEMA = "http://schemas.android.com/apk/lib/com.hitesh_sahu.retailapp.util";

    public final static String SHOPPING_LIST_TAG = "SHoppingListFragment";
    public static final String PRODUCT_OVERVIEW_FRAGMENT_TAG = "ProductOverView";
    public static final String MY_CART_FRAGMENT = "MyCartFragment";
    public static final String MY_ORDERS_FRAGMENT = "MYOrdersFragment";
    public static final String HOME_FRAGMENT = "HomeFragment";
    public static final String SEARCH_FRAGMENT_TAG = "SearchFragment";
    public static final String SETTINGS_FRAGMENT_TAG = "SettingsFragment";
    public static final String OTP_LOGIN_TAG = "OTPLogingFragment";
    public static final String CONTACT_US_FRAGMENT = "ContactUs";
    private static final String PREFERENCES_FILE = "materialsample_settings";
    private static String CURRENT_TAG = null;
    private static Map<String, Typeface> TYPEFACE = new HashMap<String, Typeface>();


//
//	public static Map<String, Integer> buildEffectMap(Context context) {
//		Map<String, Integer> effectMap = new LinkedHashMap<>();
//		int i = 0;
//		String[] effects = context.getResources().getStringArray(
//				R.array.jazzy_effects);
//		for (String effect : effects) {
//			effectMap.put(effect, i++);
//		}
//		return effectMap;
//	}

//	public static PageTransformer currentPageTransformer(Context context) {
//		PageTransformer transformer = null;
//
//		switch (PreferenceHelper.getPrefernceHelperInstace().getInteger(
//				context, AppConstants.VIEW_PAGER_ANIME, 13)) {
//		case AppConstants.STANDARD:
//
//			transformer = new DefaultTransformer();
//
//			break;
//
//		case AppConstants.TABLET:
//
//			transformer = new TabletTransformer();
//
//			break;
//
//		case AppConstants.CUBEIN:
//
//			transformer = new CubeInTransformer();
//
//			break;
//
//		case AppConstants.CUBEOUT:
//
//			transformer = new CubeOutTransformer();
//
//			break;
//
//		case AppConstants.FLIPVERTICAL:
//
//			transformer = new FlipVerticalTransformer();
//
//			break;
//
//		case AppConstants.FLIPHORIZONTAL:
//
//			transformer = new FlipHorizontalTransformer();
//
//			break;
//
//		case AppConstants.STACK:
//
//			transformer = new StackTransformer();
//
//			break;
//
//		case AppConstants.ZOOMIN:
//
//			transformer = new ZoomInTransformer();
//
//			break;
//
//		case AppConstants.ZOOMOUT:
//
//			transformer = new ZoomOutTranformer();
//
//			break;
//
//		case AppConstants.ROTATEUP:
//
//			transformer = new RotateUpTransformer();
//
//			break;
//
//		case AppConstants.ROTATEDOWN:
//
//			transformer = new RotateDownTransformer();
//
//			break;
//
//		case AppConstants.ACCORDION:
//
//			transformer = new AccordionTransformer();
//
//			break;
//
//		default:
//
//			transformer = new CubeOutTransformer();
//			break;
//		}
//		return transformer;
//	}

    public static Drawable tintMyDrawable(Drawable drawable, int color) {
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, color);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static String getRealPathFromURI(Uri contentUri, Context mContext) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(mContext, contentUri, proj,
                null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    /**
     * Convert milliseconds into time hh:mm:ss
     *
     * @param milliseconds
     * @return time in String
     */
    public static String getDuration(long milliseconds) {
        long sec = (milliseconds / 1000) % 60;
        long min = (milliseconds / (60 * 1000)) % 60;
        long hour = milliseconds / (60 * 60 * 1000);

        String s = (sec < 10) ? "0" + sec : "" + sec;
        String m = (min < 10) ? "0" + min : "" + min;
        String h = "" + hour;

        String time = "";
        if (hour > 0) {
            time = h + ":" + m + ":" + s;
        } else {
            time = m + ":" + s;
        }
        return time;
    }

    public static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }


    public enum AnimationType {
        SLIDE_LEFT, SLIDE_RIGHT, SLIDE_UP, SLIDE_DOWN, FADE_IN, SLIDE_IN_SLIDE_OUT, FADE_OUT
    }

}
