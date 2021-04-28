package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input1;
    private EditText input2;
    private Button btn;
    private Spinner spin;
    private TextView t1;
    int n1,n2,result;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        btn = (Button) findViewById(R.id.btn);
        spin = (Spinner) findViewById(R.id.spinner);
        t1 = (TextView) findViewById(R.id.t1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        i=0;
                        break;
                    case 1:
                        i=1;
                        break;
                    case 2:
                        i=2;
                        break;
                    case 3:
                        i=3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(input1.getText().toString());
                n2 = Integer.parseInt(input2.getText().toString());
                if(i==0)
                    result = n1 + n2;
                else if(i==1)
                    result = n1 - n2;
                else if(i==2)
                    result = n1 * n2;
                else if(i==3)
                    result = n1 / n2;

                t1.setText(Integer.toString(result));
            }
        });

    }

}

