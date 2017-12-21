package com.example.vignesh.projec1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vignesh on 21/12/17.
 */

public class Signup extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

    }
    public void OnSignup(View view){
        EditText Ename=(EditText)findViewById(R.id.editText);
        EditText Email=(EditText)findViewById(R.id.editText2);
        EditText Euname=(EditText)findViewById(R.id.editText3);
        EditText Epass1=(EditText)findViewById(R.id.editText4);
        EditText Epass2=(EditText)findViewById(R.id.editText5);

        String name=Ename.getText().toString();
        String mail=Email.getText().toString();
        String uname=Euname.getText().toString();
        String pass1=Epass1.getText().toString();
        String pass2=Epass2.getText().toString();

        if(!pass1.equals(pass2)){
            Toast.makeText(Signup.this,"Password Do Not Match",Toast.LENGTH_LONG).show();
        }
        Toast.makeText(Signup.this,"")
    }
}
