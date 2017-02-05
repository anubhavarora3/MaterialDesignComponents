package com.example.anubharora.materialdesigncomponents.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.anubharora.materialdesigncomponents.R;

/**
 * Created by anubharora on 2/4/17.
 */
public class AttachmentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Attachment Fragment", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.layout_attachment_fragment, container, false);
    }
}
