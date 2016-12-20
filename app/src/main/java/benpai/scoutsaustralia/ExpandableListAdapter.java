package benpai.scoutsaustralia;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    private List<String> _listDataSubHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, List<String> listDataSubHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataSubHeader = listDataSubHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.award_scheme_list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.award_scheme_list_item_title);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    public Object getGroupSub(int groupPosition) {
        return this._listDataSubHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        String subHeaderTitle = (String) getGroupSub(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.award_scheme_list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.award_scheme_list_group_title);
        TextView lblListSubHeader = (TextView) convertView
                .findViewById(R.id.award_scheme_list_group_subtitle);
        ImageView image = (ImageView) convertView
                .findViewById(R.id.award_scheme_list_group_image);
        TextView letter = (TextView) convertView
                .findViewById(R.id.award_scheme_list_group_image_text);
        lblListHeader.setText(headerTitle);
        lblListSubHeader.setText(subHeaderTitle);
        switch (headerTitle) {
            case ("Joey Scouts"):
                image.setImageResource(R.color.joey);
                letter.setText("J");
                break;
            case ("Cub Scouts"):
                image.setImageResource(R.color.cub);
                letter.setText("C");
                break;
            case ("Scouts"):
                image.setImageResource(R.color.scout);
                letter.setText("S");
                break;
            case ("Venturer Scouts"):
                image.setImageResource(R.color.venturer);
                letter.setText("V");
                break;
            case ("Rover Scouts"):
                image.setImageResource(R.color.rover);
                letter.setText("R");
                break;
            default:
                image.setImageResource(R.color.colorPrimary);
                break;
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}