package com.fengniao.guidepage;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fengniao.guidepage.global.AppConstants;
import com.fengniao.guidepage.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;

public class WelcomeGuideActivity extends Activity implements View.OnClickListener {
    private ViewPager viewPager;
    private GuideViewPagerAdapter adapter;
    private List<View> views;
    private Button startBtn;

    // 引导页图片资源
    private static final int[] pics = {R.layout.guid_view1,
            R.layout.guid_view2, R.layout.guid_view3, R.layout.guid_view4};

    //底部小圆点图片
    private ImageView dots[];

    //记录当前位置
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_guide);
        views = new ArrayList<>();

        //初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            if (i == pics.length - 1) {
                startBtn = (Button) view.findViewById(R.id.btn_login);
                startBtn.setTag("enter");
                startBtn.setOnClickListener(this);
            }
            views.add(view);
        }

        viewPager = (ViewPager) findViewById(R.id.view_pager_guide);
        adapter = new GuideViewPagerAdapter(views);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new PageChangeListener());
        initDots();
    }

    private void initDots() {
        LinearLayout linearDots = (LinearLayout) findViewById(R.id.linear_dot);
        dots = new ImageView[pics.length];
        //循环取得小圆点图片
        for (int i = 0; i < pics.length; i++) {
            //获得linearlayout下每一个子元素
            dots[i] = (ImageView) linearDots.getChildAt(i);
            dots[i].setEnabled(false);  //都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);   //设置为值tag，方便取出取出与当前位置对应
        }

        currentIndex = 0;
        dots[currentIndex].setEnabled(true);  //设为选中状态

    }

    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            enterMainActivity();
            return;
        }

    }

    private void enterMainActivity() {
        Intent intent = new Intent(WelcomeGuideActivity.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //如果切换到后台，就设置下次不进入功能引导页
        SpUtils.putBoolean(WelcomeGuideActivity.this, AppConstants.FIRST_OPEN, false);
    }

    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || currentIndex == position) {
            return;
        }
        dots[position].setEnabled(false);
        currentIndex = position;
    }


    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        /**
         * 当滑动状态改变时调用
         *
         * @param position             当前页面位置
         * @param positionOffset       当前页面偏移的百分比
         * @param positionOffsetPixels 当前页面偏移的像素位置
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        //当新的页面被选中
        @Override
        public void onPageSelected(int position) {
            setCurDot(position);
        }

        //当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
