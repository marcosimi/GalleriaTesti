package it.esedra.galleriatesti.fragments;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Scanner;

import it.esedra.galleriatesti.MainActivity;
import it.esedra.galleriatesti.R;

public class TextsFragment extends Fragment {

    private Context context;

    private FileInputStream fis;
    private InputStreamReader isr;
    private StringBuilder builder;
    private String line;
    private ArrayDeque<String> lines = new ArrayDeque<>();

    public TextsFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.texts_fragment, container, false);
        TextView texts_view = view.findViewById(R.id.texts_view);
        Button change_button = view.findViewById(R.id.change_button);
        Button back_button = view.findViewById(R.id.back_button);

        try {
            fis = context.openFileInput("allTexts.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(isr)) {
            //line = reader.readLine();
            while((line = reader.readLine()) != null) {
                lines.addLast(line);
                //line = reader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }


        change_button.setOnClickListener((v1) -> {

            String text = lines.poll();
            texts_view.setText(text);
            lines.addLast(text);

            /*try(BufferedReader reader = new BufferedReader(isr)) {

                line = reader.readLine();
                while (line != null) {
                    builder.append(line).append("\n");
                    texts_view.setText(builder.toString());
                    line = reader.readLine();
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }

             */
        });

        back_button.setOnClickListener((v2) -> {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_fragment, new MainMenuFragment(context)).commit();
        });

        return view;
    }
}
