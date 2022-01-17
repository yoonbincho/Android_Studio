package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    String[] opStr = {"+", "-"};// +,- 문자를 넣어줌
    Random random = new Random();//랜덤한 숫자 소환
    int num1 = random.nextInt(99)+1 ;//1~99안에 숫자
    int num2 = random.nextInt(99)+1;
    int op = random.nextInt(2);//0 또는 1의 숫자
    String numStr1 = String.valueOf(num1);
    String numStr2 = String.valueOf(num2);
    String cal = numStr1 + opStr[op] + numStr2;
    int result;
    int count= 0, correct = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//맨 위의 텍스트뷰
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.text);
        switch(op){
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
        }
        textView1.setText(cal + "=");//수식을 호출함

        Button button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {//입력 완료 버튼을 눌렀을 때 호출되는 메서드
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.Edit1);
                String str = editText.getText().toString();
                if(str.equals("")){//빈칸일 경우
                    Toast.makeText(getApplicationContext(),
                            "답을 입력하세요.", Toast.LENGTH_SHORT).show();//토스트 메세지 생성
                    return;
                }
                if(Integer.parseInt(str) == result) {//result가 같을 때
                    Toast.makeText(getApplicationContext(), "맞습니다.", Toast.LENGTH_LONG).show();
                    count++;
                    correct++;//1씩 올려줌
                    createCal(view);
                    editText.getText().clear();
                }else{
                    Toast.makeText(getApplicationContext(), "틀렸습니다. 정답은 " + result, Toast.LENGTH_LONG).show();
                    editText.getText().clear();
                    count++;
                }
            }
        });
        Button button2 = (Button) findViewById(R.id.Button2);
        button2.setOnClickListener(new View.OnClickListener() {//새 수식 생성 버튼을 눌렀을 때 호출되는 메서드
            @Override
            public void onClick(View view) {
                createCal(view);
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {//종료버튼을 눌렀을 때 호출되는 메서드
            @Override
            public void onClick(View view) {
                textView2 = findViewById(R.id.text2);
                textView2.setText(String.valueOf(count) + "번 중에 "
                        + String.valueOf(correct) + "번 성공, 정답률:" + String.valueOf((double)correct /(double)count * 100) + "%");
            }
        });
    }
    public void createCal(View view){
        String[] oper = {"+", "-"};
        Random random = new Random();
        int num1 = random.nextInt(99) + 1;//랜덤한 수를 넣어줌
        int num2 = random.nextInt(99) + 1;
        int op = random.nextInt(2);
        String numStr1 = String.valueOf(num1);
        String numStr2 = String.valueOf(num2);
        String cal = numStr1 + oper[op] + numStr2;
        switch (op) {
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
        }
        textView1.setText(cal + "=");
    }
}