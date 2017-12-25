package com.example.vignesh.projec1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;

    Button button;
    DatabaseHelper databaseHelper=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Signup.class);
                startActivity(intent);;
            }
        });

        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uname1=(EditText)findViewById(R.id.et1);
                EditText pass1=(EditText)findViewById(R.id.et2);
                String uname=uname1.getText().toString();
                String pass=pass1.getText().toString();

                String password=databaseHelper.searchPass(pass);
                if (pass.equals(password)){
                    Toast.makeText(MainActivity.this,"Welcome Budyyy",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(MainActivity.this,"User Invalid",Toast.LENGTH_LONG).show();
            }



        });


    }
    //New Way to Access button




}
