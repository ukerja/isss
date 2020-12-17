package com.example.isss.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.isss.Login;
import com.example.isss.R;
import com.example.isss.SharedPrefmanager;
import com.example.isss.Start;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class HomeFragment extends Fragment {
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private HomeViewModel homeViewModel;
    Button btn_map, btn_incident, btn_multimedia, btn_test,btn_logout, btn_start;
    private static SharedPrefmanager mInstance;
    private static Context mCtx;

    private void SharedPrefmanager(Context context) {
        mCtx = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        btn_start = (Button) root.findViewById(R.id.btn_start);



        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Start.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
////calling the logout method
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().finish();
//                SharedPrefmanager.getInstance(getApplicationContext()).logout();
//            }
//        });


        return root;
    }

}