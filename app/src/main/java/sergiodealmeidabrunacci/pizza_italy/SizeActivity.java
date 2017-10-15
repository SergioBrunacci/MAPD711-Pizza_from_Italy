package sergiodealmeidabrunacci.pizza_italy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SizeActivity extends AppCompatActivity {

    String size;
    String savor;

    RadioGroup rdGroup;
    RadioButton rbSmall;
    RadioButton rbMedium;
    RadioButton rbLarge;
    RadioButton rbXlarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        Intent mainActivity = getIntent();

        //connect references with objects
        rdGroup = (RadioGroup) findViewById(R.id.rdSzGroup);
        rbSmall = (RadioButton) findViewById(R.id.rdSmall);
        rbMedium = (RadioButton) findViewById(R.id.rdMedium);
        rbLarge = (RadioButton) findViewById(R.id.rdLarge);
        rbXlarge = (RadioButton)findViewById(R.id.rdXlarge);

        //take savor from the preview activity
        savor = mainActivity.getStringExtra("savor");

        //show savior in the screen
        TextView szQuestText = (TextView) findViewById(R.id.szQuestText);
        szQuestText.setText("Choose the size for your "+ savor + " pizza!!!");

        //Keep the selected radio button and go to the next activity
        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId){
                Intent TopsActivity = new Intent(SizeActivity.this, TopsActivity.class);

                if (rbSmall.isChecked()){
                    size = "Small";
                }else if (rbMedium.isChecked()){
                    size = "Medium";
                }else if (rbLarge.isChecked()){
                    size = "Large";
                }else if (rbXlarge.isChecked()){
                    size = "X-Large";
                }
                //Show current selection for the client
                Toast.makeText(SizeActivity.this, size + " " + savor + " choose!!!", Toast.LENGTH_LONG).show();

                //Transfer choices for the next activity
                TopsActivity.putExtra("savor", savor);
                TopsActivity.putExtra("size", size);
                startActivity(TopsActivity);
            }

        });
    }
}
