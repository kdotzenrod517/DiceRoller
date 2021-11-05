package com.kdotz.listviewdemojava;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = findViewById(R.id.myListView);
        List<String> myFriends = Stream.of("Karina", "Meghana", "Liz", "Lily", "Melinda", "Lauren", "Franny").collect(Collectors.toList());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFriends);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "My friend: " + myFriends.get(position), Toast.LENGTH_SHORT).show();
        });
    }
}
