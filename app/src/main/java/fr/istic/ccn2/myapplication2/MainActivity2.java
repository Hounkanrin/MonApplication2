package fr.istic.ccn2.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;

public class MainActivity2 extends Activity {

 @Bind(R.id.activity2) TextView donnees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        donnees = (TextView) findViewById(R.id.activity2);
        Intent intent = getIntent();
        String text = (String) intent.getSerializableExtra("vos informations");
        donnees.setText(text);

    }
}
