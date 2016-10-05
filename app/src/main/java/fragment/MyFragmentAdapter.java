package fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by outi on 2016/10/5.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    public final int COUNT = 5;
    private String[] titles = new String[]{"热点新闻", "社会新闻", "娱乐新闻", "财经新闻", "军事新闻"};
    private Context context;

    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        return ListnewsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
