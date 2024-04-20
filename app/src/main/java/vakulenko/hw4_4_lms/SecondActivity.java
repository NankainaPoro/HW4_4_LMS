package vakulenko.hw4_4_lms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView userIdTextView = findViewById(R.id.userIdTextView);
        TextView departureTextView = findViewById(R.id.departureTextView);
        TextView arrivalTextView = findViewById(R.id.arrivalTextView);
        TextView seatTextView = findViewById(R.id.seatTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);

        Button createNewOrderButton = findViewById(R.id.createNewOrderButton);
        createNewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создание Intent для возврата к MainActivity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ticket")) {
            Serial ticket = (Serial) intent.getSerializableExtra("ticket");
            if (ticket != null) {
                userIdTextView.setText("Идентификатор пользователя: " + ticket.getUserId());
                departureTextView.setText("Место отправления: " + ticket.getDeparturePlace());
                departureTextView.setText("Место отправления: " + ticket.getDeparturePlace() + ", Время отправления: " + ticket.getDepartureTime());
                arrivalTextView.setText("Время прибытия: " + ticket.getArrivalTime());
                seatTextView.setText("Место: " + ticket.getSeatNumber());
                priceTextView.setText("Цена: " + ticket.getPrice() + "руб.");
            }
        }
    }
}
