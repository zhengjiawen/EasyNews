package util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.outi.easynews.R;

import db.DatabaseHelper;
import db.Values;
import util.ToastUtil;

/**
 * Created by outi on 2016/9/24.
 */
public class Dbutil extends AppCompatActivity {

    private DatabaseHelper dbhelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper=new DatabaseHelper(this,"EasyNews",1);
        db=dbhelper.getWritableDatabase();
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbhelper!=null){
            dbhelper.close();
        }
    }

    private void init(){
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(1,"社会新闻","9月24日","电子科大获捐10.3亿"));
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(1,"社会新闻2","9月24日","电子科大获60周年校庆"));
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(1,"社会新闻3","9月25日","全国人民喜迎油价上涨"));
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(2,"娱乐新闻","9月24日","洛天依假唱"));
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(2,"娱乐新闻2","9月26日","过气歌姬初音未来来华演唱会"));
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(3,"财经新闻","9月24日","全国房价崩盘"));
        db.insert(dbhelper.getDatabaseName(),null,Values.setAndgetValues(4,"军事新闻","9月27日","我国成功收复台湾"));
    }
}
