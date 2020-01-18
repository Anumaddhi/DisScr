package com.example.disscr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText paswd,usrnm;
    TextView tv1,tv2,tv3,tv4,tv5,umin;
    Spannable wordtoSpan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paswd=findViewById(R.id.editText6);
        usrnm=findViewById(R.id.editText2);
        tv1=findViewById(R.id.textvieww);




        wordtoSpan = new SpannableString("Use a capital letter, small letter, number and a special character( @, $, _,-,! ). Minimum 8 characters.");
        tv1.setText(wordtoSpan);



        umin=findViewById(R.id.mchar);

        usrnm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String uname=usrnm.getText().toString();
                validateUname(uname);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                /*if(paswd.length()>13){
                    String s;
                    s=paswd.toString();
                    s=s.substring(0,14);
                    paswd.setText(s);
                }
                else {
                    String s;
                    s=paswd.toString();
                    paswd.setText(s);

                }*/

            }
        });
        paswd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String pass=paswd.getText().toString();
                validatePassword(pass);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void validatePassword(String paswd){
        int myColor= getResources().getColor(R.color.darkGrey);
        int ligcol=getResources().getColor(R.color.lightGrey);
        String oneSpecialCharacter = ".*[\\$\\@\\!\\-\\_\\ ].*";
        Pattern upperCase=Pattern.compile("[A-Z]");
        Pattern lowerCase=Pattern.compile("[a-z]");
        Pattern digitCase=Pattern.compile("[0-9]");
        Pattern specialCase=Pattern.compile(oneSpecialCharacter);

        if (!lowerCase.matcher(paswd).find()){
            wordtoSpan.setSpan(new ForegroundColorSpan(myColor), 21, 34, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);

        }
        else{
            wordtoSpan.setSpan(new ForegroundColorSpan(ligcol), 21, 34, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);
        }
        if (!upperCase.matcher(paswd).find()){

            wordtoSpan.setSpan(new ForegroundColorSpan(myColor), 5, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);

        }
        else{
            wordtoSpan.setSpan(new ForegroundColorSpan(ligcol), 5, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);
        }
        if (!digitCase.matcher(paswd).find()){
            wordtoSpan.setSpan(new ForegroundColorSpan(myColor), 36, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);

        }
        else{
            wordtoSpan.setSpan(new ForegroundColorSpan(ligcol), 36, 42, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);
        }
        if (!specialCase.matcher(paswd).find()){
            wordtoSpan.setSpan(new ForegroundColorSpan(myColor), 49, 66, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);

        }
        else{
            wordtoSpan.setSpan(new ForegroundColorSpan(ligcol), 49, 66, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);
        }
        if(paswd.length()<8){
            wordtoSpan.setSpan(new ForegroundColorSpan(myColor), 83, 103, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);

        }
        else {
            wordtoSpan.setSpan(new ForegroundColorSpan(ligcol), 83, 103, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            tv1.setText(wordtoSpan);
        }
    }
    public void validateUname(String uname){
        int myColor= getResources().getColor(R.color.darkGrey);
        int ligcol=getResources().getColor(R.color.lightGrey);
        if(uname.length()<8){
            umin.setTextColor(myColor);

        }
        else{
            umin.setTextColor(ligcol);
        }
    }
}
