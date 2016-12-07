package com.czy.magicline.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.chenzy.magicline.MagicLineView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangyu on 2016/9/7.
 */
public class MagicLineAct extends Activity implements View.OnClickListener {


    @BindView(R.id.magic_line)
    MagicLineView magicLineView;
    @BindView(R.id.p1x_length)
    EditText p1xLength;
    @BindView(R.id.p1y_length)
    EditText p1yLength;
    @BindView(R.id.p2x_length)
    EditText p2xLength;
    @BindView(R.id.p2y_length)
    EditText p2yLength;
    @BindView(R.id.p1_speed)
    EditText p1Speed;
    @BindView(R.id.p2_speed)
    EditText p2Speed;
    @BindView(R.id.start)
    Button startBtn;
    @BindView(R.id.selete_draw_spinner)
    Spinner seleteDraw;

    private boolean firstIn = true;

    private float[] data1 = {400, 400, 200, 200, 0.05f, 0.35f};
    private float[] data2 = {200, 500, 500, 200, 0.4f, 0.4f};
    private float[] data3 = {450, 450, 450, 450, 0.35f, 0.05f};
    private float[] data4 = {450, 150, 150, 450, 0.1f, 0.05f};
    private float[] data5 = {450, 450, 450, 450, 0.5f, 0.15f};
    private float[] data6 = {90, 90, 450, 450, 0.5f, 0.15f};
    private float[] data7 = {200, 200, 450, 450, 0.55f, 0.15f};
    private float[] data8 = {450, 150, 150, 450, 0.15f, 0.05f};
    private float[] data9 = {450, 450, 150, 150, 1f, 0.15f};

    private List<String> spinnerMenu;
    private List<float[]> drawMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_line);
        ButterKnife.bind(this);
        initResources();
        initView();

    }

    private void initResources() {
        spinnerMenu = new ArrayList<>();
        spinnerMenu.add("一号图案");
        spinnerMenu.add("二号图案");
        spinnerMenu.add("三号图案");
        spinnerMenu.add("四号图案");
        spinnerMenu.add("五号图案");
        spinnerMenu.add("六号图案");
        spinnerMenu.add("七号图案");
        spinnerMenu.add("八号图案");
        spinnerMenu.add("九号图案");

        drawMenu = new ArrayList<>();
        drawMenu.add(data1);
        drawMenu.add(data2);
        drawMenu.add(data3);
        drawMenu.add(data4);
        drawMenu.add(data5);
        drawMenu.add(data6);
        drawMenu.add(data7);
        drawMenu.add(data8);
        drawMenu.add(data9);
    }

    private void initView() {
        startBtn.setOnClickListener(this);
        SpinnerAdapter adapter = new ArrayAdapter(this, R.layout.adapter_spinner, spinnerMenu);
        seleteDraw.setAdapter(adapter);
        seleteDraw.setSelection(7);
        seleteDraw.setOnItemSelectedListener(itemSelectedListener);
        magicLineView.setDrawingListener(drawingListener);

    }

    private AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.d("MagicLineAct", "onItemSelected");
            if (parent.getId() == R.id.selete_draw_spinner) {
                if (position < 0 || position >= drawMenu.size())
                    return;

                if (firstIn) {
                    firstIn = false;
                } else {
                    float[] data = drawMenu.get(position);
                    p1xLength.setText(data[0] + "");
                    p1yLength.setText(data[1] + "");
                    p2xLength.setText(data[2] + "");
                    p2yLength.setText(data[3] + "");
                    p1Speed.setText(data[4] + "");
                    p2Speed.setText(data[5] + "");
                    magicLineView.setParam(data[0], data[1], data[2], data[3], data[4], data[5]);
                    magicLineView.startDraw();
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Log.d("MagicLineAct", "onNothingSelected");
        }
    };

    private MagicLineView.DrawingListener drawingListener = new MagicLineView.DrawingListener() {
        @Override
        public void drawStart() {
            seleteDraw.setClickable(false);
            startBtn.setTextColor(Color.GRAY);
            startBtn.setClickable(false);
        }

        @Override
        public void drawOver() {
            startBtn.setTextColor(Color.BLACK);
            startBtn.setClickable(true);
            seleteDraw.setClickable(true);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                float p1xLen = Float.valueOf(p1xLength.getText().toString());
                float p1yLen = Float.valueOf(p1yLength.getText().toString());
                float p2xLen = Float.valueOf(p2xLength.getText().toString());
                float p2yLen = Float.valueOf(p2yLength.getText().toString());
                float p1speed = Float.valueOf(p1Speed.getText().toString());
                float p2speed = Float.valueOf(p2Speed.getText().toString());
                magicLineView.setParam(p1xLen, p1yLen, p2xLen, p2yLen, p1speed, p2speed);
                magicLineView.startDraw();
                break;
        }

    }
}
