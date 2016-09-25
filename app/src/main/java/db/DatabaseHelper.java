package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import util.ToastUtil;

/**
 * Created by outi on 2016/9/24.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
        final String CREATE_TABLE_SQL="create table news ("             //新闻数据
                +"id integer primary key autoincrement, "               //1是社会新闻
                +"type integer, "                                          //2是娱乐新闻
                +"title text, "                                             //3是财经新闻
                +"time text, "                                              //4是军事新闻
                +"content text)";
        private Context mcontext;
    public DatabaseHelper(Context context,String name,int version){
        super(context,name,null,version);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
        ToastUtil.ShowMessage(mcontext,"succeed");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
