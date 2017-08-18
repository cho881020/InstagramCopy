package kr.co.tjeit.instagramcopy.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.data.NotificationData;
import kr.co.tjeit.instagramcopy.data.PostingData;
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

    public static List<UserData> userDataList = new ArrayList<>();
    public static List<PostingData> postingDataList = new ArrayList<>();
    public static List<NotificationData> myNotiDataList = new ArrayList<>();

//    임시의 더미데이터들을 추가하는 메쏘드.
    public static void initGlobalData() {
//        GlobalData에 자료들을 추가한다.
//        더미데이터 : 더미? 허수아비. 임시 데이터. 쓰레기 데이터.

//        사람 데이터 채워넣기.
        userDataList.clear();
        userDataList.add(new UserData(1, "A사용자", "aa_aaa", "TempURL"));
        userDataList.add(new UserData(2, "B사용자", "bb_bbb", "TempURL"));
        userDataList.add(new UserData(3, "C사용자", "cc_ccc", "TempURL"));
        userDataList.add(new UserData(4, "D사용자", "dd_ddd", "TempURL"));
        userDataList.add(new UserData(5, "E사용자", "ee_eee", "TempURL"));
        userDataList.add(new UserData(6, "F사용자", "ff_fff", "TempURL"));
        userDataList.add(new UserData(7, "G사용자", "gg_ggg", "TempURL"));
        userDataList.add(new UserData(8, "H사용자", "hh_hhh", "TempURL"));

//        포스팅 데이터 목록 채워넣기.
        postingDataList.clear();
        postingDataList.add(new PostingData(1, "TempURL",
                "1번 게시글입니다.", userDataList.get(0)));
        postingDataList.add(new PostingData(2, "TempURL",
                "2번 게시글입니다.", userDataList.get(1)));
        postingDataList.add(new PostingData(3, "TempURL",
                "3번 게시글입니다.", userDataList.get(2)));
        postingDataList.add(new PostingData(4, "TempURL",
                "4번 게시글입니다.", userDataList.get(3)));
        postingDataList.add(new PostingData(5, "TempURL",
                "5번 게시글입니다.", userDataList.get(4)));
        postingDataList.add(new PostingData(6, "TempURL",
                "6번 게시글입니다.", userDataList.get(5)));
//        하나 추가해보니 사용자 데이터도 만들어줘야함.

//        알림 데이터 채워넣기.
        myNotiDataList.clear();
        myNotiDataList.add(new NotificationData());

    }

}
