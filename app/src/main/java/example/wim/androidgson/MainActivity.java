package example.wim.androidgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import example.wim.androidgson.model.Address;
import example.wim.androidgson.model.Customer;
import example.wim.androidgson.model.Phone;
import example.wim.androidgson.util.FileUtil;

public class MainActivity extends AppCompatActivity {

    TextView firstName;
    TextView lastName;
    TextView age;
    TextView street;
    TextView city;
    TextView state;
    TextView postalCode;
    TextView home;
    TextView fax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectViews();
        parsingJson();
    }

    private void injectViews(){
        firstName = (TextView) findViewById(R.id.first_name);
        lastName = (TextView) findViewById(R.id.last_name);
        age = (TextView) findViewById(R.id.age);
        street = (TextView) findViewById(R.id.street);
        city = (TextView) findViewById(R.id.city);
        state = (TextView) findViewById(R.id.state);
        postalCode = (TextView) findViewById(R.id.postal_code);
        home = (TextView) findViewById(R.id.home);
        fax = (TextView) findViewById(R.id.fax);
    }

    private void parsingJson(){
        String json = FileUtil.copyFromAssets(this.getApplicationContext(), "customer.json");

        Gson gson = new Gson();
        Customer customer = gson.fromJson(json, Customer.class);

        firstName.setText(getResources().getString(R.string.first_name, customer.getFirstName()));
        lastName.setText(getResources().getString(R.string.last_name, customer.getLastName()));
        age.setText(getResources().getString(R.string.age, customer.getAge()));

        // Address
        Address address = customer.getAddress();

        street.setText(getResources().getString(R.string.street, address.getStreetAddress()));
        city.setText(getResources().getString(R.string.city, address.getCity()));
        state.setText(getResources().getString(R.string.state, address.getState()));
        postalCode.setText(getResources().getString(R.string.postal_code, address.getPostalCode()));

        // Phone
        List<Phone> phoneList = customer.getPhoneNumber();

        home.setText(phoneList.get(0).getType() +" : "+phoneList.get(0).getNumber());
        fax.setText(phoneList.get(1).getType() + " : "+phoneList.get(1).getNumber());
    }
}
