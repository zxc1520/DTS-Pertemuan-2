package id.afif.pertemuanke2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Kalkulator extends AppCompatActivity {

    private EditText edt1, edt2;
    private TextView res;
    private Button tambah, kurang, kali, bagi;
    private double result;
    private String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        edt1 = findViewById(R.id.edtField1);
        edt2 = findViewById(R.id.edtField2);
        tambah = findViewById(R.id.btnAdd);
        kurang = findViewById(R.id.btnSubs);
        kali = findViewById(R.id.btnMult);
        bagi = findViewById(R.id.btnDiv);
        res = findViewById(R.id.tv_Result);

        add(tambah);
        substract(kurang);
        multiple(kali);
        divide(bagi);


    }

    private void add(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edt1.getText().toString();
                String num2 = edt2.getText().toString();

                if (num1.equals("") && num2.equals("")) {
                    pushMsg("Field Masih kosong !");
                } else {
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());
                    result = a + b;
                    res.setText(String.valueOf(result));
                }
            }
        });
    }

    private void substract(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edt1.getText().toString();
                String num2 = edt2.getText().toString();

                if (num1.equals("") && num2.equals("")) {
                    pushMsg("Field Masih Kosong !");
                } else {
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());

                    result = a - b;
                    res.setText(String.valueOf(result));
                }
            }
        });
    }
//
    private void multiple(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edt1.getText().toString();
                String num2 = edt2.getText().toString();

                if (num1.equals("") && num2.equals("")) {
                    pushMsg("Field Masih Kosong !");
                } else {
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());

                    result = a * b;
                    res.setText(String.valueOf(result));
                }
            }
        });
    }
//
    private void divide(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edt1.getText().toString();
                String num2 = edt2.getText().toString();

                if (num1.equals("") && num2.equals("")) {
                    pushMsg("Field Masih Kosong !");
                } else {
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());

                    result = a / b;
                    res.setText(String.valueOf(result));
                }
            }
        });
    }

    private void pushMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}