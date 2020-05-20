package com.rezalwp.training.activity.ui.training;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rezalwp.training.R;
import com.rezalwp.training.adapter.TrainingAdapter;
import com.rezalwp.training.model.TrainingModel;

import java.util.ArrayList;
import java.util.List;

public class TrainingFragment extends Fragment {
    private String TAG = "mvvm";
    private RecyclerView rv;

    private TrainingAdapter trainingAdapter;
    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_training, container, false);
        final List<TrainingModel> trainingModels = new ArrayList<>();
        rv = root.findViewById(R.id.rv);
        rv.setAdapter(trainingAdapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TrainingViewModel trainingViewModel =
                ViewModelProviders.of(this).get(TrainingViewModel.class);
        trainingViewModel.getStatusTraining().observe(this, new Observer<List<TrainingModel>>() {
            @Override
            public void onChanged(List<TrainingModel> trainingModels) {
                trainingAdapter = new TrainingAdapter(getActivity(), trainingModels);
                rv.setAdapter(trainingAdapter);
            }
        });
        return root;
    }
}
