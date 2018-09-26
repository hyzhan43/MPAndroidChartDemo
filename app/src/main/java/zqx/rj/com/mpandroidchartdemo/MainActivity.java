package zqx.rj.com.mpandroidchartdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;

import zqx.rj.com.mpandroidchartdemo.charts.BarChartActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        Button mBtnBar = findViewById(R.id.btn_bar_chart);
        mBtnBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_bar_chart:
                intent = new Intent(this, BarChartActivity.class);
                break;
        }

        startActivity(intent);
    }
}
