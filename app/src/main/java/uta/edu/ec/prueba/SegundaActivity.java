package uta.edu.ec.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity {
    private EditText etNom, etApe, etDivi, etDisor, etNum;
    private Button btnSig, btnCerrar;
    private Intent datosCalculados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        etNom = findViewById(R.id.etNom2);
        etApe = findViewById(R.id.etApe2);
        etDivi = findViewById(R.id.etDivi2);
        etDisor = findViewById(R.id.etDisor2);
        etNum = findViewById(R.id.etNum2);
        btnSig = findViewById(R.id.btnSig2);
        btnCerrar = findViewById(R.id.btnCerrar2);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        datosCalculados = result.getData();
                        etDivi.setText(datosCalculados.getStringExtra("divi"));
                        etDisor.setText(datosCalculados.getStringExtra("disor"));
                        etNum.setText(datosCalculados.getStringExtra("num"));
                        btnCerrar.setEnabled(true);
                    }
                }
        );

        btnSig.setOnClickListener(v -> {
            Intent i = new Intent(this, TerceraActivity.class);
            i.putExtra("nom", etNom.getText().toString());
            i.putExtra("ape", etApe.getText().toString());
            launcher.launch(i);
        });

        btnCerrar.setOnClickListener(v -> {
            setResult(RESULT_OK, datosCalculados);
            finish();
        });
    }
}