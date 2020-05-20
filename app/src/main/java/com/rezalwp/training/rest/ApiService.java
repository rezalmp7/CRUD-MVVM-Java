package com.rezalwp.training.rest;

import com.rezalwp.training.model.ResponseErrorModel;
import com.rezalwp.training.model.TrainingModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("akun/api_login.php")
    Call<ResponseErrorModel> login(@Query("nik_user") String nik_user,
                                   @Query("password") String password);
    @GET("training/api_get.php")
    Call<List<TrainingModel>> getStatusTraining(@Query("status_training") String
                                                  status_training);
    @FormUrlEncoded
    @POST("akun/api_register.php")
    Call<ResponseErrorModel> postRegisterAkun(@Field("nik_user") String nik_user,
                                              @Field("nama_user") String nama_user,
                                              @Field("password") String password);
    @FormUrlEncoded
    @POST("training/api_tambah_training.php")
    Call<ResponseErrorModel> postTambahTraining(@Field("kode_training") String
                                                        kode_training,
                                                @Field("nama_training") String
                                                        nama_training,
                                                @Field("type_training") String
                                                        type_training,
                                                @Field("jumlah_training") String
                                                        jumlah_training,
                                                @Field("harga_training") String
                                                        harga_training,
                                                @Field("tanggal_training") String
                                                        tanggal_training,
                                                @Field("gambar_training") String
                                                        gambar_training);
    @FormUrlEncoded
    @POST("training/api_update_training.php")
    Call<ResponseErrorModel> postUpdateTraining(@Field("id_training") String
                                                        id_training);
    @FormUrlEncoded
    @POST("training/api_hapus_training.php")
    Call<ResponseErrorModel> postDeleteTraining(@Field("id_training") String
                                                        id_training);
}
