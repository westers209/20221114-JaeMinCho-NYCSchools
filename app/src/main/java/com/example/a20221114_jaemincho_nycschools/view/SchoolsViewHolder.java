package com.example.a20221114_jaemincho_nycschools.view;

import androidx.recyclerview.widget.RecyclerView;

import com.example.a20221114_jaemincho_nycschools.databinding.ItemSchoolBinding;
import com.example.a20221114_jaemincho_nycschools.model.Schools;

public class SchoolsViewHolder extends RecyclerView.ViewHolder {

    private ItemSchoolBinding binding;

    public SchoolsViewHolder(ItemSchoolBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Schools dataItem) {
        binding.tvSchoolName.setText(dataItem.getSchoolName());
    }
}