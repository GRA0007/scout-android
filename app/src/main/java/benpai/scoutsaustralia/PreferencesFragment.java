package benpai.scoutsaustralia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PreferencesFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference removeJSON = findPreference("removeJSON");
        removeJSON.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Delete Database")
                        .setMessage("Are you sure you want to delete the JSON? This cannot be undone.")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "Yayy!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //If user answered no, do nothing
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
        });
        Preference startIntro = findPreference("startIntro");
        startIntro.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getActivity(), MainIntroActivity.class));
                return true;
            }
        });
    }

}