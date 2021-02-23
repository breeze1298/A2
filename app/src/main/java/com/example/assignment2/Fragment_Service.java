package com.example.assignment2;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragment_Service extends Fragment {

    Button b1,b2;
    private Intent serviceIntent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        serviceIntent=new Intent(getContext(),MyService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_service, container, false);

        b1=view.findViewById(R.id.start);
        b2=view.findViewById(R.id.stop);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(serviceIntent);
                Toast.makeText(getActivity(), "Service Started", Toast.LENGTH_SHORT).show();
            }
        });b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Service Stopped ", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

}