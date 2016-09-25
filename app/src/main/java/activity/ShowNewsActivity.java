package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.outi.easynews.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.Dbutil;

/**
 * Created by outi on 2016/9/25.
 */
public class ShowNewsActivity extends BaseActivity{

    private List<Map<String,Object>> listNews;
    private Dbutil db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_news);
        db=new Dbutil(this);
        setListNews();
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listNews,R.layout.simple_item, new String[]{"title"},new int[] {R.id.title});
        ListView list =(ListView)findViewById(R.id.listnews);
        list.setAdapter(simpleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void setListNews(int type){
        listNews= db.Query(type);
    }

    protected void setListNews(){
        listNews= db.Query();
    }
}
