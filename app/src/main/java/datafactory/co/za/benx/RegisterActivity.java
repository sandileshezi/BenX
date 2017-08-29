package datafactory.co.za.benx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sandile.shezi on 2017/08/28.
 */

public class RegisterActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
