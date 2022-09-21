package com.bkacad.nnt.base10toother;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber;
    private TextView tvResult;
    private Spinner spinner;

    private String baseConverter;
    private Converter converter;

    private void initUI() {
        edtNumber = findViewById(R.id.edtNumber);
        tvResult = findViewById(R.id.tvResult);
        spinner = findViewById(R.id.spinnerBase);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bases_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Tạo đối tượng converter
        converter = new MyConverter();
    }

    public void calculator(View view) {
        // Lấy dữ liệu từ edittext =>
        String strNumber = edtNumber.getText().toString();
        if (strNumber.isEmpty()) {
            edtNumber.setError("Hãy nhập dữ liệu");
            return;
        }
        // Tính toán
        // Cần biết chuyển sang hệ nào ?
        baseConverter = spinner.getSelectedItem().toString();
        String result = "";
        if(baseConverter.equals("BIN")){
            result = converter.decToBin(Long.parseLong(strNumber));
        }
        else if(baseConverter.equals("OCT")){
            result = converter.decToOct(Long.parseLong(strNumber));
        }
        else if(baseConverter.equals("HEX")){
            result = converter.decToHex(Long.parseLong(strNumber));
        }
        // Set view
        tvResult.setText(result);
    }
}