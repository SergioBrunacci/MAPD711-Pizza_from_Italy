package sergiodealmeidabrunacci.pizza_italy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckOutActivity extends AppCompatActivity {

    String savor;
    String size;
    String top;
    String[] clientData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        Intent clientActivity = getIntent();

        TextView checkOutTxt = (TextView) findViewById(R.id.checkOutTxt);

        //load all information keep in the app
        savor = clientActivity.getStringExtra("savor");
        size = clientActivity.getStringExtra("size");
        top = clientActivity.getStringExtra("top");
        clientData = clientActivity.getStringArrayExtra("clientData");

        //load information from client
        checkOutTxt.setText(clientData[0] + ", thanks for buy on-line, we really appreciate your preference for our products. " +
                            "Your order with: " + size + ", " + savor + ", " + top + " Was successfully processed " +
                            "and will be delivered at " + clientData[1] + " soon.");
    }
}
