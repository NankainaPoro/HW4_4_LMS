package vakulenko.hw4_4_lms;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText userIdEditText, departureEditText, departureTimeEditText, arrivalEditText, seatEditText, priceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userIdEditText = findViewById(R.id.userIdEditText);
        departureEditText = findViewById(R.id.departureEditText);
        departureTimeEditText = findViewById(R.id.departureTimeEditText);
        arrivalEditText = findViewById(R.id.arrivalEditText);
        seatEditText = findViewById(R.id.seatEditText);
        priceEditText = findViewById(R.id.priceEditText);


        Button submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение данных
                String userId = userIdEditText.getText().toString();
                String departurePlace = departureEditText.getText().toString();
                String departureTime = departureTimeEditText.getText().toString();
                String arrivalTime = arrivalEditText.getText().toString();
                String seatNumberStr = seatEditText.getText().toString();
                String priceStr = priceEditText.getText().toString();

                // Проверка на пустые знач
                if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(departurePlace)
                        || TextUtils.isEmpty(departureTime) || TextUtils.isEmpty(arrivalTime)
                        || TextUtils.isEmpty(seatNumberStr) || TextUtils.isEmpty(priceStr)) {

                    Toast.makeText(MainActivity.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                    return;
                }

                int seatNumber;
                double price;
                try {

                    seatNumber = Integer.parseInt(seatNumberStr);
                    price = Double.parseDouble(priceStr);
                } catch (NumberFormatException e) {
                    // Всплывающее сообщение, если номер места или цена недопустимы
                    Toast.makeText(MainActivity.this, "Недопустимый номер места или цена", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Новый билет на основе введенных данных
                Serial ticket = new Serial(userId, departurePlace, departureTime, arrivalTime, seatNumber, price);

                // Намерение для перехода на SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ticket", ticket);
                startActivity(intent);
            }
        });
    }
}
