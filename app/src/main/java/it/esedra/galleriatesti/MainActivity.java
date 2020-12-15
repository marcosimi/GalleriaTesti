package it.esedra.galleriatesti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import it.esedra.galleriatesti.fragments.MainMenuFragment;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.container_fragment, new MainMenuFragment(this)).commit();

        try(OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("allTexts.txt", MODE_PRIVATE), StandardCharsets.UTF_8)) {
            String line1 = "Ciao" + "\n";
            String line2 = "Addio" + "\n";
            String line3 = "OK" + "\n";
            String line4 = "Prova" + "\n";
            String line5 = "Test";
            osw.write(String.valueOf(line1.getBytes()));
            osw.write(String.valueOf(line2.getBytes()));
            osw.write(String.valueOf(line3.getBytes()));
            osw.write(String.valueOf(line4.getBytes()));
            osw.write(String.valueOf(line5.getBytes()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}