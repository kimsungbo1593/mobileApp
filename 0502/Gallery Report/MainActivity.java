package kr.co.company.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myPagerAdapter);
    }
}
