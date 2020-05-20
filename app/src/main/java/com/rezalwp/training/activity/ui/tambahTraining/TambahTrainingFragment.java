package com.rezalwp.training.activity.ui.tambahTraining;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rezalwp.training.R;
import com.rezalwp.training.model.ResponseErrorModel;

public class TambahTrainingFragment extends Fragment {

    private TambahTrainingViewModel tambahTrainingViewModel;
    private EditText edtKodeTraining;
    private EditText edtNamaTraining;
    private EditText edtTipeTraining;
    private EditText edtKuotaTraining;
    private EditText edtHargaTraining;
    private EditText edtGambarTraining;
    private Button btnTraining;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tambahTrainingViewModel =
                ViewModelProviders.of(this).get(TambahTrainingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tambah_training, container, false);

        edtKodeTraining = root.findViewById(R.id.edt_kode_training);
        edtNamaTraining = root.findViewById(R.id.edt_nama_training);
        edtTipeTraining = root.findViewById(R.id.edt_tipe_training);
        edtKuotaTraining = root.findViewById(R.id.edt_kuota_training);
        edtHargaTraining = root.findViewById(R.id.edt_harga_training);
        edtGambarTraining = root.findViewById(R.id.edt_gambar_training);
        btnTraining = root.findViewById(R.id.btn_training);

        btnTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahTrainingViewModel.postDataTrainings(
                        edtKodeTraining.getText().toString().trim(),
                        edtNamaTraining.getText().toString().trim(),
                        edtTipeTraining.getText().toString().trim(),
                        edtKuotaTraining.getText().toString().trim(),
                        edtHargaTraining.getText().toString().trim(),
                        "xx-xx-xx",
                        edtGambarTraining.getText().toString().trim()).observe(getActivity(), new Observer<ResponseErrorModel>() {
                    @Override
                    public void onChanged(ResponseErrorModel trainingResponse) {
                        Toast.makeText(getActivity(), "Sukses", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return root;
    }
}
