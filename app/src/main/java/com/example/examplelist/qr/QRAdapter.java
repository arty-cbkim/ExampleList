package com.example.examplelist.qr;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examplelist.R;
import com.example.examplelist.multiImagerecyclerview.ParentAdapter;

import java.util.ArrayList;

public class QRAdapter extends RecyclerView.Adapter<QRAdapter.ViewHolder> {

    ArrayList<QR> QRList = new ArrayList<>();

    public void setQRList(ArrayList<QR> QRList) {
        this.QRList = QRList;
    }

    @NonNull
    @Override
    public QRAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.qr_list_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QRAdapter.ViewHolder holder, int position) {
        QR qr = QRList.get(position);

        holder.qrcode.setImageBitmap(qr.getQRCode());
        holder.serial.setText(qr.getSerial());
    }

    @Override
    public int getItemCount() {
        return QRList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView   qrcode;
        TextView    serial;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            qrcode = itemView.findViewById(R.id.qrcode);
            serial = itemView.findViewById(R.id.tv_qr_serial);
        }
    }
}
