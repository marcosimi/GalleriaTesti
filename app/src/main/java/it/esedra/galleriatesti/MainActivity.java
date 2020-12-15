package it.esedra.galleriatesti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

import it.esedra.galleriatesti.fragments.MainMenuFragment;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.container_fragment, new MainMenuFragment(this)).commit();

        try(FileOutputStream fos = context.openFileOutput("allTexts.txt", Context.MODE_APPEND)) {
            String line1 = "Ciao" + "\n";
            String line2 = "Addio" + "\n";
            String line3 = "OK" + "\n";
            String line4 = "Prova" + "\n";
            String line5 = "Test" + "\n";
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