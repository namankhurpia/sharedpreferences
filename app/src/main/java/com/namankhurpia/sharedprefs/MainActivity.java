package com.namankhurpia.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView savedname;
    private EditText nameedit;
    private Button savebtn;
    private static  final String PREFS_NAME="myfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savedname=(TextView)findViewById(R.id.savedname);
        nameedit=(EditText)findViewById(R.id.editnametext);
        savebtn=(Button)findViewById(R.id.savebtn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences myprefs=getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor=myprefs.edit();

                if(nameedit.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"NOTHING STORED",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    editor.putString("name",nameedit.getText().toString());
                    editor.commit();
                }

            }
        });

        //get the saved value
        SharedPreferences prefs=getSharedPreferences(PREFS_NAME,0);
        if(prefs.contains("name"))
        {
            String username=prefs.getString("name","NOTHING");
            savedname.setText("you are"+username);
        }
        else
        {
            savedname.setText("Nothing was saved earlier");

        }

    }
}
