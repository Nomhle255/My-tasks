package com.example.mytasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;

public class GalleryFragment extends Fragment {

    // Add your drawable resource IDs here
    public static final int[] IMAGES = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        GridView gridView = view.findViewById(R.id.gridViewGallery);
        GalleryAdapter adapter = new GalleryAdapter(getActivity(), IMAGES);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, v, position, id) -> {
            ImageViewFragment imageViewFragment = ImageViewFragment.newInstance(IMAGES[position]);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, imageViewFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}