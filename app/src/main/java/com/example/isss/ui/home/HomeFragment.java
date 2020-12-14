package com.example.isss.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isss.R;
import com.example.isss.Start;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button btn_map, btn_incident, btn_multimedia, btn_test, btn_start;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        btn_start = (Button) root.findViewById(R.id.btn_start);
//        btn_map = (Button) root.findViewById(R.id.btn_map);
//        btn_incident = (Button) root.findViewById(R.id.btn_incident);
//        btn_multimedia = (Button) root.findViewById(R.id.btn_multimedia);
//        btn_test = (Button) root.findViewById(R.id.btn_test);

//        btn_start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                boolean checked = btn_start.isChecked();
//
//                if (checked) {
//
//                    btn_scan.setVisibility(View.VISIBLE);
//                    btn_incident.setVisibility(View.VISIBLE);
//                    btn_multimedia.setVisibility(View.VISIBLE);
//                    btn_test.setVisibility(View.VISIBLE);
//
//                } else {
//
//                    btn_scan.setVisibility(View.INVISIBLE);
//                    btn_incident.setVisibility(View.INVISIBLE);
//                    btn_multimedia.setVisibility(View.INVISIBLE);
//                    btn_test.setVisibility(View.INVISIBLE);
//                }
//
//            }
//        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Start.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

//        btn_map.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Map.class);
//                startActivity(intent);
//            }
//
//        });
//        btn_incident.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Incident.class);
//                startActivity(intent);
//            }
//
//        });
//
//        btn_multimedia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Multimedia.class);
//                startActivity(intent);
//            }
//
//        });
//
//        btn_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Test.class);
//                startActivity(intent);
//            }
//
//        });
        return root;
    }

}