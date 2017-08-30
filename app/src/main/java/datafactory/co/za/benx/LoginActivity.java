package datafactory.co.za.benx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.btn_login){
            Intent i = new Intent(LoginActivity.this, SplashScreenActivity.class);
            startActivity(i);
        }
    }
}
