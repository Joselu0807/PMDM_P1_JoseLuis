package es.medac.joseluis.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private TextView tvWelcome;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazo los componentes del XML con Java
        etUsername = findViewById(R.id.etUsername);
        tvWelcome = findViewById(R.id.tvWelcome);
        btnStart = findViewById(R.id.btnStart);

        // Lógica del botón de iniciar ruta
        btnStart.setOnClickListener(v -> {
            String name = etUsername.getText().toString().trim();
            if (name.isEmpty()) {
                etUsername.setError(getString(R.string.error_empty_field));
            } else {
                // Aplico el parámetro dinámico definido en strings.xml
                String message = getString(R.string.welcome_message, name);
                tvWelcome.setText(message);
                Toast.makeText(this, "¡Ruta iniciada con éxito!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}