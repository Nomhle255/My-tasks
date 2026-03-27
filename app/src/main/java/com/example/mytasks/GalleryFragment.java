package com.example.mytasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class GalleryFragment extends Fragment {

    public static final int[] IMAGES = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ImageView selectedImageView = view.findViewById(R.id.selectedImageView);
        Gallery gallery = view.findViewById(R.id.simpleGallery);

        // Show first image by default
        selectedImageView.setImageResource(IMAGES[0]);

        // Set the custom adapter
        GalleryAdapter adapter = new GalleryAdapter(getActivity(), IMAGES);
        gallery.setAdapter(adapter);

        // When a thumbnail is clicked, show it in the large ImageView
        gallery.setOnItemClickListener((parent, v, position, id) ->
                selectedImageView.setImageResource(IMAGES[position])
        );

        return view;
    }
}