package imtiazashiq.tourguide;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class itemAdapter extends ArrayAdapter<item> {


    static class ViewHolder {
        TextView title;
        TextView location;
        TextView website;
        ImageView image;
    }



    public itemAdapter(FragmentActivity activity, ArrayList<item> words) {
        super(activity, 0, words);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the current view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the position of the item//
        item word1 = getItem(position);

        ViewHolder holder = new ViewHolder();

        //Get the title TextView and set its title value
        holder.title = (TextView) listItemView.findViewById(R.id.title);
        holder.title.setText(word1.getmTitle());

        //Get the location TextView and set its location value
        holder.location = (TextView) listItemView.findViewById(R.id.location);
        holder.location.setText(word1.getmLocation());

        //Get the location TextView and set its location value
        holder.location = (TextView) listItemView.findViewById(R.id.website);
        holder.location.setText(word1.getmWebsite());

        //Get the image ImageView and set its image resource ID
        holder.image = listItemView.findViewById(R.id.image);
        holder.image.setImageResource(word1.getImageResource());


        return listItemView;
    }
}