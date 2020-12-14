package com.example.isss.ui.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isss.AdapterRecyclerView;
import com.example.isss.R;
import com.example.isss.Start;
import com.example.isss.Start_Admin;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class AdminFragment extends Fragment {

    private AdminViewModel adminViewModel;
    Button btn_map, btn_incident, btn_multimedia, btn_test, btn_start;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        adminViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AdminViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_admin, container, false);

        btn_start = (Button) root.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Start_Admin.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return root;
    }
}