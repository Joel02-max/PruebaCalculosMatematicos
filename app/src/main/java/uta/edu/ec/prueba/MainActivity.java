package uta.edu.ec.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etDividendo, etDivisor, etParteEntera, etResiduo, etInvertido;
    private Button btnSiguiente, btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etDividendo = findViewById(R.id.etDividendo);
        etDivisor = findViewById(R.id.etDivisor);
        etParteEntera = findViewById(R.id.etParteEntera);
        etResiduo = findViewById(R.id.etResiduo);
        etInvertido = findViewById(R.id.etInvertido);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnMostrar = findViewById(R.id.btnMostrar);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();
                        etNombre.setText(data.getStringExtra("nom"));
                        etApellido.setText(data.getStringExtra("ape"));
                        etDividendo.setText(data.getStringExtra("divi"));
                        etDivisor.setText(data.getStringExtra("disor"));
                        etParteEntera.setText(data.getStringExtra("entera"));
                        etResiduo.setText(data.getStringExtra("residuo"));
                        etInvertido.setText(data.getStringExtra("numInv"));

                        btnMostrar.setEnabled(true);
                    }
                }
        );

        btnSiguiente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
            launcher.launch(intent);
        });

        btnMostrar.setOnClickListener(v -> {

        });
    }
}