package it.esedra.galleriatesti.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.esedra.galleriatesti.MainActivity;
import it.esedra.galleriatesti.R;

public class ImagesFragment extends Fragment {

    private Context context;
    private int flag = 0;

    public ImagesFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.images_fragment, container, false);
        ImageView images_view = view.findViewById(R.id.images_view);
        Button back_button2 = view.findViewById(R.id.back_button2);

        images_view.setImageResource(R.drawable.franchino);

        images_view.setOnClickListener((v1) -> {
            if(flag == 0) {
                images_view.animate().alpha(0).setDuration(200).start();
                flag = 1;
            } else {
                if(flag == 1) {
                    images_view.animate().alpha(1).setDuration(200).start();
                    flag = 0;
                }
            }
        });

        back_button2.setOnClickListener((v2) -> {
            MainActivity.fragmentManager.beginTransaction().replace(R.id.container_fragment, new MainMenuFragment(context)).commit();
        });

        return view;
    }
}
