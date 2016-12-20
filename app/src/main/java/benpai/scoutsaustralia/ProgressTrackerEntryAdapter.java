package benpai.scoutsaustralia;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.heinrichreimersoftware.materialintro.util.CheatSheet;

import java.util.List;

public class ProgressTrackerEntryAdapter extends RecyclerView.Adapter<ProgressTrackerEntryAdapter.MyViewHolder> {

    private List<ProgressTrackerEntry> entryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, dates, notes;
        public LinearLayout color;
        public ImageView share, star;
        public Button action;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.progress_tracker_entry_name);
            dates = (TextView) view.findViewById(R.id.progress_tracker_entry_dates);
            notes = (TextView) view.findViewById(R.id.progress_tracker_entry_notes);
            color = (LinearLayout) view.findViewById(R.id.progress_tracker_entry_color);
            share = (ImageView) view.findViewById(R.id.progress_tracker_entry_action_share);
            star = (ImageView) view.findViewById(R.id.progress_tracker_entry_action_star);
            action = (Button) view.findViewById(R.id.progress_tracker_entry_action_main);
        }
    }


    public ProgressTrackerEntryAdapter(List<ProgressTrackerEntry> entryList) {
        this.entryList = entryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.progress_tracker_entry, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProgressTrackerEntry progressTrackerEntry = entryList.get(position);
        holder.name.setText(progressTrackerEntry.getName());
        holder.dates.setText(progressTrackerEntry.getStartDate() + " - " + progressTrackerEntry.getEndDate());
        holder.notes.setText(progressTrackerEntry.getNotes());
        holder.color.setBackgroundColor(Color.parseColor(progressTrackerEntry.getColor()));
        CheatSheet.setup(holder.share);
        CheatSheet.setup(holder.star);
    }

    @Override
    public int getItemCount() {
        return entryList.size();
    }
}
