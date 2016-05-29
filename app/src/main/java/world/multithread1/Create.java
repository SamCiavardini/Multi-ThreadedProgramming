package world.multithread1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Sam on 2016-05-27.
 */
public class Create extends AppCompatActivity implements Runnable {
    private String name;
    Button button;
    FileOutputStream outputStream;
    public Create(Button theButton, String theName){
        name="numbers.txt";
        button = theButton;
        //outputStream = theOutputStream;
    }
    public void run(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream outputStream;
                //check to see if file exists
                // bool exists() or bool createNewFile()

                try {
                    outputStream = getApplicationContext().openFileOutput(name, Context.MODE_PRIVATE);
                    for(int i = 1; i <= 10; i++) {
                        outputStream.write(i);
                    }
                    outputStream.close();
                }

                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
