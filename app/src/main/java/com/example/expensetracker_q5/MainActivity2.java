package com.example.expensetracker_q5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    PieChart pieChart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //getting income and expense from dashBoard Activity
        Bundle bundle = getIntent().getExtras();
        int expense = bundle.getInt("Expense");
        int income = bundle.getInt("Income");
        pieChart = findViewById(R.id.pieChart2);
        ArrayList<PieEntry> entry = new ArrayList<>();
        //creating an entry if the value is greater than zero
        if(expense>0) {
            entry.add(new PieEntry(expense, "Expense"));
        }
        if(income>0) {
            entry.add(new PieEntry(income, "Income"));
        }
        //adding the entry to the dataset
        PieDataSet dataSet = new PieDataSet(entry,null);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(22f);

        PieData pieData = new PieData(dataSet);
        //setting the data to the pie chart
        pieChart.setData(pieData);
        pieChart.setCenterText("Revenue");
        pieChart.setCenterTextSize(24f);
        pieChart.setCenterTextColor(Color.BLACK);
        //creating the pie chart
        pieChart.animate();
    }
}