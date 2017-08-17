package kr.co.tjeit.instagramcopy.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.instagramcopy.data.UserData;

/**
 * Created by user on 2017-08-17.
 */

// 컨텍스트 유틸은, 자동로그인과 같이 앱이 종료되어도 기록되어야 하는 것들을
//    실제로 기록하기 위한 용도로 만들어줌.
//    로그인한 사람의 경우에는 여기서 빼내는게 더 효율적.
public class ContextUtil2 {

//    기본적으로는 로그인을 하지 않은 상태로 정의
//    loginUserData가 null이라면 비 로그인상태.
    private static UserData loginUserData = null;

//    멤버변수가 있으면 게터/세터 필요.
//    수동으로 구현하자.

    // SharedPreference를 이용할수 있게 하기 위한 context를 재료 1번.
    // 실제로 저장될 근본 데이터인 UserData를 재료 2번.
    public static void setLoginUser(Context context, UserData inputUserData) {

        // 기록을 하기 위한 메모장 SharedPreference를 소환.
        // 소환을 할때 항상 메모 (꼬리표) 붙여서 소환.
        // 저장한 pref의 꼬리표와, 불러올때 pref의 꼬리표는 동일해야만 데이터가 공유.
        // MODE_PRIVATE은 외부에 공개하지 않겠다 라는 의미.
        SharedPreferences pref = context.getSharedPreferences("instaPref", Context.MODE_PRIVATE);

        // 실제로 저장하는 부분.
        // LOGIN_USER_ID : 10 저장.
        // commit 메쏘드를 실행해야 실제로 저장.
        pref.edit().putInt("LOGIN_USER_ID", inputUserData.getUserId()).commit();
        // LOGIN_USER_NAME : 조경진 저장.
        pref.edit().putString("LOGIN_USER_NAME", inputUserData.getName()).commit();
        // LOGIN_USER_NICKNAME : 0ilgu
        pref.edit().putString("LOGIN_USER_NICKNAME", inputUserData.getNickName()).commit();
        // LOGIN_USER_PROFILE_URL : 임시데이터
        pref.edit().putString("LOGIN_USER_PROFILE_URL", inputUserData.getProfileImgURL()).commit();

    }

    public static UserData getUserData(Context context) {



        return loginUserData;
    }

}
