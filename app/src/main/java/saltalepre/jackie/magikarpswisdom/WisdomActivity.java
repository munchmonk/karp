package saltalepre.jackie.magikarpswisdom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class WisdomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisdom);

        getRandomQuote(findViewById(R.id.wisdomView));
    }

    public void getRandomQuote(View v) {
        String[] wisdomQuotes = {"Ciao", "Darwin", "Bellaaa"};
        Random generator = new Random();
        int randomIndex = generator.nextInt(wisdomQuotes.length);
        String quote = wisdomQuotes[randomIndex];

        TextView view = findViewById(R.id.wisdomView);
        view.setText(quote);
    }
}