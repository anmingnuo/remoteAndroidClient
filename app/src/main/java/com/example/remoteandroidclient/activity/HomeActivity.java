package com.example.remoteandroidclient.activity;


import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.remoteandroidclient.R;
import com.example.remoteandroidclient.adapter.HomeAdapter;
import com.example.remoteandroidclient.base.BaseActivity;
import com.example.remoteandroidclient.fragment.EquipFragment;
import com.example.remoteandroidclient.fragment.MineFragment;
import com.example.remoteandroidclient.fragment.RemoteFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.rb_1)
    RadioButton rb_1;
    @BindView(R.id.rb_2)
    RadioButton rb_2;
    @BindView(R.id.rb_3)
    RadioButton rb_3;
    private List<Fragment> list = new ArrayList<>();
    //记录用户首次点击返回键的时间
    private long firstTime = 0;


    @Override
    protected int createLayout() {
        return R.layout.ac_home;
    }

    @Override
    public void initViews() {
        list.add(new EquipFragment());
        list.add(new RemoteFragment());
        list.add(new MineFragment());
        vp.setOffscreenPageLimit(list.size());
        //设置适配器
        vp.setAdapter(new HomeAdapter(getSupportFragmentManager(),list));
        //RadioGroup监听事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        vp.setCurrentItem(2);
                        break;

                }
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //实现滑动页面下方按钮的联动
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void initData() {

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
