package com.example.examplelist.chart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.examplelist.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    private Button btnTemp, btnHum, btnCds;

    private LineChart lineChart;
    private ArrayList<SensorData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        btnTemp = findViewById(R.id.btn_temp);
        btnHum  = findViewById(R.id.btn_hum);
        btnCds  = findViewById(R.id.btn_cds);

        setEvent();

        lineChart = findViewById(R.id.line_chart);

        // 임시 데이터 생성
        setData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawingChart(1);
    }

    private void setEvent() {
        btnTemp.setOnClickListener(view -> {
            drawingChart(1);
        });
        btnHum.setOnClickListener(view -> {
            drawingChart(2);
        });
        btnCds.setOnClickListener(view -> {
            drawingChart(3);
        });
    }

    private void drawingChart(int position) {
        ArrayList<Entry> entries = new ArrayList<>(); // 값 - 인덱스 넣어주면 순차적으로 그려줘, y축이름(데이터값)
        ArrayList<String> xVals = new ArrayList<>(); // X 축 이름 값

        entries.clear();
        xVals.clear();

        int i = 0;
        for ( SensorData sensor : arrayList ) {
            // Log.d("Chart", "센서값 -> " + sensor);

            switch (position) {
                case 1:
                    entries.add( new Entry( i++, Float.parseFloat(sensor.getTemp()) ) );
                    break;
                case 2:
                    entries.add( new Entry( i++, Float.parseFloat(sensor.getHum()) ) );
                    break;
                case 3:
                    entries.add( new Entry( i++, Float.parseFloat(sensor.getCds()) ) );
                    break;
            }

            xVals.add(sensor.getTime());
        }
        String title = null;
        switch (position) {
            case 1:
                title = "온도";
                break;
            case 2:
                title = "습도";
                break;
            case 3:
                title = "조도";
                break;
        }

        LineDataSet lineDataSet = new LineDataSet(entries, title);
        lineDataSet.setLineWidth(3);
        lineDataSet.setCircleRadius(3); // 점 크기
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setCircleColor(Color.rgb(255,0,0)); // 점 색깔
        lineDataSet.setColor(Color.rgb(0,255,0));
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lineDataSet);
        LineData lineData = new LineData(dataSets);
        lineData.setValueTextSize(15); //no working
        lineChart.setData(lineData);

        lineChart.setVisibleXRangeMaximum(5); //가로 스크롤 생김 + 스크롤 넘어가기전 표출되는 데이터 값

        lineChart.setScaleEnabled(false);
        lineChart.setPinchZoom(false); //zoom 기능
        lineChart.moveViewToX(1);
        lineChart.setScrollContainer(true);;

        XAxis xAxis = lineChart.getXAxis(); //x축 설정
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x축 데이터 표시 위치
        xAxis.setLabelCount(12); //x축의 데이터를 최대 몇 개 까지 나타낼지에 대한 설정
        xAxis.setTextColor(Color.rgb(118, 118, 118));
        xAxis.setSpaceMax(1f); // 오른쪽으로 얼마나 남았는가
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
        xAxis.enableGridDashedLine(10, 24, 0); //수직 격자선
        xAxis.setGranularity(1f);

        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setTextColor(Color.rgb(163, 163, 163));

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(true);

        lineChart.invalidate();
    }

    private void setData() {
        arrayList = new ArrayList<>();

        SensorData data = new SensorData();
        data.setTime("16");
        data.setTemp("20.5");
        data.setHum("70");
        data.setCds("2500");
        arrayList.add(data);

        SensorData data2 = new SensorData();
        data2.setTime("17");
        data2.setTemp("22");
        data2.setHum("72");
        data2.setCds("4000");
        arrayList.add(data2);

        SensorData data3 = new SensorData();
        data3.setTime("18");
        data3.setTemp("21.5");
        data3.setHum("65");
        data3.setCds("5500");
        arrayList.add(data3);

        SensorData data4 = new SensorData();
        data4.setTime("19");
        data4.setTemp("23.5");
        data4.setHum("60");
        data4.setCds("7000");
        arrayList.add(data4);

        SensorData data5 = new SensorData();
        data5.setTime("20");
        data5.setTemp("22");
        data5.setHum("70");
        data5.setCds("6000");
        arrayList.add(data5);

        // Log.e("Chart", arrayList.toString());
    }
}