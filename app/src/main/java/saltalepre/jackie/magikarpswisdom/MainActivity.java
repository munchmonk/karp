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
        long animationDuration = 400;
        float yDelta = -700f;

        ObjectAnimator downAnimator = ObjectAnimator.ofFloat(karpView, "translationY", yDelta, 0f);
        downAnimator.setDuration(animationDuration);

        ObjectAnimator upAnimator = ObjectAnimator.ofFloat(karpView, "translationY",  0f, yDelta);
        upAnimator.setDuration(animationDuration);

        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(karpView, "rotation", 0f, 360f);
        rotateAnimator.setDuration(animationDuration * 2);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(upAnimator, rotateAnimator);
        animatorSet.playSequentially(upAnimator, downAnimator);
        animatorSet.start();
    }

    public void getRandomQuote(View v) {
        spin();

        String[] wisdomQuotes =    {"You can do the thing",
                                    "Just goddamn do it already",
                                    "I believe in you, human",
                                    "Life sucks, but you don't!",
                                    "You rock!",
                                    "You are a beautiful potato",
                                    "Who's the best? I'M THE BEST! And you're a close second",
                                    "If you can dream it, there's a slight chance you might be able to do it",
                                    "- stress + karp",
                                    "You didn't fail, you just achieved the wrong result",
                                    "You'll survive the night, so who cares?",
                                    "You tap me like no other",
                                    "I care about you!",
                                    "Stop worrying and go make yourself a sandwich"};

        int randomIndex = randomGenerator.nextInt(wisdomQuotes.length);
        String quote = wisdomQuotes[randomIndex];
        quoteView.setText(quote);
    }
}