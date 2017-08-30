package datafactory.co.za.benx;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.lang.Object;
import static java.text.DateFormat.*;

/**
 * Created by sandile.shezi on 2017/08/28.
 */

public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Spinner spinner;
    private static final String[] items = {"Male", "Female"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner = (Spinner) findViewById(R.id.sp_gender);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(RegisterActivity.this);
    }

    public void datePicker(View view){

        EditText editText = (EditText) findViewById(R.id.cmb_dob);
        InputMethodManager imm = (InputMethodManager)
        getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(
                editText.getWindowToken(), 0);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getFragmentManager(), "date");
    }

    private void setDate(final Calendar calendar){
        //final DateFormat dateFormat = new getDateInstance().format(MEDIUM);
        final DateFormat dateFormat = DateFormat.getDateInstance(MEDIUM);
        ((EditText) findViewById(R.id.cmb_dob)).setText(dateFormat.format(calendar.getTime()));
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        Calendar calendar = new GregorianCalendar(year, month, day);
        setDate(calendar);
    }

    public static  class DatePickerFragment extends DialogFragment{
        public Dialog onCreateDialog(Bundle saveInstanceState){
            //final Calender calender = new Calendar.getInstance();
            final Calendar calender = Calendar.getInstance();
            int year = calender.get(Calendar.YEAR);
            int month = calender.get(Calendar.MONTH);
            int day = calender.get(Calendar.DAY_OF_MONTH);

            return  new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }
}
