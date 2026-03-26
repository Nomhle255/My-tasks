package com.example.mytasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class ImageViewFragment extends Fragment {

    private static final String ARG_IMAGE_RES = "image_res";

    public static ImageViewFragment newInstance(int imageResId) {
        ImageViewFragment fragment = new ImageViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RES, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_view, container, false);

        ImageView imageView = view.findViewById(R.id.fullImageView);

        if (getArguments() != null) {
            int resId = getArguments().getInt(ARG_IMAGE_RES);
            imageView.setImageResource(resId);
        }

        // Tap anywhere to go back
        imageView.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack()
        );

        return view;
    }
}