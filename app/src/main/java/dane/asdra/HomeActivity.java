package dane.asdra;

import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class HomeActivity extends BaseActivity {

    MediaPlayer mp;
    boolean lsa;
    CheckBox checkBox;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        initBeaverAnimation();
       // initWhoPlaysButton();
        initGame1Button();
        initGame2Button();
        initInfoButton();

    }

    private void initBeaverAnimation(){
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.beaver_eyes_open), 4000);
        animation.addFrame(getResources().getDrawable(R.drawable.beaver_eyes_close), 500);
        animation.addFrame(getResources().getDrawable(R.drawable.beaver_eyes_open), 500);
        animation.addFrame(getResources().getDrawable(R.drawable.beaver_eyes_close), 800);
        animation.setOneShot(false);
        ImageView imageAnim =  (ImageView) findViewById(R.id.oso_en_pantalla);
        imageAnim.setImageDrawable(animation);
        animation.start();
    }

    private void initGame1Button() {


        //Over shadow EVENT
        findViewById(R.id.juego1_button).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.setBackgroundResource(R.drawable.game1hover);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.setBackgroundResource(R.drawable.game1);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        findViewById(R.id.g1_level1).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        findViewById(R.id.linearLayoutGame1).setBackgroundResource(R.drawable.level1active);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        findViewById(R.id.linearLayoutGame1).setBackgroundResource(R.drawable.level);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        findViewById(R.id.g1_level2).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        findViewById(R.id.linearLayoutGame1).setBackgroundResource(R.drawable.level2active);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        findViewById(R.id.linearLayoutGame1).setBackgroundResource(R.drawable.level);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        findViewById(R.id.g1_level1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mp.stop();
                nextScreen(GameOneActivity.class, getString(R.string.juegoDePalabras), 1, checkBox.isChecked());
            }
        });
        findViewById(R.id.g1_level2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mp.stop();
                nextScreen(GameOneActivity.class, getString(R.string.juegoDePalabras), 2, checkBox.isChecked());
            }
        });

        findViewById(R.id.juego1_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                findViewById(R.id.juego1_button).setVisibility(View.INVISIBLE);
                findViewById(R.id.linearLayoutGame1).setVisibility(View.VISIBLE);

                findViewById(R.id.juego2_button).setVisibility(View.VISIBLE);
                findViewById(R.id.linearLayoutGame2).setVisibility(View.GONE);
            }
        });
    }
    private void initGame2Button() {
        findViewById(R.id.juego2_button).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.setBackgroundResource(R.drawable.game2hover);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.setBackgroundResource(R.drawable.game2);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });


        findViewById(R.id.g2_level1).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        findViewById(R.id.linearLayoutGame2).setBackgroundResource(R.drawable.level1active);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        findViewById(R.id.linearLayoutGame2).setBackgroundResource(R.drawable.level);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        findViewById(R.id.g2_level2).setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        findViewById(R.id.linearLayoutGame2).setBackgroundResource(R.drawable.level2active);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        findViewById(R.id.linearLayoutGame2).setBackgroundResource(R.drawable.level);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });


        findViewById(R.id.g2_level1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mp.stop();
                nextScreen(GameOneActivity.class, getString(R.string.juegoDeSilabas), 1,checkBox.isChecked());
            }
        });
        findViewById(R.id.g2_level2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mp.stop();
                nextScreen(GameOneActivity.class, getString(R.string.juegoDeSilabas), 2,checkBox.isChecked());
            }
        });



        findViewById(R.id.juego2_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                findViewById(R.id.juego2_button).setVisibility(View.INVISIBLE);
                findViewById(R.id.linearLayoutGame2).setVisibility(View.VISIBLE);

                findViewById(R.id.juego1_button).setVisibility(View.VISIBLE);
                findViewById(R.id.linearLayoutGame1).setVisibility(View.GONE);
            }
        });
    }

    private void initInfoButton(){
        findViewById(R.id.infoButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                infoScreen();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp = MediaPlayer.create(getBaseContext(), R.raw.toys_on_the_run);
        mp.start();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
        mp.release();
    }
}
