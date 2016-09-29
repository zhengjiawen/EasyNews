package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.outi.easynews.R;

import java.util.HashMap;
import java.util.Map;

import util.Dbutil;
/**
 * Created by outi on 2016/9/29.
 */

public class NewsContentActivity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        Dbutil dbutil=new Dbutil(this);

        TextView title=(TextView)findViewById(R.id.content_title);
        TextView time=(TextView)findViewById(R.id.content_time);
        TextView content=(TextView)findViewById(R.id.content);

        Intent intent=getIntent();
        int id=intent.getIntExtra("news",0);
        Map<String,Object> news=dbutil.getNewsContent(id);

        title.setText(news.get("title").toString());
        time.setText(news.get("time").toString());
        content.setText(news.get("content").toString());

    }


}
