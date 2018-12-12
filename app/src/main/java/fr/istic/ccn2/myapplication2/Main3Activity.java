package fr.istic.ccn2.myapplication2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    Button ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //ButterKnife.bind(this);

        ajouter = (Button) findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new AddButtonClick());

        //Intent intent = getIntent();
      //  User user = intent.getParcelableExtra("user");

        //Log.d("M"," Mais"+user.getmLastname());

       /* List<ClientItem> listClient = new ArrayList<>();
        listClient.add(new ClientItem("vivi","houn", "12/12/12","rennes", "ille-et-vilaine"));
        listClient.add(new ClientItem("viviane","houn", "12/12/12","rennes", "ille-et-vilaine"));
       if(user !=null){
            listClient.add(new ClientItem(user.getmName(), user.getmLastname(), user.getmDate(), user.getmVille(), user.getmDepartement()));
        }*/

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);

        ClientDatabase db = Room.databaseBuilder(getApplicationContext(), ClientDatabase.class, "data")
                .allowMainThreadQueries()
                .build();

        List<ClientItem> listClient = db.clientDao().getAllClient();

        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(listClient);
        recyclerView.setAdapter(recyclerViewAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public class AddButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent activity3Intent = new Intent(Main3Activity.this, MainActivity.class);
            startActivity(activity3Intent);
        }
    }
}
