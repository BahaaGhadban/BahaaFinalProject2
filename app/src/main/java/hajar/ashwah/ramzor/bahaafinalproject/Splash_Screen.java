package hajar.ashwah.ramzor.bahaafinalproject;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //start next activity (screen) automatically after period of time
        Handler h=new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                //to  open new activity from current to next
                Intent i=new Intent(Splash_Screen.this, SignInActivityF.class);
                startActivity(i);
                //to close current activity
                finish();
            }
        };
        h.postDelayed(r,3000);
    }
}