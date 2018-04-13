package saltalepre.jackie.magikarpswisdom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView quoteView;
            ImageView karpView;
            Random randomGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        karpView = findViewById(R.id.magikarpImageView);
        quoteView = findViewById(R.id.wisdomView);
        randomGenerator = new Random();

        getRandomQuote(quoteView);
    }

    /*
    public void provideWisdom(View v) {
        Intent intent = new Intent(this, WisdomActivity.class);
        startActivity(intent);
    }
    */

    private void spin() {
        long animationDuration = 500;
        float yDelta = 450f;

        ObjectAnimator downAnimator = ObjectAnimator.ofFloat(karpView, "translationY", 0f, yDelta);
        downAnimator.setDuration(animationDuration);

        ObjectAnimator upAnimator = ObjectAnimator.ofFloat(karpView, "translationY", yDelta, 0f);
        upAnimator.setDuration(animationDuration);

        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(karpView, "rotation", 0f, 360f);
        rotateAnimator.setDuration(animationDuration * 2);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(downAnimator, rotateAnimator);
        animatorSet.playSequentially(downAnimator, upAnimator);
        animatorSet.start();
    }

    public void getRandomQuote(View v) {
        spin();

        String[] wisdomQuotes =    {"You can do the thing",
                                    "Just splash it",
                                    "Evolving is overrated",
                                    "Be the splash you want to see in the world",
                                    "I believe in you, human",
                                    "Haters gonna hate, karps gonna karp",
                                    "Today's the day, I can just feeeeeel it",
                                    "Old rod best rod",
                                    "Tell me who I need to beat up",
                                    "Life sucks, but you don't!",
                                    "You rock!",
                                    "You are a beautiful potato",
                                    "I find your elbows to be very sexy",
                                    "Follow the way of the karp and you shall suffer no longer",
                                    "A true karp doesn't fight his enemies. It just splashes them away",
                                    "Stop worrying and go make yourself a sandwich",
                                    "A life without a splash isn't a life worth living"};

        int randomIndex = randomGenerator.nextInt(wisdomQuotes.length);
        String quote = wisdomQuotes[randomIndex];
        quoteView.setText(quote);
    }
}