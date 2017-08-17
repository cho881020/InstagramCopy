package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.tjeit.instagramcopy.util.ContextUtil;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;

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
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);
    }
}
