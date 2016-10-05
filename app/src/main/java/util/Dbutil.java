package util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.outi.easynews.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import db.DatabaseHelper;
import db.Values;
import util.ToastUtil;

/**
 * Created by outi on 2016/9/24.
 */
/*数据库操作*/
public class Dbutil{

    private DatabaseHelper dbhelper;
    private SQLiteDatabase db;
    private  List<Map<String,Object>> listNews=new ArrayList<Map<String, Object>>();

    public Dbutil(Context context) {
        dbhelper=new DatabaseHelper(context,"EasyNews.db",1);
        db=dbhelper.getWritableDatabase();
        init();                                                     //初始化
    }

    public void DbDestroy() {
        if(dbhelper!=null){
            dbhelper.close();
        }
    }

    public void Insert(int type,String title,String time,String content){
        db.insert("news",null,Values.setAndgetValues(type,title,time,content));
    }

    public List<Map<String,Object>> Query(int targetType){
        Cursor cursor=db.query("news",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                int type=cursor.getInt(cursor.getColumnIndex("type"));
                if(type==targetType||targetType==0){                       //0时查询全部数据
                    HashMap<String,Object> mapNew= new HashMap<String,Object>();
                    String title=cursor.getString(cursor.getColumnIndex("title"));
                    String time=cursor.getString(cursor.getColumnIndex("time"));
                    String content=cursor.getString(cursor.getColumnIndex("content"));
                    int id=cursor.getShort(cursor.getColumnIndex("id"));
                    mapNew.put("title",title);
                    mapNew.put("time",time);
                    mapNew.put("content",content);
                    mapNew.put("id",id);
                    listNews.add(mapNew);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listNews;
    }

    public Map<String ,Object> getNewsContent(int targetID){
        Cursor cursor=db.query("news",null,null,null,null,null,null);
        HashMap<String,Object> mapNew= null;
        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                if (id == targetID) {
                    mapNew = new HashMap<String, Object>();
                    String title = cursor.getString(cursor.getColumnIndex("title"));
                    String time = cursor.getString(cursor.getColumnIndex("time"));
                    String content = cursor.getString(cursor.getColumnIndex("content"));
                    mapNew.put("title", title);
                    mapNew.put("time", time);
                    mapNew.put("content", content);
                    break;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return mapNew;
    }

    public void init(){
        Cursor cursor=db.query("news",null,null,null,null,null,null);                            //查询全部数据
        if(cursor.getCount()==0) {                                                                //表中行数为0，未初始化时进行初始化
            db.insert("news", null, Values.setAndgetValues(1, "社会新闻", "9.24", "电子科大获捐10.3亿"));
            Values.Clear();
            db.insert("news", null, Values.setAndgetValues(1, "社会新闻2", "9.24", "电子科大获60周年校庆"));
            Values.Clear();
            db.insert("news", null, Values.setAndgetValues(1, "社会新闻3", "9.25", "全国人民喜迎油价上涨"));
            Values.Clear();
            db.insert("news", null, Values.setAndgetValues(2, "娱乐新闻", "9.24", "洛天依假唱"));
            Values.Clear();
            db.insert("news", null, Values.setAndgetValues(2, "娱乐新闻2", "9.26", "过气歌姬初音未来来华演唱会"));
            Values.Clear();
            db.insert("news", null, Values.setAndgetValues(3, "财经新闻", "9.24", "全国房价崩盘"));
            Values.Clear();
            db.insert("news", null, Values.setAndgetValues(4, "军事新闻", "9.27", "我国成功收复台湾"));
            Values.Clear();
        }
    }


}
