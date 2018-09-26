package zqx.rj.com.mpandroidchartdemo.charts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

import zqx.rj.com.mpandroidchartdemo.R;

public class BarChartActivity extends AppCompatActivity {

    private BarChart mBarChart;
    private BarData mBarData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        initView();
        initData();
        initBarChart();
    }

    private void initView() {
        mBarChart = findViewById(R.id.bar_chart);
    }

    // 堆叠条形图
//    private void initData() {
//
//        // y 数据
//        ArrayList<BarEntry> yValues = new ArrayList<>();
//
//        for (int x = 0; x < 30; x++) {
//            float y = (float) (Math.random() * 30) + 10;
//            float y2 = (float) (Math.random() * 30) + 10;
//            // 同一个x  不同 y 值。
//            yValues.add(new BarEntry(x, new float[]{y, y2}));
//        }
//
//        // y 轴数据集
//        BarDataSet barDataSet = new BarDataSet(yValues, "我是Label");
//        // 设置 对应数据 颜色
//        barDataSet.setColors(Color.RED, Color.GREEN);
//
//        mBarData = new BarData(barDataSet);
//    }


    private void initData(){

        // y 数据
        ArrayList<BarEntry> yValues = new ArrayList<>();
        // y2 数据
        ArrayList<BarEntry> yValues2 = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            float y = (float) (Math.random() * 30) + 10;
            yValues.add(new BarEntry(x, y));

            float y2 = (float) (Math.random() * 30) + 10;
            yValues2.add(new BarEntry(x, y2));
        }

        // y 轴数据集
        BarDataSet barDataSet = new BarDataSet(yValues, "我是红色");
        barDataSet.setColor(Color.YELLOW);

        // y2 轴数据集
        BarDataSet barDataSet2 = new BarDataSet(yValues2, "我是绿色");
        barDataSet2.setColor(Color.GREEN);

        mBarData = new BarData(barDataSet, barDataSet2);
    }





    private void initBarChart() {
        mBarChart.setData(mBarData);
        float barWidth = 0.45f;
        // 设置 柱子宽度
        mBarData.setBarWidth(barWidth);

        // 分组条形图 需要设置
        float groupSpace = 0.06f;
        float barSpace = 0.02f;
        mBarChart.groupBars(0.0f, groupSpace, barSpace);


        // 设置 条形图 简介
        Description description = new Description();
        // 可以自定义 位置
//        description.setPosition(200, 200);
        // 也可以 根据 X 轴，Y 轴进行偏移量设置
        description.setXOffset(50f);
        description.setYOffset(10f);
        description.setText("我是 description");
        mBarChart.setDescription(description);
        // 设置 是否可以缩放
        mBarChart.setScaleEnabled(false);

        // 设置 柱子的宽度
        // mBarData.setBarWidth(2f);

        // 获取 x 轴
        XAxis xAxis = mBarChart.getXAxis();
        // 设置 x 轴显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 取消 垂直 网格线
        xAxis.setDrawGridLines(false);
        // 设置 x 轴 坐标旋转角度
        xAxis.setLabelRotationAngle(10f);
        // 设置 x 轴 坐标字体大小
        xAxis.setTextSize(10f);
        // 设置 x 坐标轴 颜色
        xAxis.setAxisLineColor(Color.RED);
        // 设置 x 坐标轴 宽度
        xAxis.setAxisLineWidth(2f);
        // 设置 x轴 的刻度数量
        xAxis.setLabelCount(10);
        // 设置 x 轴 从0开始 默认不是从 0
        xAxis.setAxisMinimum(0);


        // 获取 右边 y 轴
        YAxis mRAxis = mBarChart.getAxisRight();
        // 隐藏 右边 Y 轴
        mRAxis.setEnabled(false);
        // 获取 左边 Y轴
        YAxis mLAxis = mBarChart.getAxisLeft();
        // 取消 左边 Y轴 坐标线
        mLAxis.setDrawAxisLine(false);
        // 取消 横向 网格线
        mLAxis.setDrawGridLines(false);
        // 设置 x轴 的刻度数量
        mLAxis.setLabelCount(10);
        // 设置 从 0 开始
        mLAxis.setAxisMinimum(0f);
    }
}
