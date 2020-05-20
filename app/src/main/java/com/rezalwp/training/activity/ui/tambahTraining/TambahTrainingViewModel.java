package com.rezalwp.training.activity.ui.tambahTraining;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rezalwp.training.model.ResponseErrorModel;
import com.rezalwp.training.rest.ApiConfig;
import com.rezalwp.training.rest.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahTrainingViewModel extends ViewModel {
    private String TAG = "retrofit";
    private MutableLiveData<ResponseErrorModel> responseErrorModelMutableLiveData;

    public LiveData<ResponseErrorModel> postDataTrainings(String kode_training, String
            nama_training, String type_training, String kuota_training, String harga_training,
                                                          String tanggal_training, String gambar_training) {
        if (responseErrorModelMutableLiveData == null) {
            responseErrorModelMutableLiveData = new MutableLiveData<>();
            postDataTraining(kode_training, nama_training, type_training,
                    kuota_training, harga_training, tanggal_training, gambar_training);
        }
        return responseErrorModelMutableLiveData;
    }

    private void postDataTraining(String kode_training, String nama_training, String
            type_training, String kuota_training, String harga_training, String
                                          tanggal_training, String gambar_training) {
        ApiService apiService = ApiConfig.getApiService();
        apiService.postTambahTraining(kode_training,
                nama_training,
                type_training,
                kuota_training,
                harga_training,
                tanggal_training,
                gambar_training)
                .enqueue(new Callback<ResponseErrorModel>() {
                    @Override
                    public void onResponse(Call<ResponseErrorModel> call, Response<ResponseErrorModel> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: SUKSES > " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }
}