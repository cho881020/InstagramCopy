package kr.co.tjeit.instagramcopy.util;

import kr.co.tjeit.instagramcopy.data.UserData;

/**
 * Created by user on 2017-08-17.
 */

// 왜 만드는가?
//    1. 앱의 전반적인 화면에서 접근해야하는 데이터를 모아두는 곳.
//    Ex. 인스타에서 모르는 사람의 사진을 모아보다가 마음에 들어서 팔로우 눌렀다. (프로필화면)
//    내 타임라인에 이 사람의 사진들이 뜨기 시작. (메인화면)

//    2. 고정적인 데이터를 저장해두는 용도.
//    Ex. 은행 계좌 정보 입력. => 애초에 글로벌데이터에 저장해두고, 불러다 쓰기만 하면되도록.
//    Ex. 주소. 서울시/경기도/.../제주도

//    3. 로그인 한 사람의 정보를 저장하는 용도.
public class GlobalData {

//    앱에 로그인한 사람의 정보를 저장해두는 변수.
//    null일 경우엔 비로그인상태, 객체가 들어있으면 로그인한 상태.
//    cf. 만약 로그아웃을 구현한다면 이 객체를 다시 null로 세팅.
    public static UserData loginUserData = null;

//    앱이 로그인 모드인지 판별하는 메쏘드.
//    null이라면 false (비로그인), 아니라면 true (로그인)
    public static boolean isLogin() {
        return loginUserData != null;
    }


}
