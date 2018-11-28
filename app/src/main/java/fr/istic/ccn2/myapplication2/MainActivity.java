package fr.istic.ccn2.myapplication2;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{

    @Bind(R.id.valider) Button addValider;
    @Bind(R.id.name) TextView name;
    @Bind(R.id.lastname) TextView lastname;
    @Bind(R.id.ville) TextView ville;
    @Bind(R.id.date) TextView date;
    @Bind(R.id.dateNaissance) TextView dateNaissance;
    @Bind(R.id.layout) LinearLayout parentLinearLayout;
    private Spinner spinner = null;
    private View view;
/* Intent intent = new Intent().setClass(this, )Intent.ACTION_VIEW,
            Uri.parse("http://fr.wikipedia.org"));*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.departements_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        addValider = (Button) findViewById(R.id.valider);
        addValider.setOnClickListener(new AddButtonClickHandle());
    }
    public class AddButtonClickHandle implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            CharSequence text = "Votre nom est " + name.getText().toString()
                    + " "
                    + lastname.getText().toString() + " naissance " + date.getText().toString()
                    + " ville " + ville.getText().toString() + " departement " + spinner.getSelectedItem().toString() ;
            Intent activity2Intent = new Intent(MainActivity.this, MainActivity2.class);
            activity2Intent.putExtra("vos informations", text);
            startActivity(activity2Intent);


        }
    }
           /* @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Votre nom est " + name.getText().toString()
                        + " "
                        + lastname.getText().toString() + " naissance " + date.getText().toString()
                        + " ville " + ville.getText().toString() + " departement " + spinner.getSelectedItem().toString() ;

                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void onClear(){
        EditText field;
        int [] temp = new int []{
                R.id.name,
                R.id.lastname,
                R.id.ville,
                R.id.date,
        };

        for (int i = 0; i < temp.length; i++){
            field = (EditText) findViewById (temp[i]);
            field.setText(null);
        }

    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                onClear();
                return true;
            case R.id.add_phone:
                onAddField(view);
            case  R.id.browser:
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://fr.wikipedia.org/wiki/"+ spinner.getSelectedItem().toString()));
                startActivity(i);


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        Toast.makeText(getBaseContext(),parent.getItemAtPosition(i)+"selected",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {}
}

