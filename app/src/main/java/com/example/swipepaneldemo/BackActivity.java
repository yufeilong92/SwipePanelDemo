package com.example.swipepaneldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.swipepanel.SwipePanel;

public class BackActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, BackActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        final SwipePanel swipePanel = new SwipePanel(this);
        swipePanel.setLeftEdgeSize(100);// 设置左侧触发阈值 100dp
        swipePanel.setLeftDrawable(R.drawable.base_back);// 设置左侧 icon
        swipePanel.wrapView(findViewById(R.id.rootLayout));// 设置嵌套在 rootLayout 外层
        swipePanel.setOnFullSwipeListener(true,new SwipePanel.OnFullSwipeListener() {// 设置完全划开松手后的监听
            @Override
            public void onFullSwipe(int direction) {
//                swipePanel.close(true);// 关闭
                finish();
            }
        });
        swipePanel.setOnProgressChangedListener(new SwipePanel.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int direction, float progress, boolean isTouch) {
                Log.e("==", "onProgressChanged" + progress);
            }
        });
    }
}
