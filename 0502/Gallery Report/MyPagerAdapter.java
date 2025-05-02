package kr.co.company.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.Objects;

public class MyPagerAdapter extends PagerAdapter {

    Context context;
    int[] images;
    String[] texts = {"제일 첫번째 페이지, 검색하는 화면", "검색한 결과가 나온 페이지, 김홍도", "검색한 결과가 나온 페이지, 신사임당"};

    LayoutInflater layoutInflater;

    public MyPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);

        imageView.setImageResource(images[position]);
        textView.setText(texts[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
