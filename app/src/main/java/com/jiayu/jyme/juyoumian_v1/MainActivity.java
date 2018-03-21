package com.jiayu.jyme.juyoumian_v1;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.WindowManager;


/**
 * 主Activity
 *
 *
 */
public class MainActivity extends FragmentActivity implements OnClickListener {

    // 三个tab布局 :knowLayout, iWantKnowLayout, meLayout
    private RelativeLayout randomLayout, raiseLayout, voteLayout, settingLayout;

    // 底部标签切换的Fragment: knowFragment, iWantKnowFragment, meFragment, currentFragment;
    private Fragment randomFragment, raiseFragment, voteFragment, settingFragment, currentFragment;
    // 底部标签图片: knowImg, iWantKnowImg, meImg
    private ImageView randomImg, raiseImg, voteImg, settingImg;
    // 底部标签的文本: knowTv, iWantKnowTv, meTv

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_main);

        initUI();
        initTab();

        //隐藏状态栏StatusBar-隐藏导航栏NavigattionBar
        //注意：只有5.0及以上系统才支持
        //Android5.0（API 21）也就是Lollipop以上的版本才能实现
        /*if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }*/
    }



    /**
     * 初始化UI
     */
    private void initUI() {
        randomLayout = (RelativeLayout) findViewById(R.id.rl_random);
        raiseLayout = (RelativeLayout) findViewById(R.id.rl_raise);
        voteLayout = (RelativeLayout) findViewById(R.id.rl_vote);
        settingLayout = (RelativeLayout) findViewById(R.id.rl_setting);

        randomLayout.setOnClickListener(this);
        raiseLayout.setOnClickListener(this);
        voteLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);

        randomImg = (ImageView) findViewById(R.id.iv_random);
        raiseImg = (ImageView) findViewById(R.id.iv_raise);
        voteImg = (ImageView) findViewById(R.id.iv_vote);
        settingImg = (ImageView) findViewById(R.id.iv_setting);
    }

    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (randomFragment == null) {
            randomFragment = new RandomFragment();
        }

        if (!randomFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, randomFragment).commit();

            // 记录当前Fragment
            currentFragment = randomFragment;
            // 设置图片的变化
            randomImg.setImageResource(R.drawable.ic_random_pre);
            raiseImg.setImageResource(R.drawable.ic_raise_nor);
            voteImg.setImageResource(R.drawable.ic_vote_nor);
            settingImg.setImageResource(R.drawable.ic_setting_nor);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_random:     // 随机
                clickTab1Layout();
                break;
            case R.id.rl_raise: // 众筹
                clickTab2Layout();
                break;
            case R.id.rl_vote: // 投票
                clickTab3Layout();
                break;
            case R.id.rl_setting: // 个人中心
                clickTab4Layout();
                break;
            default:
                break;
        }
    }

    /**
     * 点击第一个tab
     */
    private void clickTab1Layout() {
        if (randomFragment == null) {
            randomFragment = new RandomFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), randomFragment);

        // 设置底部tab变化
        randomImg.setImageResource(R.drawable.ic_random_pre);
        raiseImg.setImageResource(R.drawable.ic_raise_nor);
        voteImg.setImageResource(R.drawable.ic_vote_nor);
        settingImg.setImageResource(R.drawable.ic_setting_nor);

    }

    /**
     * 点击第二个tab
     */
    private void clickTab2Layout() {
        if (raiseFragment == null) {
            raiseFragment = new RaiseFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), raiseFragment);

        // 设置底部tab变化
        randomImg.setImageResource(R.drawable.ic_random_nor);
        raiseImg.setImageResource(R.drawable.ic_raise_pre);
        voteImg.setImageResource(R.drawable.ic_vote_nor);
        settingImg.setImageResource(R.drawable.ic_setting_nor);

    }

    /**
     * 点击第三个tab
     */
    private void clickTab3Layout() {
        if (voteFragment == null) {
            voteFragment = new VoteFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), voteFragment);

        // 设置底部tab变化
        randomImg.setImageResource(R.drawable.ic_random_nor);
        raiseImg.setImageResource(R.drawable.ic_raise_nor);
        voteImg.setImageResource(R.drawable.ic_vote_pre);
        settingImg.setImageResource(R.drawable.ic_setting_nor);

    }

    /**
     * 点击第四个tab
     */
    private void clickTab4Layout() {
        if (settingFragment == null) {
            settingFragment = new SettingFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), settingFragment);

        // 设置底部tab变化
        randomImg.setImageResource(R.drawable.ic_random_nor);
        raiseImg.setImageResource(R.drawable.ic_raise_nor);
        voteImg.setImageResource(R.drawable.ic_vote_nor);
        settingImg.setImageResource(R.drawable.ic_setting_pre);
    }

    /**
     * 添加或者显示碎片
     * @param transaction
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction, Fragment fragment) {
        if (currentFragment == fragment)
            return;

        if (!fragment.isAdded()) {              // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment)
                    .add(R.id.content_layout, fragment).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }

        currentFragment = fragment;
    }

}