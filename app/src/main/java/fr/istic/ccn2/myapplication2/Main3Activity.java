package fr.istic.ccn2.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @Bind(R.id.ajouter) Button ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        ajouter = (Button) findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new AddButtonClick());
    }

    public class AddButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent activity3Intent = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(activity3Intent);
        }
    }
}
