package sergiodealmeidabrunacci.pizza_italy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ClientActivity extends AppCompatActivity {

    String size;
    String savor;
    String top;

    EditText clientName;
    EditText clientAddress;
    EditText clientZipCode;
    EditText clientPhone;
    EditText clientCard;
    EditText clientCardExpiryDate;
    String[] clientData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        Intent topsActivity = getIntent();

        //load pizza information
        savor = topsActivity.getStringExtra("savor");
        size = topsActivity.getStringExtra("size");
        top = topsActivity.getStringExtra("top");

        //Insert information
        clientName = (EditText) findViewById(R.id.clientNameIn);
        clientAddress = (EditText) findViewById(R.id.clientAddressIn);
        clientZipCode = (EditText) findViewById(R.id.clientZipIn);
        clientPhone = (EditText) findViewById(R.id.clientPhoneIn);
        clientCard = (EditText) findViewById(R.id.clientCardIn);
        clientCardExpiryDate = (EditText) findViewById(R.id.clientCardExpiryDateIn);

        Button demandButton = (Button) findViewById(R.id.demandButton);

        //take client information after click the button - onClick event
        demandButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent checkOutActivity = new Intent(ClientActivity.this, CheckOutActivity.class);

                //client data
                clientData = new String[]{
                        clientName.getText().toString(),
                        clientAddress.getText().toString(),
                        clientZipCode.getText().toString(),
                        clientPhone.getText().toString(),
                        clientCardExpiryDate.getText().toString()
                };

                //Transfer choices for the next activity
                checkOutActivity.putExtra("savor", savor);
                checkOutActivity.putExtra("size", size);
                checkOutActivity.putExtra("top", top);
                checkOutActivity.putExtra("clientData", clientData);
                startActivity(checkOutActivity);
            }
        });
    }
}
