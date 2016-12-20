package benpai.scoutsaustralia;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ProgressTrackerUncompletedFragment extends Fragment {

    private List<ProgressTrackerEntry> entryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressTrackerEntryAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.progress_tracker_uncompleted_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.uncompletedRecycler);

        mAdapter = new ProgressTrackerEntryAdapter(entryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareUncompletedEntries();

        return view;
    }

    private void prepareUncompletedEntries() {
        entryList.add(new ProgressTrackerEntry("VA Service", "28", "10/5/1726", "73/81/4201", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim.", "4pm 6/9/10", "#B71C1C", new String[] {"item1", "item2"}, false));
        entryList.add(new ProgressTrackerEntry("VA Outdoor", "28", "10/5/1726", "73/81/4201", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim.", "4pm 6/9/10", "#B71C1C", new String[] {"item1", "item2"}, false));
        entryList.add(new ProgressTrackerEntry("QS Expedition", "34", "10/5/1726", "73/81/4201", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim.", "4pm 6/9/10", "#2E7D32", new String[] {"item1", "item2"}, true));
        entryList.add(new ProgressTrackerEntry("QS First Aid", "34", "10/5/1726", "73/81/4201", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim.", "4pm 6/9/10", "#2E7D32", new String[] {"item1", "item2"}, true));
        entryList.add(new ProgressTrackerEntry("QS Expression", "34", "10/5/1726", "73/81/4201", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim.", "4pm 6/9/10", "#2E7D32", new String[] {"item1", "item2"}, true));

        mAdapter.notifyDataSetChanged();
    }
}
