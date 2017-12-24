package com.example.vignesh.projec1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vignesh on 21/12/17.
 */

public class Signup extends Activity {

    DatabaseHelper databaseHelper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


    }

    public void OnSignup(View view) {
        // Button button1 = (Button) findViewById(R.id.button4);
        if (view.getId() == R.id.button4) {
            EditText Ename = (EditText) findViewById(R.id.editText);
            EditText Email = (EditText) findViewById(R.id.editText2);
            EditText Euname = (EditText) findViewById(R.id.editText3);
            EditText Epass1 = (EditText) findViewById(R.id.editText4);
            EditText Epass2 = (EditText) findViewById(R.id.editText5);


            final String name = Ename.getText().toString();
            String mail = Email.getText().toString();
            String uname = Euname.getText().toString();
            final String pass1 = Epass1.getText().toString();
            final String pass2 = Epass2.getText().toString();

            if (!pass1.equals(pass2))
                Toast.makeText(Signup.this,"PassWord Do Not Match",Toast.LENGTH_LONG).show();
            else{
                User contact=new User();
                contact.setName(name);
                contact.setEmail(mail);
                contact.setUname(uname);
                contact.setPass(pass1);

                databaseHelper.insertUser(contact);
                Toast.makeText(Signup.this,"User Saved",Toast.LENGTH_LONG).show();
            }

        }


    }
}
/*Button button = (Button) findViewById(R.id.button4);
        //  }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pass1.equals(pass2))
                    Toast.makeText(Signup.this,"Password do not match",Toast.LENGTH_LONG).show();

            }
        });

       while (true)
           Toast.makeText(Signup.this,"Samle",Toast.LENGTH_LONG).show();

    }*/