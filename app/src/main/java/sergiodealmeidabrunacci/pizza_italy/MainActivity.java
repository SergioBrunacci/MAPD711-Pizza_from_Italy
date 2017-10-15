package sergiodealmeidabrunacci.pizza_italy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Start the variables
    public boolean onCreateOptionsMenu(Menu option){
        //Open the menu
        getMenuInflater().inflate(R.menu.savor, option);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem select){
        Intent size = new Intent(this, SizeActivity.class);
        String savor;

        //Open menu with savours and their IDs
        switch (select.getItemId()) {
            case R.id.meat:
                savor = "Meat Supreme";
                break;
            case R.id.hawaiian:
                savor = "Super Hawaiian";
                break;
            case R.id.veggie:
                savor = "Veggie";
                break;
            case R.id.mediterranean:
                savor = "Mediterranean";
                break;
            default:
                savor = "Nothing selected!!!";
                break;
        }

        size.putExtra("savor", savor);
        Toast.makeText(this, savor + "awas choosen!!!", Toast.LENGTH_LONG).show();

        //Open and pass savor to SizeActivity
        startActivity(size);
        return true;
    }
}
