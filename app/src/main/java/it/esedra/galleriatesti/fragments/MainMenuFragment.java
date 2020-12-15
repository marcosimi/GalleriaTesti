package it.esedra.galleriatesti.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.esedra.galleriatesti.MainActivity;
import it.esedra.galleriatesti.R;

public class MainMenuFragment extends Fragment {

    private Context context;

    public MainMenuFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_menu_fragment, container, false);

        Button texts_button = view.findViewById(R.id.texts_button);
        Button images_button = view.findViewById(R.id.images_button);

        texts_button.setOnClickListener((v1) -> {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_fragment, new TextsFragment(context)).commit();
        });
        images_button.setOnClickListener((v2) -> {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.container_fragment, new ImagesFragment(context)).commit();
        });

        return view;
    }
}
