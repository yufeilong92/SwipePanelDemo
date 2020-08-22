package com.example.swipepaneldemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.swipepanel.SwipePanel;

public class LayoutSwipePanelActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, LayoutSwipePanelActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_swipe_panel);

        final SwipePanel swipePanel = findViewById(R.id.swipePanel);
        swipePanel.setOnFullSwipeListener(new SwipePanel.OnFullSwipeListener() {
            @Override
            public void onFullSwipe(int direction) {
               Toast.makeText(LayoutSwipePanelActivity.this, "onFullSwipe"+direction, Toast.LENGTH_SHORT).show();
                if (direction == SwipePanel.TOP) {
                    swipePanel.close(true);
                }
            }

        });
        swipePanel.setOnProgressChangedListener(new SwipePanel.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int direction, float progress, boolean isTouch) {
                if (direction == SwipePanel.TOP) {
                    Toast.makeText(LayoutSwipePanelActivity.this, "onProgressChanged"+progress, Toast.LENGTH_SHORT).show();
                    RotateDrawable drawable = (RotateDrawable) swipePanel.getTopDrawable();
                    drawable.setLevel((int) (progress * 20000));
                }
            }
        });
    }
}
