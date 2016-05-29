package world.multithread1;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;

/**
 * Created by Sam on 2016-05-27.
 */
public class Load implements Runnable {
    Context context;
    private String name;
    Button button;
    public Load(Button theButton, String theName){
        name="numbers.txt";
        button = theButton;
    }
    public void run(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream inputStream;
                try{
                    inputStream = context.openFileInput("numbers.txt");

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
