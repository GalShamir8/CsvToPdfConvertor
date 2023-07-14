package com.example.csvtopdfconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.csvconvertor.CsvConverter;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String FILE_PATH = "path/to/test.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertCsvToPdf();
    }

    private void convertCsvToPdf() {
        CsvConverter csvConverter = new CsvConverter(getApplicationContext(), FILE_PATH);
        boolean success = csvConverter.convertCsvToPdf();
        if (success) {
            File pdfFile = csvConverter.getPdfFile();
            // do something
        } else {
            ArrayList<Exception> errors = csvConverter.getErrors();
            // handle errors
        }
    }
}