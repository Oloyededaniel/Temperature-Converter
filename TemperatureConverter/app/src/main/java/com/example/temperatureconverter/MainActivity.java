package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText from, to, value;
    Button convert;
    TextView result;
    double celsius, Fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        from=findViewById(R.id.editText);
        to=findViewById(R.id.edittext2);
        convert=findViewById(R.id.btnConvert);
        value=findViewById(R.id.edittext3);
        result=findViewById(R.id.Result);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((from.getText().toString().trim().equalsIgnoreCase("Celsius"))&&(to.getText().toString().trim().equalsIgnoreCase("Celsius"))||(from.getText().toString().trim().equalsIgnoreCase("Fahrenheit"))&&(to.getText().toString().trim().equalsIgnoreCase("Fahrenheit"))) {
                    from.setError("both cannot be same");
                    to.setError("both cannot be same");
                    Toast.makeText(MainActivity.this, "Both cannot be the same Unit!!!", Toast.LENGTH_SHORT).show();
                }

                else if((from.getText().toString().trim().equalsIgnoreCase("Celsius"))&&(to.getText().toString().trim().equalsIgnoreCase("Fahrenheit"))){

                    celsius=Double.parseDouble(value.getText().toString());

                    Fahrenheit=(celsius*1.8)+32;
                    String s1=String.format("%.1f",Fahrenheit);
                    result.setText(s1+" F");
                    from.setText("");
                    to.setText("");
                    value.setText("");
                    Toast.makeText(MainActivity.this, s1+" F", Toast.LENGTH_SHORT).show();
                }
                else if((from.getText().toString().trim().equalsIgnoreCase("Fahrenheit"))&&(to.getText().toString().trim().equalsIgnoreCase("celsius"))) {

                    Fahrenheit=Double.parseDouble(value.getText().toString());

                    celsius=(5*(Fahrenheit-32))/9;
                    String s1=String.format("%.1f",celsius);
                    result.setText(s1+" C");
                    Toast.makeText(MainActivity.this, s1+" C", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
