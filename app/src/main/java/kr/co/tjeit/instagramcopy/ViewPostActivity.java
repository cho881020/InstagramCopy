package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.tjeit.instagramcopy.data.PostingData;

public class ViewPostActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.ImageView refreshBtn;
    private android.widget.ImageView replyBtnImg;
    private android.widget.TextView seeAllReplyBtnTxt;

    PostingData mPostingData = null;
    private TextView writerNickNameTxt;
    private TextView contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        mPostingData = (PostingData) getIntent().getSerializableExtra("postingData");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        seeAllReplyBtnTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "댓글을 새로 읽어옵니다..", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void setValues() {

        writerNickNameTxt.setText(mPostingData.getWriterData().getNickName());
        contentTxt.setText(mPostingData.getContent());

    }

    @Override
    public void bindViews() {

        this.seeAllReplyBtnTxt = (TextView) findViewById(R.id.seeAllReplyBtnTxt);
        this.contentTxt = (TextView) findViewById(R.id.contentTxt);
        this.replyBtnImg = (ImageView) findViewById(R.id.replyBtnImg);
        this.writerNickNameTxt = (TextView) findViewById(R.id.writerNickNameTxt);
        this.refreshBtn = (ImageView) findViewById(R.id.refreshBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
