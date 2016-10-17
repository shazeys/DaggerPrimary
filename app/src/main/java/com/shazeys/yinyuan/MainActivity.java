package com.shazeys.yinyuan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shazeys.yinyuan.dagger.DaggerPeopleComponent;
import com.shazeys.yinyuan.entity.Man;
import com.shazeys.yinyuan.entity.People;
import com.shazeys.yinyuan.entity.Woman;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
//    // 不同的返回类型，直接inject就可以了
//    @Inject
//    Woman woman;
//    @Inject
//    Man man;
    //因为下面两个类型相同，必须用named标签来区分
    @Inject @Named("nv")
    People woman;
    @Inject @Named("nan")
    People man;

    EditText edtNan;
    EditText edtNv;
    TextView txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerPeopleComponent.builder()//接收到外卖了
                .build()
                .inject(this);
        edtNan = (EditText) findViewById(R.id.edt_man);
        edtNv = (EditText) findViewById(R.id.edt_woman);
        txtScore = (TextView) findViewById(R.id.txt_score);
        Button btnCompute = (Button) findViewById(R.id.btn_compute);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInput())
                    compute();
            }
        });
    }

    /**
     * 计算得分并显示
     */
    private void compute() {
        int nan = man.getScore(edtNan.getText().toString());
        int nv = woman.getScore(edtNv.getText().toString());
        int result = (nan+nv)%100;
        txtScore.setText("得分："+result);
    }

    /**
     * 判断输入值
     * @return
     */
    boolean checkInput(){
        if (edtNan.getText().toString().equals("")){
            showToast("请输入男名");
            return false;
        }
        if (edtNv.getText().toString().equals("")){
            showToast("请输入女名");
            return false;
        }
        return true;
    }

    void showToast(String tip){
        Toast.makeText(this,tip,Toast.LENGTH_SHORT).show();
    }
}
