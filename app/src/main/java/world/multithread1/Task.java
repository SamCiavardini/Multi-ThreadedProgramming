package world.multithread1;


import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import java.util.List;

/**
 * Created by Sam on 2016-05-28.
 */
public class Task extends AsyncTask<File, String, Integer> {


    protected void onPreExecute() {

        MainActivity.progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    protected void onProgressUpdate(Integer... values) {
        MainActivity.progressBar.setProgress(values[0]);
    }

    protected Integer doInBackground(File... file){
        try {
            FileOutputStream fos = new FileOutputStream(file[0]);
            for(int i = 1; i <= 10; i++) {
                fos.write((String.valueOf(i) + "\n").getBytes());
                Thread.sleep(250);
                publishProgress();
            }
            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    protected List doInBackground( FileInputStream fin, List...list){
        try{
            InputStreamReader isr = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(isr);
            String readString;
            while ((readString = br.readLine()) != null){
                list[0].add(readString);
                Thread.sleep(250);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list[0];
    }
}
