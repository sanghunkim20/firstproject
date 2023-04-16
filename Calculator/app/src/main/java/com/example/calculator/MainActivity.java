package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4;
    Button btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;
    Button btnAdd, btnMin, btnMul, btnDiv;
    TextView editResult;
    String num1, num2;
    Integer result;
    float fResult;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4
    , R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블 레이아웃 계산기");

 
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        
        editResult = (TextView) findViewById(R.id.editResult);

        
        for(int i=0; i<numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

       
        for(int i=0; i<numBtnIDs.length; i++) {
            final int index;
            index = i;

           
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused() == true) {
                        num2 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }
                    
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요.",
                                Toast.LENGTH_SHORT). show();
                    }
                }
            });
        }

        
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                editResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        
        btnMin.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                editResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                editResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

       
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                fResult = (float)result;
                editResult.setText("계산 결과 : " + Float.toString(fResult));
                return false;
            }
        });
    }
}