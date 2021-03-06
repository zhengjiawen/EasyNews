package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.outi.easynews.R;

import util.IntentUtil;
import util.ToastUtil;

/**
 * Created by outi on 2016/9/22.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button login;
    private EditText accountEdit;
    private EditText passwardEdit;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        accountEdit=(EditText)findViewById(R.id.account);
        passwardEdit=(EditText)findViewById(R.id.passward);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.login:
                verify();
                break;
            default:    break;
        }
    }

    public void verify(){                                            //验证账号和密码
        String account=accountEdit.getText().toString();
        String passward=passwardEdit.getText().toString();
        if(account.equals("")&&passward.equals("")){                //输入账户密码
            IntentUtil.StartActivity(this, ShowNewsActivity.class);
        }else
        {
            ToastUtil.ShowMessage(this,"账号或者密码错误");
        }
    }
}
