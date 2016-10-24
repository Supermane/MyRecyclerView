package recycler.xhf.asus.myrecyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import recycler.xhf.asus.myrecyclerview.fragment.Fragment1;
import recycler.xhf.asus.myrecyclerview.fragment.Fragment2;

public class ChinaActivity extends FragmentActivity {

    private TextView tv1;
    private TextView tv2;
    private ViewPager vp;
    private RadioGroup rg;
    private Fragment2 fragment2;
    private Fragment1 fragment1;
    private RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);

        //获取控件
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg1 = (RadioGroup) findViewById(R.id.rg1);

        // 按钮
        initbutton();
        //viewpager的适配器和事件
        SetPagerAdapter();
        //默认选中第二个
        ChangeView(0);
        vp.setCurrentItem(0);

    }

    /**
     * 按钮
     */
    public void initbutton() {
        // TODO Auto-generated method stub
        for (int i = 0; i < rg.getChildCount(); i++) {

            TextView but = (TextView) rg.getChildAt(i);

            final int index = i;
            // 事件
            but.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // 切换视图
                    vp.setCurrentItem(index);
                    // 改变字体颜色
                    ChangeView(index);
                }
            });
        }
    }

    /**
     * 改变字体颜色和大小
     * @param tag
     */
    public void ChangeView(int tag) {
        // TODO Auto-generated method stub
        for (int i = 0; i < rg.getChildCount(); i++) {
            TextView rb = (TextView) rg.getChildAt(i);
            if (tag == i) {
                rb.setTextColor(Color.BLUE);
                rb.setTextSize(18);
            } else {
                rb.setTextColor(Color.GRAY);
                rb.setTextSize(14);
            }
        }

        for (int i = 0; i < rg1.getChildCount(); i++) {
            TextView rb = (TextView) rg1.getChildAt(i);
            if (tag == i) {
                rb.setBackgroundColor(Color.BLUE);
            } else {
                rb.setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

    /**
     * 适配器和事件
     */
    private void SetPagerAdapter() {
        //适配器
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            Fragment fragment = new Fragment();
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        fragment1 = new Fragment1();
                        fragment = fragment1;
                        break;
                    case 1:
                        fragment2 = new Fragment2();
                        fragment = fragment2;
                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        //监听事件
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp.setCurrentItem(position); // 导航
                ChangeView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
