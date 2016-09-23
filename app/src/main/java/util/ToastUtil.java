package util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by outi on 2016/9/23.
 */
public class ToastUtil {
    private static Toast toast=null;
    public static void ShowMessage(Context context, String text){
        if(toast==null){
            toast.makeText(context,text,Toast.LENGTH_SHORT).show();
        }
        else{
            toast.setText(text);
        }
    }
}
