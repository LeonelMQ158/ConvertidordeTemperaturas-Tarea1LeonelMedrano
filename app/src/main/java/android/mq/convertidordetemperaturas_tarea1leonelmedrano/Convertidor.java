package android.mq.convertidordetemperaturas_tarea1leonelmedrano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Convertidor extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertidor);
    }*/
    private Spinner spinnerDe;
    private Spinner spinnerA;
    private EditText etDe;
    protected TextView tvMos;
    protected double temp;
    protected String temp1;
    protected String temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertidor);

        spinnerDe = (Spinner)findViewById(R.id.spinnerIngresar);
        spinnerA = (Spinner)findViewById(R.id.spinnerPasar);
        etDe = (EditText)findViewById(R.id.editTextTemperatura);
        tvMos = (TextView) findViewById(R.id.textViewMostrar);
        String []unidades={"C","F","K"};
        String []unidadesT={"C","F","K"};
        ArrayAdapter<String> adapterF = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,unidades);
        ArrayAdapter<String> adapterT = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,unidadesT);
        spinnerDe.setAdapter(adapterF);
        spinnerA.setAdapter(adapterT);

    }

    public void convertir(View view){
        temp1 = spinnerDe.getSelectedItem().toString();
        temp2 = spinnerA.getSelectedItem().toString();

        double valueToConvert = Double.parseDouble(etDe.getText().toString());

        if (temp1.equals(temp2))
            Toast.makeText(this, "“No se puede convertir entre el mismo”", Toast.LENGTH_LONG).show();

        switch (temp1){
            case "C":
                if (temp2.equals("F")) {
                    temp = valueToConvert * 1.8 + 32;
                    tvMos.setText("" + temp);
                }
                else if (temp2.equals("K")) {
                    temp = valueToConvert + 273.15;
                    tvMos.setText("" + temp);
                }
                break;
            case "F":
                if (temp2.equals("C")) {
                    temp = (valueToConvert - 32) / 0.8;
                    tvMos.setText("" + temp);
                }
                else if (temp2.equals("K")) {
                    temp = (5 / 9) * (valueToConvert - 32) + 273.15;
                    tvMos.setText("" + temp);
                }
                break;
            default:
                if (temp2.equals("C")) {
                    temp = valueToConvert - 273.15;
                    tvMos.setText("" + temp);
                }
                else if (temp2.equals("F")) {
                    temp = 1.8 * (valueToConvert - 273.15) + 32;
                    tvMos.setText("" + temp);
                }
                break;
        }

    }

    public void limpiar(View view){
        etDe.setText("");
        tvMos.setText("");
    }

}

}
