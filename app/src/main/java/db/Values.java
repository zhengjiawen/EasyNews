package db;

import android.content.ContentValues;

/**
 * Created by outi on 2016/9/24.
 */
public class Values {
    private static ContentValues values=new ContentValues();

    public static void setValues(int type,String title,String time,String content){
        values.put("type",type);
        values.put("title",title);
        values.put("time",time);
        values.put("content",content);
    }

    public static ContentValues getValues(){
        return values;
    }

    public static ContentValues setAndgetValues(int type,String title,String time,String content){
        setValues(type,title,time,content);
        return values;
    }

}
