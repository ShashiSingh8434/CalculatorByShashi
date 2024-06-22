package com.example.calculatorbyshashi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public String getInput(){
        EditText editText = findViewById(R.id.inputView);
        return editText.getText().toString();
    }

    public String[] terms(String expression){
        String[] output = new String[3];
        String[] sample = {"+","-","*","/"};
        int[] index = new int[4];

        for (int i = 0; i < 4; i++) {
            index[i] = expression.indexOf(sample[i]);
        }

        if(index[3]!=(-1)){
            output[0] = expression.substring(0,index[3]);
            output[1] = "/";
            output[2] = expression.substring(index[3]+1);
        } else if (index[2]!=(-1)) {
            output[0] = expression.substring(0,index[2]);
            output[1] = "*";
            output[2] = expression.substring(index[2]+1);
        } else if (index[1]!=(-1)) {
            output[0] = expression.substring(0,index[1]);
            output[1] = "-";
            output[2] = expression.substring(index[1]+1);
        } else if (index[0]!=(-1)) {
            output[0] = expression.substring(0,index[0]);
            output[1] = "+";
            output[2] = expression.substring(index[0]+1);
        }else{
            System.out.println("Invalid");
        }

        return output;
    }

    public boolean check(String arg){

        String[] sample = {"+","-","*","/"};
        boolean out = false;
//---------------------------------------------------------------
        try {
            for(String i : sample){
                if (arg.contains(i)) {
                    out = true;
                    break;
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "HHHnnn", Toast.LENGTH_SHORT).show();
        }

        return out;
    }

//------------------------------------------------------------
    public void run(String[] num){
        try {

        if (check(num[0])) {
            num[0] = String.valueOf(calculate(terms(num[0])));
        }
        if (check(num[2])) {
            num[2] = String.valueOf(calculate(terms(num[2])));
        }


        }catch (Exception e){
            Toast.makeText(this, "HHHnnn", Toast.LENGTH_SHORT).show();
        }
    }
//---------------------------------------------------
    public int calculate(String[] num){
        run(num);

        try{

        switch (num[1]) {
            case "+" : {
                return Integer.parseInt(num[0]) + Integer.parseInt(num[2]);
            }
            case "-" : {
                return Integer.parseInt(num[0]) - Integer.parseInt(num[2]);
            }
            case "*": {
                return Integer.parseInt(num[0]) * Integer.parseInt(num[2]);
            }
            case "/" : {
                return Integer.parseInt(num[0]) / Integer.parseInt(num[2]);
            }
            default : {
                System.out.println("Error");
                return 0;
            }
        }


        }catch (Exception e){
            Toast.makeText(this, "HHHnnn", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
    public String lol(){
        return "Hello";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.inputView);
        TextView textView = findViewById(R.id.resultView);
        Button submit =  findViewById(R.id.submit);
        Button reset = findViewById(R.id.reset);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(Integer.toString(calculate(terms(getInput()))));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                textView.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}