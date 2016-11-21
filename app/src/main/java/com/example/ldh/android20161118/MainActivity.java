package com.example.ldh.android20161118;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView t1, t2;
    CheckBox cb;
    RadioButton r1, r2, r3;
    RadioGroup rg;
    ImageView iview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");
        button = (Button)findViewById(R.id.button);
        t1 = (TextView)findViewById(R.id.textview1);
        t2 = (TextView)findViewById(R.id.textView2);
        cb = (CheckBox)findViewById(R.id.checkBox);
        rg = (RadioGroup)findViewById(R.id.rg);
        r1 = (RadioButton)findViewById(R.id.radioButton1);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        r3 = (RadioButton)findViewById(R.id.radioButton3);
        iview =(ImageView)findViewById(R.id.imageView);

        iview.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked ==true){
                    t2.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);

                }
                else {
                    t2.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    iview.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.getId()==R.id.rg){
                    switch (checkedId){
                        case R.id.radioButton1 :
                            Toast.makeText(getApplicationContext(),"강아지를 선택하였습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.radioButton2 :
                            Toast.makeText(getApplicationContext(), "고양이를 선택하였습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.radioButton3 :
                            Toast.makeText(getApplicationContext(), "토끼를 선택하였습니다.", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r1.isChecked()){
                    iview.setImageResource(R.drawable.dog);
                    iview.setVisibility(View.VISIBLE);
                }
                else if(r2.isChecked()){
                    iview.setImageResource(R.drawable.cat);
                    iview.setVisibility(View.VISIBLE);
                }
                else if(r3.isChecked()){
                    iview.setImageResource(R.drawable.rabbit);
                    iview.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
