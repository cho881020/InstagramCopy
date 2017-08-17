package kr.co.tjeit.instagramcopy.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.instagramcopy.data.UserData;

/**
 * Created by user on 2017-08-17.
 */

// 앱 내에 기록해야될만한 요소들을 기록하는 용도.
//    기록한다? => 앱이 완전히 종료되어도 유지되어야 하는 데이터
public class ContextUtil {

    public static UserData loginUserData = null;

    private final static String prefName = "InstaPref";
    private final static String LOGIN_USER_ID = "LOGIN_USER_ID";
    private final static String LOGIN_USER_NAME = "LOGIN_USER_NAME";
    private final static String LOGIN_USER_NICKNAME = "LOGIN_USER_NICKNAME";
    private final static String LOGIN_USER_PROFILE_URL = "LOGIN_USER_PROFILE_URL";

    public static void setLoginUser(Context context, UserData loginUser) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(LOGIN_USER_ID, loginUser.getUserId()).commit();
        pref.edit().putString(LOGIN_USER_NAME, loginUser.getName()).commit();
        pref.edit().putString(LOGIN_USER_NICKNAME, loginUser.getNickName()).commit();
        pref.edit().putString(LOGIN_USER_PROFILE_URL, loginUser.getProfileImgURL()).commit();

    }

    public static UserData getLoginUserData(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        int userId = pref.getInt(LOGIN_USER_ID, -1);
        if (userId != -1) {
            if (loginUserData == null) {
                loginUserData = new UserData();
                loginUserData.setUserId(pref.getInt(LOGIN_USER_ID, -1));
                loginUserData.setName(pref.getString(LOGIN_USER_NAME, ""));
                loginUserData.setNickName(pref.getString(LOGIN_USER_NICKNAME, ""));
                loginUserData.setProfileImgURL(pref.getString(LOGIN_USER_PROFILE_URL, ""));
            }
        }

        return loginUserData;
    }

    public static int getLoginId(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        return pref.getInt(LOGIN_USER_ID, -1);

    }

}
