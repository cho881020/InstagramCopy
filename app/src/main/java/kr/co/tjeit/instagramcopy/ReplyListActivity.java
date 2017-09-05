package kr.co.tjeit.instagramcopy;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.adapter.ReplyAdapter;
import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.data.ReplyData;

public class ReplyListActivity extends BaseActivity {

    private android.widget.ListView replyListView;
    ReplyAdapter mAdapter;

    PostingData mPostingData = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        mPostingData = (PostingData) getIntent().getSerializableExtra("포스트");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mAdapter = new ReplyAdapter(mContext, mPostingData.getReplies());
        replyListView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {

        this.replyListView = (ListView) findViewById(R.id.replyListView);
    }
}
