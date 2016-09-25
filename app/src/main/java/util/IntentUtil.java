package util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by outi on 2016/9/23.
 */
/*跳转活动的工具*/
public class IntentUtil {

    public static void StartActivity(Context context, Class targetActivity){
        Intent intent=new Intent(context,targetActivity);
        context.startActivity(intent);
    }
}
