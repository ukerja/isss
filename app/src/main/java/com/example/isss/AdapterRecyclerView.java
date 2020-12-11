package com.example.isss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isss.ui.home.HomeFragment;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>  {

    private String[] SubjectValues;
    private Context context;

    public AdapterRecyclerView(Context context1, String[] SubjectValues1) {

        SubjectValues = SubjectValues1;
        context = context1;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View v) {

            super(v);

            textView = v.findViewById(R.id.show);
        }
    }
    @NonNull

    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_laporan, parent, false);

        return new ViewHolder(view);
    }


    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(SubjectValues[position]);
    }


    public int getItemCount() {

        return SubjectValues.length;
    }
}
