package com.adefemikolawole.ggcstudentpicker;
import android.R.menu;
import android.app.ListActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();
    private ListView stListView;
    //FLoatingActionBar fLoatingActionBar = new FloatingActionBar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> stList = new ArrayList<>();
        stList.add("Benjamin Franklin");
        stList.add("Elijah Paul");
        stList.add("Samuel  Jackson");
        stList.add("Janet Logan");
        stList.add("Cynthia Johnson");
        stList.add("Paul Washer");
        stList.add("Edward Parker");
        stList.add("Jonah Raul");
        stList.add("Ade Job");
        stList.add("Gabe Union");
        stList.add("Cage Nicholas");
        stList.add("Paul Presley");
        stList.add("Hugh Jackson");
        stList.add("Michael Paul");
        stList.add("Blessing Simi");
        stList.add("Janet Logan");

        stList.add("Adanna Okoro");
        Collections.sort(stList);

        String [] studentList = {"sola", "ade"};
        ListAdapter stListAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stList);
        stListView = findViewById(R.id.lvStudentList);
        stListView.setAdapter(stListAdapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        changeStatusActionBarColor();
        setTvPickedStudent();
        Log.e(TAG, "Application successfully launched...");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.st_picker_menu ,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.menu_about){
            Toast.makeText(MainActivity.this, "Author: Adefemi Kolawole\nITEC 4500 -- Fall 2018", Toast.LENGTH_LONG).show();

        }
        return true;

    }

    public void changeStatusActionBarColor(){
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.darkGreen));
        }
    }

   public void setTvPickedStudent(){
       final TextView tvStPicked = findViewById(R.id.tvStudentPicked);
       stListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String name = String.valueOf(parent.getItemAtPosition(position));
               tvStPicked.setText(name);
           }
       });
   }
}
