package benpai.scoutsaustralia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PreferencesFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}