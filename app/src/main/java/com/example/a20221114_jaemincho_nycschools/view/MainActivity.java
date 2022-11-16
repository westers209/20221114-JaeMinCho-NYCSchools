package com.example.a20221114_jaemincho_nycschools.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.a20221114_jaemincho_nycschools.databinding.ActivityMainBinding;
import com.example.a20221114_jaemincho_nycschools.model.SchoolClickListener;
import com.example.a20221114_jaemincho_nycschools.model.Schools;
import com.example.a20221114_jaemincho_nycschools.model.presentation.Error;
import com.example.a20221114_jaemincho_nycschools.model.presentation.Loading;
import com.example.a20221114_jaemincho_nycschools.model.presentation.PresentationData;
import com.example.a20221114_jaemincho_nycschools.model.presentation.Success;
import com.example.a20221114_jaemincho_nycschools.viewmodel.SchoolsViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements SchoolClickListener {

    private ActivityMainBinding binding;
    @Inject
    ViewModelProvider.Factory provider;
    private SchoolsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = provider.create(SchoolsViewModel.class);
        setContentView(binding.getRoot());
        initViews();
        initObservables();
    }

    private void initObservables() {
        viewModel.data.observe(this,
                this::updateData);
    }

    private void updateData(PresentationData presentationData) {
        if (presentationData instanceof Error<?>) {
            showError(((Error<String>) presentationData).getErrorMessage());
        } else if (presentationData instanceof Loading) {
            showLoading(((Loading<?>) presentationData).getLoading());
        } else
            updateAdapter(((Success<List<Schools>>) presentationData).getDataSet());
    }

    private void updateAdapter(List<Schools> dataSet) {
        binding.rvSchoolsList.setVisibility(View.VISIBLE);
        binding.rvSchoolsList.setAdapter(new SchoolsAdapter(dataSet, this));
    }

    private void showLoading(Boolean loading) {
        if (loading)
            binding.rvSchoolsList.setVisibility(View.GONE);
        else
            binding.rvSchoolsList.setVisibility(View.VISIBLE);
    }

    private void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        binding.rvSchoolsList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onCellClickListener(Schools data) {
        Toast.makeText(this,
                "Number of Test Takers: " +
                        data.getNumOfSatTestTakers() + ", Reading Average: " +
                        data.getSatCriticalThinkingReadingAvgScore() + "\nMath Average: " +
                        data.getSatMathAvgScore() + ", Writing Average: " +
                        data.getSatWritingAvgScore(),
                Toast.LENGTH_LONG).show();
    }
}