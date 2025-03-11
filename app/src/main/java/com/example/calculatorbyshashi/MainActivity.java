package com.example.calculatorbyshashi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public String getInput(){
        TextView expression = findViewById(R.id.inputView);
        return expression.getText().toString();
    }

    public String[] terms(String expression){
        String[] output = new String[3];
        String[] sample = {"+","-","*","/"};
        int[] index = new int[4];

        for (int i = 0; i < 4; i++) {
            index[i] = expression.indexOf(sample[i]);
        }

        if (index[1]!=(-1)) {
            output[0] = expression.substring(0,index[1]);
            output[1] = "-";
            output[2] = expression.substring(index[1]+1);
        } else if (index[0]!=(-1)) {
            output[0] = expression.substring(0,index[0]);
            output[1] = "+";
            output[2] = expression.substring(index[0]+1);
        } else if (index[2]!=(-1)) {
            output[0] = expression.substring(0,index[2]);
            output[1] = "*";
            output[2] = expression.substring(index[2]+1);
        } else if(index[3]!=(-1)){
            output[0] = expression.substring(0,index[3]);
            output[1] = "/";
            output[2] = expression.substring(index[3]+1);
        } else{
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

        TextView expression = findViewById(R.id.inputView);
        TextView resultView = findViewById(R.id.resultView);
        Button submit =  findViewById(R.id.submit);
        Button reset = findViewById(R.id.removeAll);

        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.subtract);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("9");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("/");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("-");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultView.setText(Integer.toString(calculate(terms(getInput()))));
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Give valid expression", Toast.LENGTH_SHORT).show();
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String text = expression.getText().toString();
                    expression.setText(text.subSequence(0,text.length()-1));

                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Give valid expression", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}