package uta.edu.ec.prueba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class TerceraActivity extends AppCompatActivity {
    private EditText etNom, etApe, etDivi, etDisor, etNum;
    private Button btnCerrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        etNom = findViewById(R.id.etNom3);
        etApe = findViewById(R.id.etApe3);
        etDivi = findViewById(R.id.etDivi3);
        etDisor = findViewById(R.id.etDisor3);
        etNum = findViewById(R.id.etNum3);
        btnCerrar = findViewById(R.id.btnCerrar3);

        etNom.setText(getIntent().getStringExtra("nom"));
        etApe.setText(getIntent().getStringExtra("ape"));

        btnCerrar.setOnClickListener(v -> {
            int dividendo = Integer.parseInt(etDivi.getText().toString());
            int divisor = Integer.parseInt(etDisor.getText().toString());
            int numBase = Integer.parseInt(etNum.getText().toString());

            // 1. División por restas
            int cociente = 0;
            int residuo = dividendo;
            while (residuo >= divisor) {
                residuo -= divisor;
                cociente++;
            }

            // 2. Invertir número matemáticamente
            int invertido = 0;
            int aux = numBase;
            while (aux > 0) {
                int digito = aux % 10;
                invertido = (invertido * 10) + digito;
                aux = aux / 10;
            }

            Intent res = new Intent();
            res.putExtra("nom", etNom.getText().toString());
            res.putExtra("ape", etApe.getText().toString());
            res.putExtra("divi", String.valueOf(dividendo));
            res.putExtra("disor", String.valueOf(divisor));
            res.putExtra("num", String.valueOf(numBase));
            res.putExtra("entera", String.valueOf(cociente));
            res.putExtra("residuo", String.valueOf(residuo));
            res.putExtra("numInv", String.valueOf(invertido));

            setResult(RESULT_OK, res);
            finish();
        });
    }
}