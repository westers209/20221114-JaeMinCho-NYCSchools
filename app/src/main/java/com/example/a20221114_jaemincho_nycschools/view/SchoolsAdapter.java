package com.example.a20221114_jaemincho_nycschools.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a20221114_jaemincho_nycschools.databinding.ItemSchoolBinding;
import com.example.a20221114_jaemincho_nycschools.model.SchoolClickListener;
import com.example.a20221114_jaemincho_nycschools.model.Schools;

import java.util.List;

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsViewHolder> {

    private List<Schools> schoolsList;
    private SchoolClickListener schoolClickListener;

    public SchoolsAdapter(List<Schools> dataSet, SchoolClickListener listener) {
        this.schoolsList = dataSet;
        this.schoolClickListener = listener;
    }

    @NonNull
    @Override
    public SchoolsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolsViewHolder(
                ItemSchoolBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolsViewHolder holder, int position) {
        holder.bind(schoolsList.get(position));
        holder.itemView.setOnClickListener(view -> {
            schoolClickListener.onCellClickListener(schoolsList.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return schoolsList.size();
    }
}

