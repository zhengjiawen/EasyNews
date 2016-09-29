package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.outi.easynews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import util.Dbutil;
import util.IntentUtil;
import util.ToastUtil;

/**
 * Created by outi on 2016/9/25.
 */
public class ShowNewsActivity extends BaseActivity implements View.OnClickListener{
    private List<Map<String,Object>> listNews;
    private Dbutil db;
    private ListView list;
    private Button hotnews;
    private Button societyNews;
    private Button entertainmentNews;
    private Button economicNews;
    private Button militaryNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_news);

        //注册按钮
        hotnews=(Button)findViewById(R.id.hot_news);
        societyNews=(Button)findViewById(R.id.society_news);
        entertainmentNews=(Button)findViewById(R.id.entertainment_news);
        economicNews=(Button)findViewById(R.id.economic_news);
        militaryNews=(Button)findViewById(R.id.military_news);

        //绑定事件
        hotnews.setOnClickListener(this);
        societyNews.setOnClickListener(this);
        entertainmentNews.setOnClickListener(this);
        economicNews.setOnClickListener(this);
        militaryNews.setOnClickListener(this);

        //初始化为热点事件
        setListNews(-1);
//        db=new Dbutil(this);
//        listNews= db.Query(-1);
//        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listNews,R.layout.simple_item, new String[]{"title"},new int[] {R.id.title});
//        list =(ListView)findViewById(R.id.listnews);
//        list.setAdapter(simpleAdapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ToastUtil.ShowMessage(ShowNewsActivity.this,"succeed");
//                Map<String, Object> news= listNews.get(position);
//                IntentUtil.StartActivity(ShowNewsActivity.this,NewsContentActivity.class,(int)news.get("id"));
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_news:
                IntentUtil.StartActivity(this,AddNewActivity.class);
                break;
            case R.id.exit: {
                list.setAdapter(null);
                ActivityCollector.finishAll();
                break;
            }
                default:
                    break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.DbDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hot_news:                 //选择热点新闻时，暂定为输出数据库内所有新闻
                setListNews(-1);
                break;
            case R.id.society_news:
                setListNews(1);
                break;
            case R.id.entertainment_news:
                setListNews(2);
                break;
            case R.id.economic_news:
                setListNews(3);
                break;
            case R.id.military_news:
                setListNews(4);
                break;
            default:    break;
        }
    }

    public void setListNews(int type){
        db=new Dbutil(this);
        listNews= db.Query(type);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listNews,R.layout.simple_item, new String[]{"title"},new int[] {R.id.title});
        list =(ListView)findViewById(R.id.listnews);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> news= listNews.get(position);
                IntentUtil.StartActivity(ShowNewsActivity.this,NewsContentActivity.class,(int)news.get("id"));
            }
        });
    }
}
