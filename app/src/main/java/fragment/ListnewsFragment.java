package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.example.outi.easynews.R;

import java.util.List;
import java.util.Map;

import activity.NewsContentActivity;
import util.Dbutil;
import util.IntentUtil;

/**
 * Created by outi on 2016/10/5.
 */

public class ListnewsFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    private List<Map<String,Object>> listNews;
    private Dbutil db;
    private ListView list;

    public static ListnewsFragment newInstance(int page) {
        Bundle args=new Bundle();
        args.putInt(ARGS_PAGE, page);
        ListnewsFragment fragment = new ListnewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_fragment,container,false);
        db=new Dbutil(getActivity());
        listNews= db.Query(mPage);
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),listNews,R.layout.simple_item, new String[]{"title"},new int[] {R.id.title});
        list =(ListView)view.findViewById(R.id.fragment_list);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> news= listNews.get(position);
                IntentUtil.StartActivity(getActivity(), NewsContentActivity.class,(int)news.get("id"));
            }
        });
        db.DbDestroy();
        return view;
    }

}




