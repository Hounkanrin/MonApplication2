package fr.istic.ccn2.myapplication2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";
    private List<ClientItem> list;

    public RecyclerViewAdapter( List<ClientItem> list) {
        this.list = list;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called,");
       ClientItem clientItem = list.get(i);
        myViewHolder.name.setText(clientItem.getName());
        myViewHolder.lastname.setText(clientItem.getLastname());
        myViewHolder.date.setText(clientItem.getDate());
        myViewHolder.ville.setText(clientItem.getVille());
        myViewHolder.departement.setText(clientItem.getDepartement());

      /*  myViewHolder.layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence text = "Votre nom est " + name.getText().toString()
                        + " "
                        + lastname.getText().toString() + " naissance " + date.getText().toString()
                        + " ville " + ville.getText().toString() + " departement " + spinner.getSelectedItem().toString() ;
                Toast.makeText("Info", text,Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
         return this.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView lastname;
        TextView date;
        TextView ville;
        TextView departement;
        LinearLayout layout3;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.lname);
            lastname = itemView.findViewById(R.id.llastname);
            date = itemView.findViewById(R.id.ldate);
            ville = itemView.findViewById(R.id.lville);
            departement = itemView.findViewById(R.id.departement);
            layout3 = itemView.findViewById(R.id.layout3);

        }
    }

}
