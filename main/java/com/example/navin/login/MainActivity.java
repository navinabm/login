package com.example.navin.login;


import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter=5;
    private TextView userRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =(EditText)findViewById(R.id.etName);
        password=(EditText)findViewById(R.id.etpassword);
        info=(TextView)findViewById(R.id.tvinfo);
        login=(Button)findViewById(R.id.btnlogin);
        userRegistration=(TextView)findViewById(R.id.tvRegister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(name.getText().toString() , password.getText().toString()); // passing the id and password to validate function
            }
        });



        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));

            }
        });

    }

    private void Validate(String userName, String userPassword)
    {
        if((userName.equals("Navin")) && (userPassword.equals("1234")))
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);  //to move to the next activity
            startActivity(intent);
        }
        else
        {
            counter--;
            info.setText("No of remaining attempts :"+ String.valueOf(counter));

            if(counter==0)
            {
                login.setEnabled(false); //to deactivate the login button
            }
        }
    }
}
