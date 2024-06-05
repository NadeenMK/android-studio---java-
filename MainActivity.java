package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button ok,cancel;
    private EditText edit;
    private TextView lab,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        ok.findViewById(R.id.ok);
        cancel.findViewById(R.id.cancel);
        edit.findViewById(R.id.edit);
        lab = findViewById(R.id.lab);
        res = findViewById(R.id.res);

        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        edit.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public static double squareRoot(double n, double ep) {
            double res = n / 2;

            while (Math.abs(res * res - n) > ep) {
                res = (res + n / res) / 2;
            }

            return res;
    }
    @Override
    public void onClick(View v) {
        if(v==ok){
            String s= edit.getText().toString();
            if(s.isEmpty()){
                res.setText("No data is provide!");
            }
            else{
                int n=Integer.parseInt(s);
                double ep = 0.00001;

                double result = squareRoot(n, ep);
                res.setText("the sqr for this number is :"+String.valueOf(result));
            }
        }
        else if(v.getId()==R.id.cancel){
            finish();
        }
        else if(v.getId()==R.id.edit){
            ok.callOnClick();
        }
    }

}