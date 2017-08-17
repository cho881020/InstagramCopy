package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import kr.co.tjeit.instagramcopy.adapter.NewsfeedAdapter;
import kr.co.tjeit.instagramcopy.adapter.NotificationAdapter;
import kr.co.tjeit.instagramcopy.util.ContextUtil;
import kr.co.tjeit.instagramcopy.util.GlobalData;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;
    private android.widget.ImageView tabBtn1;
    private ImageView tabBtn2;
    private ImageView tabBtn3;
    private ImageView tabBtn4;
    private ImageView tabBtn5;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;

    NewsfeedAdapter mNewsfeedAdapter;
    private ListView myPostListView;
    private LinearLayout myProfileLayout;
    private ImageView titleImg;
    private android.widget.TextView myProfileTitleTxt;
    private ListView myNotiListView;
    private LinearLayout activityLayout;
    NotificationAdapter myNotiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        View.OnClickListener imageSetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.tabBtn1) {

                    titleImg.setVisibility(View.VISIBLE);
                    myProfileTitleTxt.setVisibility(View.GONE);

                    // 뉴스피드 레이아웃은 보여주고
                    // 나머지는 숨김.

                    newsfeedLayout.setVisibility(View.VISIBLE);
                    activityLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);


                    tabBtn1.setImageResource(R.drawable.home_fill);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_empty);
                } else if (v.getId() == R.id.tabBtn2) {

                    titleImg.setVisibility(View.VISIBLE);
                    activityLayout.setVisibility(View.GONE);
                    myProfileTitleTxt.setVisibility(View.GONE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_fill);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_empty);
                } else if (v.getId() == R.id.tabBtn3) {


                    titleImg.setVisibility(View.VISIBLE);
                    activityLayout.setVisibility(View.GONE);
                    myProfileTitleTxt.setVisibility(View.GONE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_fill);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_empty);
                } else if (v.getId() == R.id.tabBtn4) {


                    titleImg.setVisibility(View.VISIBLE);
                    activityLayout.setVisibility(View.VISIBLE);
                    myProfileTitleTxt.setVisibility(View.GONE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_fill);
                    tabBtn5.setImageResource(R.drawable.home_empty);

                } else if (v.getId() == R.id.tabBtn5) {


                    titleImg.setVisibility(View.GONE);
                    activityLayout.setVisibility(View.GONE);
                    myProfileTitleTxt.setVisibility(View.VISIBLE);

                    newsfeedLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.VISIBLE);

                    tabBtn1.setImageResource(R.drawable.home_empty);
                    tabBtn2.setImageResource(R.drawable.home_empty);
                    tabBtn3.setImageResource(R.drawable.home_empty);
                    tabBtn4.setImageResource(R.drawable.home_empty);
                    tabBtn5.setImageResource(R.drawable.home_fill);
                }
            }
        };

        tabBtn1.setOnClickListener(imageSetListener);
        tabBtn2.setOnClickListener(imageSetListener);
        tabBtn3.setOnClickListener(imageSetListener);
        tabBtn4.setOnClickListener(imageSetListener);
        tabBtn5.setOnClickListener(imageSetListener);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그아웃 기능을 구현
                // 로그인 처리를 ContextUtil => pref.edit => 데이터 세팅.
                // 로그아웃도 ContextUtil => pref.edit => 데이터 세팅.

                ContextUtil.logoutProcess(mContext);
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        myNotiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ViewPostActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {
        mNewsfeedAdapter = new NewsfeedAdapter(mContext, GlobalData.postingDataList);
        newsfeedListView.setAdapter(mNewsfeedAdapter);

        myNotiAdapter = new NotificationAdapter(mContext, GlobalData.myNotiDataList);
        myNotiListView.setAdapter(myNotiAdapter);
    }

    @Override
    public void bindViews() {
        this.tabBtn5 = (ImageView) findViewById(R.id.tabBtn5);
        this.tabBtn4 = (ImageView) findViewById(R.id.tabBtn4);
        this.tabBtn3 = (ImageView) findViewById(R.id.tabBtn3);
        this.tabBtn2 = (ImageView) findViewById(R.id.tabBtn2);
        this.tabBtn1 = (ImageView) findViewById(R.id.tabBtn1);
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.myPostListView = (ListView) findViewById(R.id.myPostListView);
        this.activityLayout = (LinearLayout) findViewById(R.id.activityLayout);
        this.myNotiListView = (ListView) findViewById(R.id.myNotiListView);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.myProfileTitleTxt = (TextView) findViewById(R.id.myProfileTitleTxt);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);
    }
}
