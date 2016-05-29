package world.multithread1;

import android.content.Context;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.ProgressBar;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Button createButton;
    Button loadButton;
    Button clearButton;
    ListView listView;
    public static ProgressBar progressBar;
    List<String> list = new ArrayList<>();
    Context context;
    public static String filename = "numbers.txt";

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final File file = new File(getFilesDir(), filename);

        listView = (ListView) findViewById(R.id.listView);
        createButton = (Button)findViewById(R.id.button);
        loadButton = (Button)findViewById(R.id.button2);
        clearButton = (Button)findViewById(R.id.button3);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        progressBar.setMax(10);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                adapter.clear();

            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fos;
                //context = getApplicationContext();
                Task task = new Task();
                task.doInBackground(file);
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();
                FileInputStream fin = null;
                try {
                    fin = openFileInput("numbers.txt");
                }
                catch(FileNotFoundException e){e.printStackTrace();}

                Task task = new Task();
                task.doInBackground(fin, list);

                adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(adapter);
            }
        });
    }


}

