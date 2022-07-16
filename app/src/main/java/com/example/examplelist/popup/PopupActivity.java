package com.example.examplelist.popup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.examplelist.R;

public class PopupActivity extends AppCompatActivity {

    Button btnPopup;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        btnPopup = findViewById(R.id.btn_popup);
        btnPopup.setOnClickListener(view -> {
            dialog(this);
        });
    }

    public void dialog(Context context) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(context, R.style.AlertDialogTheme);

        LayoutInflater layoutInflater
                = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dialog_popup, null);

        builder.setView(view);

        // TextView title      = view.findViewById(R.id.tv_dialog_title);
        // TextView message    = view.findViewById(R.id.tv_dialog_message);
        Button btn1    = view.findViewById(R.id.btn_dialog_1);
        Button btn2    = view.findViewById(R.id.btn_dialog_2);

        {
            btn1.setText("btn1");
            btn2.setText("btn2");
        }

        AlertDialog alertDialog = builder.create();

        Intent intent = new Intent(this, SubActivity.class);

        btn1.setOnClickListener(v -> {
            Log.d("버튼","1번 클릭");
            intent.putExtra("no", 1);
            startActivity(intent);
            alertDialog.dismiss();
        });

        btn2.setOnClickListener(v -> {
            Log.d("버튼","2번 클릭");
            intent.putExtra("no", 2);
            startActivity(intent);
            alertDialog.dismiss();
        });

        if(alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        WindowManager.LayoutParams layoutParams = alertDialog.getWindow().getAttributes();

        layoutParams.gravity = Gravity.RIGHT;
        layoutParams.verticalMargin = 0.12f;
        layoutParams.horizontalMargin = 1f;
        alertDialog.show();
    }
}