package com.example.semana03_pc1_p3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText editText1, editText2;
    TextView resultadoMK, resultadoKM;
    Button btnCalcular, btnLimpiar;
    Double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupOpciones);
        editText1 = findViewById(R.id.editTextValor1);
        editText2 = findViewById(R.id.editTextValor2);
        resultadoMK = findViewById(R.id.txtResultadoMK);
        resultadoKM = findViewById(R.id.txtResultadoKM);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        //editText1.setEnabled(false);
        //editText2.setEnabled(false);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButtonMK:
                        //editText1.setEnabled(true);
                        Double valor1 = Double.parseDouble(editText1.getText().toString());
                        resultado = valor1 * 0.001;
                        resultadoMK.setText(getResultado(resultado) + " Km");
                        break;
                    case R.id.radioButtonKM:
                        //editText2.setEnabled(true);
                        Double valor2 = Double.parseDouble(editText2.getText().toString());
                        resultado = valor2 * 1000;
                        resultadoKM.setText(getResultado(resultado) + " m");
                        break;
                    default:
                        resultadoMK.setText("No ha seleccionado una opción");
                        resultadoKM.setText("No ha seleccionado una opción");
                        return;
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText("");
                editText2.setText("");
                resultadoMK.setText("");
                resultadoKM.setText("");
            }
        });
    }

    private String getResultado(Object resultado) {
        final String TXT_RESULTADO = "%s";
        return String.format(TXT_RESULTADO, resultado);
    }

}