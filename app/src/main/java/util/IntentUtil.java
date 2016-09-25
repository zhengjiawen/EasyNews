package util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by outi on 2016/9/23.
 */
/*跳转活动的工具*/
public class IntentUtil {
    private static Intent intent;

    public static void StartActivity(Activity currentActivity, Class targetActivity){
        intent=new Intent(currentActivity,targetActivity);
        currentActivity.startActivity(intent);
    }
}
