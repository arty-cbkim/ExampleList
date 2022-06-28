package com.example.examplelist.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.examplelist.R;
import com.example.examplelist.multiImagerecyclerview.MultiImageRecyclerActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;

public class CreateQRActivity extends AppCompatActivity {

    ArrayList<QR> QRList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_qr);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_qr);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        QRAdapter adapter = new QRAdapter();
        recyclerView.setAdapter(adapter);

        createQR();

        adapter.setQRList(QRList);
        adapter.notifyDataSetChanged();
    }

    private void createQR() {
        int serial = 22060001;
        for(int i = 0; i< 10; i++) {
            StringBuffer sb = new StringBuffer();

            Log.d("serial", " -----> " + serial);

            sb.append("{");
            sb.append("\'MODEL_NAME\' : \'한글_ENGLISH\'").append(",");
            sb.append("\'MODEL\' : \'AT0001\'").append(",");
            sb.append("\'AP_ID\' : \'PLPL_IOT\'").append(",");
            sb.append("\'AP_PSWD\' : \'12345678\'").append(",");
            sb.append("\'SERIAL\' : \'").append(serial).append("\'");
            sb.append("}");

            Log.d("QR " + (i+1) + ")", sb.toString());

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try{
                BitMatrix bitMatrix = multiFormatWriter.encode(
                        sb.toString()
                        , BarcodeFormat.QR_CODE
                        ,200
                        ,200
                );

                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                QR qr = new QR();
                qr.setSerial(String.valueOf(serial));
                qr.setQRCode(bitmap);

                QRList.add(qr);

                serial++;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}