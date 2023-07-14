package com.example.csvconvertor;

import android.content.Context;
import android.util.Log;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvConverter {
    private static final String TAG = "CsvConverter";
    private static final String CSV_DELIMITER = ",";

    private final Context context;
    private final String filePath;
    private File pdfFile;
    private final ArrayList<Exception> errors;
    private String delimiter = CSV_DELIMITER;

    public CsvConverter(Context context, String filePath) {
        this.context = context;
        this.filePath = filePath;
        this.pdfFile = null;
        this.errors = new ArrayList<>();
    }

    public ArrayList<Exception> getErrors() {
        return errors;
    }

    public File getPdfFile() {
        return pdfFile;
    }

    public boolean setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return true;
    }

    public boolean convertCsvToPdf() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            Document document = initPdfFile();
            document.open();
            process(document, reader);

            reader.close();
            document.close();
        } catch (IOException | DocumentException e) {
            Log.e(TAG, "Error converting CSV to PDF: " + e.getMessage());
            this.errors.add(e);
            return false;
        }
        return true;
    }

    private void process(Document document, BufferedReader reader) throws IOException, DocumentException {
        String row;
        StringBuilder sb = new StringBuilder();
        String[] headers = reader.readLine().split(delimiter);
        while ((row = reader.readLine()) != null) {
            String[] values = row.split(delimiter);
            for (int i = 0; i < values.length; i++) {
                sb.append(headers[i]).append(": ").append(values[i]).append(" ");
            }
            sb.append("\n");
            document.add(new Paragraph(sb.toString()));
            sb.delete(0, sb.length()); // clear the buffer
        }
    }

    private Document initPdfFile() throws FileNotFoundException, DocumentException {
        pdfFile = new File(context.getCacheDir(), "converted.pdf");
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
        return document;
    }
}

