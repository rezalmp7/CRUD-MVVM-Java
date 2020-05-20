package com.rezalwp.training.model;

import com.google.gson.annotations.SerializedName;

public class TrainingModel {

    @SerializedName("id_training")
    private String id_training;

    @SerializedName("kode_training")
    private String kode_training;

    @SerializedName("nama_training")
    private String nama_training;

    @SerializedName("type_training")
    private String type_training;

    @SerializedName("jumlah_training")
    private String jumlah_training;

    @SerializedName("harga_training")
    private String harga_training;

    @SerializedName("tanggal_training")
    private String tanggal_training;

    @SerializedName("gambar_training")
    private String gambar_training;

    @SerializedName("status_training")
    private String status_training;

    public String getStatusTraining() { return status_training;
    }

    public void setStatus_training(String status_training) {
        this.status_training = status_training;
    }

    public String getNamaTraining() { return nama_training;
    }

    public void setNama_training(String nama_training) {
        this.nama_training = nama_training;
    }

    public String getTypeTraining() { return type_training;
    }

    public void setType_training(String type_training) {
        this.type_training = type_training;
    }

    public String getJumlahTraining() { return jumlah_training;
    }

    public void setJumlah_training(String jumlah_training) {
        this.jumlah_training = jumlah_training;
    }

    public String getHargaTraining() { return harga_training;
    }

    public void setHarga_training(String harga_training) {
        this.harga_training = harga_training;
    }

    public String getTanggalTraining() { return tanggal_training;
    }

    public void setTanggal_training(String tanggal_training) {
        this.tanggal_training = tanggal_training;
    }

    public String getGambarTraining() { return gambar_training;
    }

    public void setGambar_training(String gambar_training) {
        this.gambar_training = gambar_training;
    }

    public String getIdTraining() { return id_training;
    }

    public void setId_training(String id_training) {
        this.id_training = id_training;
    }
}
