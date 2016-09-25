package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.outi.easynews.R;

import util.Dbutil;

/**
 * Created by outi on 2016/9/25.
 */
public class AddNewActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{

    private EditText titleEdit;
    private EditText timeEdit;
    private EditText contentEdit;
    private Button update;
    private RadioGroup type;
    private int tyoeId;
    private Dbutil dbutil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);
        type=(RadioGroup)findViewById(R.id.type);
        type.setOnCheckedChangeListener(this);
        update=(Button)findViewById(R.id.update);
        update.setOnClickListener(this);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.type1:
                tyoeId=1;
                break;
            case R.id.type2:
                tyoeId=2;
                break;
            case R.id.type3:
                tyoeId=3;
                break;
            case R.id.type4:
                tyoeId=4;
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        String title=titleEdit.getText().toString();
        String time=timeEdit.getText().toString();
        String content=contentEdit.getText().toString();
        dbutil=new Dbutil(this);
        dbutil.Insert(tyoeId,title,time,content);
        dbutil.DbDestroy();
    }
}
