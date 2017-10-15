package sergiodealmeidabrunacci.pizza_italy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class TopsActivity extends AppCompatActivity {

    String size;
    String savor;
    String top;

    CheckBox cheeseChkBx;
    CheckBox gnPepperChkBx;
    CheckBox skHamChkBx;
    CheckBox bkOlivesChkBx;
    CheckBox spOnionsChkBx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        Intent sizeActivity = getIntent();

        //load savor from the previews activity
        savor = sizeActivity.getStringExtra("savor");
        size = sizeActivity.getStringExtra("size");

        //connect references with objects
        cheeseChkBx = (CheckBox) findViewById(R.id.cheeseChkBx);
        gnPepperChkBx = (CheckBox) findViewById(R.id.gnPepperChkBx);
        skHamChkBx = (CheckBox) findViewById(R.id.skHamChkBx);
        bkOlivesChkBx = (CheckBox) findViewById(R.id.bkOlivesChkBx);
        spOnionsChkBx = (CheckBox) findViewById(R.id.spOnionsChkBx);

        //show savor in the screen
        TextView topsQuestTxt = (TextView) findViewById(R.id.topsQuestTxt);
        topsQuestTxt.setText("Choose the toppings for your " + size + " " + savor + ":");

        Button next = (Button) findViewById(R.id.nextButton);

        //At event of the next Button take the tops
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent clientActivity = new Intent(TopsActivity.this, ClientActivity.class);

                top = "with ";
                if (cheeseChkBx.isChecked()) top += "Cheese" + ", ";
                if (gnPepperChkBx.isChecked()) top += "Green Pepper" + ", ";
                if (skHamChkBx.isChecked()) top += "Smoked Ham" + ", ";
                if (bkOlivesChkBx.isChecked()) top += "Black Olives" + ", ";
                if (spOnionsChkBx.isChecked()) top += "Spanish Onions" + ", ";

                int index = top.lastIndexOf(",");
                if (index != -1){
                    //change the last comma for point
                    top = new StringBuilder(top).replace(index, index + 1, ".").toString();
                }else{
                    top = "No tops chosen!!!";
                }

                //show the information in the screen
                Toast.makeText(TopsActivity.this, size + " " + savor + " " + top + "chosen !!!", Toast.LENGTH_SHORT).show();

                //Transfer choices for the next activity
                clientActivity.putExtra("savor", savor);
                clientActivity.putExtra("size", size);
                clientActivity.putExtra("top", top);
                startActivity(clientActivity);
            }
        });
    }
}
