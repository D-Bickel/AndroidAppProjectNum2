package com.example.androidappprojectnum2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    String url = "https://www.valleycollege.edu";
    String user = "Hector_Ostia";
    String pass = "Fire_Emblem_07";

    Button hello;
    Button sbvc_site;
    Button email;
    Button submit;
    Button username_hint;
    Button pass_hint;

    Intent go_to_site;
    Intent open_email;

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hello = (Button)findViewById(R.id.greet);
        sbvc_site = (Button)findViewById(R.id.web);
        email = (Button)findViewById(R.id.email);
        username_hint = (Button)findViewById(R.id.user_hint);
        pass_hint = (Button)findViewById(R.id.pass_hint);
        submit = (Button)findViewById(R.id.login);

        go_to_site = new Intent(Intent.ACTION_VIEW);
        open_email = new Intent(Intent.ACTION_VIEW);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello SBVC!", Toast.LENGTH_SHORT).show();
            }
        });

        sbvc_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_to_site.setData(Uri.parse(url));
                startActivity(go_to_site);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_email.setData(Uri.parse("mailto:info@valleycollege.edu"));
                startActivity(open_email);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.equals(username.getText().toString())) {
                    if (pass.equals(password.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Wrong Username", Toast.LENGTH_SHORT).show();
                }
                username.setText("");
                password.setText("");
            }
        });

        username_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, user, Toast.LENGTH_SHORT).show();
            }
        });

        pass_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, pass, Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}