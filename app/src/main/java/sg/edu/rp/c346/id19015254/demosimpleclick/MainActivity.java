package sg.edu.rp.c346.id19015254.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay;
    TextView tvDisplay;
    EditText etInput;
    ToggleButton tgBtn;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById(R.id.button2);
        tvDisplay = findViewById(R.id.textView2);
        etInput = findViewById(R.id.etInput);
        tgBtn = findViewById(R.id.toggleButtonEnabled);
        rgGender = findViewById(R.id.rgGender);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc = etInput.getText().toString();

                if (abc.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this, "Please input something", Toast.LENGTH_SHORT).show();
                }
                else {
                    int checkedRadioId = rgGender.getCheckedRadioButtonId();

                    if (checkedRadioId == R.id.rbMale) {
                        tvDisplay.setText("He says " + abc);
                    }
                    else if (checkedRadioId == R.id.rbFemale){
                        tvDisplay.setText("She says " + abc);
                    }
                    else {
                        tvDisplay.setText(abc);
                    }
                }
            }
        });

        tgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgBtn.isChecked() == true) {
                    etInput.setEnabled(true);
                    etInput.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    etInput.setEnabled(false);
                    etInput.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
}