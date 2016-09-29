package activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by outi on 2016/9/29.
 */

public class ActivityCollector {
    public static List<Activity> ListActivities=new ArrayList<>();

    public static void addActivity(Activity activity){
        ListActivities.add(activity);
    }

    public static void removeActivity(Activity activity){
        ListActivities.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:ListActivities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
