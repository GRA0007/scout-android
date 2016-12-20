package benpai.scoutsaustralia;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AwardSchemeFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    List<String> listDataSubHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.award_scheme_fragment, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.award_scheme_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataSubHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int left = width-GetPixelFromDips(35, getActivity());
        int right = width-GetPixelFromDips(5, getActivity());
        positionChevron(left, right, expListView);

        return view;
    }

    static int GetPixelFromDips(float pixels, Context context) {
        // Get the screen's density scale
        final float scale = context.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataSubHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Joey Scouts");
        listDataSubHeader.add("6-7 Years");
        listDataHeader.add("Cub Scouts");
        listDataSubHeader.add("8-10 Years");
        listDataHeader.add("Scouts");
        listDataSubHeader.add("11-14 Years");
        listDataHeader.add("Venturer Scouts");
        listDataSubHeader.add("15-17 Years");
        listDataHeader.add("Rover Scouts");
        listDataSubHeader.add("18-25 Years");

        // Adding child data
        List<String> joeys = new ArrayList<String>();
        joeys.add("Participation Scheme");

        List<String> cubs = new ArrayList<String>();
        cubs.add("Primary Cub Scout Badges");
        cubs.add("Achievement Badges - Arts and Literature");
        cubs.add("Achievement Badges - Nature, Science and Technology");
        cubs.add("Achievement Badges - Our World");
        cubs.add("Achievement Badges - Sports and Recreation");
        cubs.add("Specialist and Other Cub Scout Badges");

        List<String> scouts = new ArrayList<String>();
        scouts.add("Primary Scout Badges");
        scouts.add("Target Badges");
        scouts.add("Proficiency Badges");
        scouts.add("Specialist and Other Scout Badges");

        List<String> venturers = new ArrayList<String>();
        venturers.add("Primary Venturer Scout Badges");
        venturers.add("Leadership Development");
        venturers.add("Personal Growth");
        venturers.add("Outdoor Activities");
        venturers.add("Community Involvement");
        venturers.add("Specialist and Other Venturer Scout Badges");

        List<String> rovers = new ArrayList<String>();
        rovers.add("Primary Rover Scout Badges");
        rovers.add("Progress Badges");
        rovers.add("Specialist Rover Scout Badges");

        listDataChild.put(listDataHeader.get(0), joeys); // Header, Child data
        listDataChild.put(listDataHeader.get(1), cubs);
        listDataChild.put(listDataHeader.get(2), scouts);
        listDataChild.put(listDataHeader.get(3), venturers);
        listDataChild.put(listDataHeader.get(4), rovers);
    }

    static void positionChevron(int left, int right, ExpandableListView listView) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            listView.setIndicatorBounds(left, right);
        } else {
            listView.setIndicatorBoundsRelative(left, right);
        }
    }

}
