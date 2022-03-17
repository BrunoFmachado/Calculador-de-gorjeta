package me.dio.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText editvalor;
    private TextView textporcentagem;
    private TextView textgorjeta;
    private TextView texttotal;
    private SeekBar seekBarGorjeta;


    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editvalor = findViewById(R.id.editvalor);
        textporcentagem = findViewById(R.id.textporcentagem);
        textgorjeta = findViewById(R.id.textgorjeta);
        texttotal = findViewById(R.id.texttotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);


        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {


                porcentagem = progress;
                textporcentagem.setText(Math.round(porcentagem) + "%");
                Calcular();

            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void Calcular() {

        String ValorRecuperado = editvalor.getText().toString();
        if (ValorRecuperado == null || ValorRecuperado.equals("")) {

            Toast.makeText( getApplicationContext(),"digite um valor primeiro",
                    Toast.LENGTH_LONG).show();

        } else {

        double ValorDigitado = Double.parseDouble(ValorRecuperado);

        double gorjeta = ValorDigitado * (porcentagem/100);
        double total = gorjeta + ValorDigitado;

        textgorjeta.setText("R$" + gorjeta);
        texttotal.setText("R$" +  total);
        }
    }
}
