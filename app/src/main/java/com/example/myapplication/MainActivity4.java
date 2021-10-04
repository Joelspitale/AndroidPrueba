package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import profile.recyclerView.ListAdapter;
import profile.recyclerView.Profile;
import profile.recyclerView.RecyclerViewOnClickListener;

public class  MainActivity4 extends AppCompatActivity implements RecyclerViewOnClickListener {

    private List profileList = new ArrayList<Profile>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        initProfiles();

        RecyclerView recyclerView = findViewById(R.id.recycler_view_profile_list);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        //le coloco el adapter que ya hemos hecho
        recyclerView.setAdapter(new ListAdapter(profileList, this));

    }

    private void initProfiles(){
        profileList.add(new Profile(getString(R.string.red), getString(R.string.redHex)));
        profileList.add(new Profile(getString(R.string.indigo), getString(R.string.indigoHex)));
        profileList.add(new Profile(getString(R.string.green), getString(R.string.greenHex)));
        profileList.add(new Profile(getString(R.string.orange), getString(R.string.orangeHex)));
        profileList.add(new Profile(getString(R.string.blue), getString(R.string.blueHex)));
        profileList.add(new Profile(getString(R.string.yellow), getString(R.string.yellowHex)));
        profileList.add(new Profile(getString(R.string.grey), getString(R.string.greyHex)));
        profileList.add(new Profile(getString(R.string.teal), getString(R.string.tealHex)));
        profileList.add(new Profile(getString(R.string.deeppurple), getString(R.string.deeppurpleHex)));
        profileList.add(new Profile(getString(R.string.cyan), getString(R.string.cyanHex)));
        profileList.add(new Profile(getString(R.string.brown), getString(R.string.brownHex)));
    }

    @Override
    public View.OnClickListener onItemClick(int position) {
        Toast.makeText(this, "Su color seleccionado es: ${profileList[position].name}", Toast.LENGTH_SHORT).show();
        return null;
    }
}