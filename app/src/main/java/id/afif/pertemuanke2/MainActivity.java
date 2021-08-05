package id.afif.pertemuanke2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView luas, keliling, kondisi;
    private EditText edtJari;
    private Button btnHitung;

    private float inputJari;
    private double kell, ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding
        luas = (TextView)findViewById(R.id.tv_luas);
        keliling = (TextView)findViewById(R.id.tv_keliling);
        kondisi = (TextView)findViewById(R.id.condition);
        edtJari = (EditText)findViewById(R.id.edtJari);
        btnHitung = (Button)findViewById(R.id.btnSubmit);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputJari = Float.parseFloat(edtJari.getText().toString());

                kell = 2 * Math.PI * inputJari;
                ls = Math.pow(inputJari, 2) * Math.PI;

                keliling.setText(String.valueOf(kell));
                luas.setText(String.valueOf(ls));

                if (kell > ls) {
                    kondisi.setText("Keliling lebih besar");
                } else if (kell < ls) {
                    kondisi.setText("Luas lebih besar");
                } else if (kell == ls) {
                    kondisi.setText("Keliling sama dengan luas");
                } else {
                    kondisi.setText("Error");
                }

                pushMsg("Done");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume",  Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_1:
                Intent intent = new Intent(this, Kalkulator.class);
                startActivity(intent);
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void pushMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}