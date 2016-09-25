package activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.outi.easynews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DatabaseHelper;
import db.Values;
import util.Dbutil;

/**
 * Created by outi on 2016/9/24.
 */
public class ShowNewsActivity extends BaseActivity{

   // private List<Map<String,Object>> listNews;//=new ArrayList<Map<String, Object>>()
    //private Dbutil db=new Dbutil(this);
    private DatabaseHelper dbhelper;
    private ArrayList<Map<String,Object>> listNews=new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_news);
        dbhelper=new DatabaseHelper(this,"EasyNews.db",1);
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        init();
        Query();
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listNews,R.layout.simple_item, new String[]{"title"},new int[] {R.id.title});
        ListView list =(ListView)findViewById(R.id.listnews);
        list.setAdapter(simpleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbhelper!=null){
            dbhelper.close();
        }
    }

    public void Query(int targetType){
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        Cursor cursor=db.query("news",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Map<String,Object> listNew= new HashMap<String,Object>();
                int type=cursor.getInt(cursor.getColumnIndex("type"));
                if(type==targetType){
                    String title=cursor.getString(cursor.getColumnIndex("title"));
                    String time=cursor.getString(cursor.getColumnIndex("time"));
                    String content=cursor.getString(cursor.getColumnIndex("content"));
                    listNew.put("title",title);
                    listNew.put("time",time);
                    listNew.put("content",content);
                    listNews.add(listNew);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    //重载一个不传入参数时全部查询的函数
    public void Query(){
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        Cursor cursor=db.query("news",null,null,null,null,null,null);
        Map<String,Object> listNew= new HashMap<String,Object>();
        if(cursor.moveToFirst()){
            do{
                int type=cursor.getInt(cursor.getColumnIndex("type"));
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String time=cursor.getString(cursor.getColumnIndex("time"));
                String content=cursor.getString(cursor.getColumnIndex("content"));
                listNew.put("title",title);
                listNew.put("time",time);
                listNew.put("content",content);
                listNews.add(listNew);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    private void init(){
        SQLiteDatabase db=dbhelper.getWritableDatabase();
//        db.insert(dbhelper.getDatabaseName(),null, Values.setAndgetValues(1,"社会新闻","9月24日","电子科大获捐10.3亿"));
//        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(1,"社会新闻2","9月24日","电子科大获60周年校庆"));
//        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(1,"社会新闻3","9月25日","全国人民喜迎油价上涨"));
//        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(2,"娱乐新闻","9月24日","洛天依假唱"));
//        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(2,"娱乐新闻2","9月26日","过气歌姬初音未来来华演唱会"));
//        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(3,"财经新闻","9月24日","全国房价崩盘"));
//        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(4,"军事新闻","9月27日","我国成功收复台湾"));
        db.insert("news",null, Values.setAndgetValues(1,"社会新闻","9月24日","电子科大获捐10.3亿"));
        db.insert("news",null,Values.setAndgetValues(1,"社会新闻2","9月24日","电子科大获60周年校庆"));
        db.insert("news",null,Values.setAndgetValues(1,"社会新闻3","9月25日","全国人民喜迎油价上涨"));
        db.insert("news",null,Values.setAndgetValues(2,"娱乐新闻","9月24日","洛天依假唱"));
        db.insert("news",null,Values.setAndgetValues(2,"娱乐新闻2","9月26日","过气歌姬初音未来来华演唱会"));
        db.insert("news",null,Values.setAndgetValues(3,"财经新闻","9月24日","全国房价崩盘"));
        db.insert("news",null,Values.setAndgetValues(4,"军事新闻","9月27日","我国成功收复台湾"));
    }

}
