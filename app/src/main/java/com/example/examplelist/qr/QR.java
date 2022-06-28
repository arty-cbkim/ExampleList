package com.example.examplelist.qr;

import android.graphics.Bitmap;

public class QR {
    private String serial;
    private Bitmap QRCode;

    @Override
    public String toString() {
        return "QR{" +
                "serial='" + serial + '\'' +
                ", QRCode=" + QRCode +
                '}';
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Bitmap getQRCode() {
        return QRCode;
    }

    public void setQRCode(Bitmap QRCode) {
        this.QRCode = QRCode;
    }
}
