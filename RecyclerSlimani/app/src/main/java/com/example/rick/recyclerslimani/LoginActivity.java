package com.example.rick.recyclerslimani;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rick.recyclerslimani.db.MyDatabase;
import com.example.rick.recyclerslimani.db.User;

import org.w3c.dom.Text;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {
    int i = 0;
    RelativeLayout relat1;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relat1.setVisibility(View.VISIBLE);
        }
    };
    static User user =new User();
    static MyDatabase myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.i("tag","On create");

        Button login_butt = (Button) findViewById(R.id.login_butt);
        TextView new_acc = (TextView) findViewById(R.id.new_acc);
        final EditText username_t = (EditText) findViewById(R.id.et_username);
        final EditText password_t = (EditText) findViewById(R.id.et_password);
        myDatabase = Room
                .databaseBuilder(getApplicationContext(),MyDatabase.class,"user_db")
                .allowMainThreadQueries()
                .build();

        login_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("my butt listner", "onClick: I have clicked on the login button");
                user.setUsername(username_t.getText().toString().trim());
                user.setPassword(password_t.getText().toString().trim());
                Log.d("User", "User "+user.getUsername()+" password:"+user.getPassword());
                if(!user.getUsername().matches("")){
                    List<User> db_user = LoginActivity.myDatabase.my_dao().getUser(user.getUsername());
                    Log.i("Room", "List of users after the Query"+db_user);
                    //If the Query found someone
                    if(db_user.size()!=0){
                        //if the password matches
                        if(db_user.get(0).getPassword().contentEquals(user.getPassword())){
                            //then the login is successful
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            LoginActivity.this.startActivity(intent);
                        }else{
                            //the password was incorrect
                            Toasty.error(LoginActivity.this,"Wrong Password").show();
                        }
                    }else{
                        //User doesnt exist
                        Toasty.error(LoginActivity.this,"User Does not exist!").show();
                    }
                }else{
                    Toasty.error(LoginActivity.this,"Please Enter Username").show();
                }
            }
        });

        new_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("add account", "onClick: I have clicked on the add account!");
                user.setUsername(username_t.getText().toString().trim());
                user.setPassword(password_t.getText().toString().trim());
                Log.d("User", "User "+user.getUsername()+" password:"+user.getPassword());
                if(!(username_t.getText().toString()).matches("")){
                    List<User> db_user = LoginActivity.myDatabase.my_dao().getUser(user.getUsername());
                    Log.i("Room", "List of users after the Query"+db_user);
                    if(db_user.size()!=0){
                        //I have found someone with the same username
                        Toasty.error(LoginActivity.this,"User Already Exists!").show();
                    }else{
                        //No one has the same Username So I am going to add the user
                        LoginActivity.myDatabase.my_dao().addUser(user);
                        Toasty.success(LoginActivity.this,"User has been added").show();
                    }
                }else{
                    Toasty.error(LoginActivity.this,"Please Enter Username").show();
                }
            }
        });

        Log.d("ALL USERs", ""+myDatabase.my_dao().getUsers());
        relat1 = (RelativeLayout)findViewById(R.id.relat1);
        handler.postDelayed(runnable,1500);


    }



}
