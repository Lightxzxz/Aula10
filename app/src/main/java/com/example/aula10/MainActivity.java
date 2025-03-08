package com.example.aula10;;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2, num3, num4;
    private TextView txtResultado;
    private Button btnExecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciando os componentes
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        txtResultado = findViewById(R.id.txtResultado);
        btnExecutar = findViewById(R.id.btnExecutar);

        btnExecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processarNumeros();
            }
        });
    }

    private void processarNumeros() {
        try {
            // Pegando os valores dos EditTexts e convertendo para inteiros
            int n1 = Integer.parseInt(num1.getText().toString());
            int n2 = Integer.parseInt(num2.getText().toString());
            int n3 = Integer.parseInt(num3.getText().toString());
            int n4 = Integer.parseInt(num4.getText().toString());

            // Criando um array com os números
            int[] numeros = {n1, n2, n3, n4};

            // Criando cópias do array para ordenações
            int[] crescente = Arrays.copyOf(numeros, numeros.length);
            int[] decrescente = Arrays.copyOf(numeros, numeros.length);

            // Ordenando os arrays
            Arrays.sort(crescente);
            Arrays.sort(decrescente);
            reverseArray(decrescente);

            // Exibindo os resultados
            String resultado = "Ordem Inserida: " + Arrays.toString(numeros) + "\n"
                    + "Ordem Crescente: " + Arrays.toString(crescente) + "\n"
                    + "Ordem Decrescente: " + Arrays.toString(decrescente);

            txtResultado.setText(resultado);

        } catch (NumberFormatException e) {
            txtResultado.setText("Por favor, preencha todos os campos corretamente.");
        }
    }

    // Método para inverter um array
    private void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
