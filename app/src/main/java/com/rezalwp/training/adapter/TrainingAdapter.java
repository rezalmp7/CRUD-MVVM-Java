package com.rezalwp.training.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rezalwp.training.R;
import com.rezalwp.training.activity.HomeActivity;
import com.rezalwp.training.activity.ui.training.DetailTrainingActivity;
import com.rezalwp.training.helper.Config;
import com.rezalwp.training.model.ResponseErrorModel;
import com.rezalwp.training.model.TrainingModel;
import com.rezalwp.training.rest.ApiConfig;
import com.rezalwp.training.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {
    private Context context;
    private List<TrainingModel> trainingModels;

    public TrainingAdapter(Context context, List<TrainingModel> trainingModels) {
        this.context = context;
        this.trainingModels = trainingModels;
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_training, parent, false);
        return new TrainingViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, final int position) {
        if (trainingModels.get(position).getStatusTraining().contains("pending")){
            holder.tvNamaTrainingItem.setBackgroundColor(R.color.colorAccent);
            holder.containerAkftifkan.setVisibility(View.VISIBLE);
        }
        holder.tvNamaTrainingItem.setText(trainingModels.get(position).getNamaTraining());
        holder.tvTipeTrainingItem.setText(trainingModels.get(position).getTypeTraining());
        holder.tvKuotaTrainingItem.setText(trainingModels.get(position).getJumlahTraining()
        );
        holder.tvHargaTrainingItem.setText(trainingModels.get(position).getHargaTraining())
        ;
        holder.tvTanggalTrainingItem.setText(trainingModels.get(position).getTanggalTraining());
        holder.tvStatusTrainingItem.setText(trainingModels.get(position).getStatusTraining(
        ));
        Glide.with(context).load(trainingModels.get(position).getGambarTraining()).error(R.
                drawable.ic_menu_gallery).into(holder.ivImageTrainingItem);

        holder.btnAktifkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = ApiConfig.getApiService();
                apiService.postUpdateTraining(trainingModels.get(position).getIdTraining())
                        .enqueue(new Callback<ResponseErrorModel>() {
                            @Override
                            public void onResponse(Call<ResponseErrorModel> call,
                                                   Response<ResponseErrorModel> response) {
                                if (response.isSuccessful()){
                                    Toast.makeText(context, "Sukses", Toast.LENGTH_SHORT).show();
                                    ((HomeActivity)context).setup();// sek durung iso
                                }
                            }
                            @Override
                            public void onFailure(Call<ResponseErrorModel> call, Throwable t) {
                                Toast.makeText(context, "" + t.getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        holder.cvItemTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTrainingActivity.class);
                intent.putExtra(Config.BUNDLE_ID,
                        trainingModels.get(position).getIdTraining());
                intent.putExtra(Config.BUNDLE_NAMA,
                        trainingModels.get(position).getNamaTraining());
                intent.putExtra(Config.BUNDLE_TIPE,
                        trainingModels.get(position).getTypeTraining());
                intent.putExtra(Config.BUNDLE_KUOTA,
                        trainingModels.get(position).getJumlahTraining());
                intent.putExtra(Config.BUNDLE_HARGA,
                        trainingModels.get(position).getHargaTraining());
                intent.putExtra(Config.BUNDLE_TANGGAL,
                        trainingModels.get(position).getTanggalTraining());
                intent.putExtra(Config.BUNDLE_STATUS,
                        trainingModels.get(position).getStatusTraining());
                intent.putExtra(Config.BUNDLE_IMAGE,
                        trainingModels.get(position).getGambarTraining());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainingModels.size();
    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamaTrainingItem;
        private TextView tvTipeTrainingItem;
        private TextView tvKuotaTrainingItem;
        private TextView tvHargaTrainingItem;
        private TextView tvTanggalTrainingItem;
        private TextView tvStatusTrainingItem;

        private ImageView ivImageTrainingItem;

        private LinearLayout containerAkftifkan;
        private Button btnAktifkan;
        private CardView cvItemTraining;

        public TrainingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaTrainingItem = itemView.findViewById(R.id.tv_nama_training_item);
            tvTipeTrainingItem = itemView.findViewById(R.id.tv_tipe_training_item);
            tvKuotaTrainingItem =
                    itemView.findViewById(R.id.tv_kuota_training_item);
            tvHargaTrainingItem =
                    itemView.findViewById(R.id.tv_harga_training_item);
            tvTanggalTrainingItem =
                    itemView.findViewById(R.id.tv_tanggal_training_item);
            tvStatusTrainingItem =
                    itemView.findViewById(R.id.tv_status_training_item);
            ivImageTrainingItem =
                    itemView.findViewById(R.id.iv_image_training_item);

            containerAkftifkan = itemView.findViewById(R.id.container_aktifkan);
            btnAktifkan = itemView.findViewById(R.id.btn_aktifkan_training_item);
            cvItemTraining = itemView.findViewById(R.id.cv_training_item);
        }
    }
}
