package it.esedra.galleriatesti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;

import android.os.Bundle;

import java.io.FileOutputStream;
import java.io.IOException;

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

        //OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("allTexts.txt", MODE_PRIVATE), StandardCharsets.UTF_8);

        try(FileOutputStream fos = openFileOutput("allTexts.txt", Context.MODE_PRIVATE)) {
            String line1 = "Ciao" + "\n";
            String line2 = "Addio" + "\n";
            String line3 = "OK" + "\n";
            String line4 = "Prova" + "\n";
            String line5 = "Test";
            fos.write(line1.getBytes());
            fos.write(line2.getBytes());
            fos.write(line3.getBytes());
            fos.write(line4.getBytes());
            fos.write(line5.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}