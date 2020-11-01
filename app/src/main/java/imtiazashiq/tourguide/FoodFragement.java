package imtiazashiq.tourguide;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class FoodFragement extends Fragment {


    public FoodFragement() {
        // Required empty public constructor //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        //populate the array list//
        final ArrayList<item> words = new ArrayList<item>();
        words.add(new item(getString(R.string.Haveli_name),getString(R.string.description),getString(R.string.website),R.drawable.haveli,getString(R.string.h_overview)));
        words.add(new item(getString(R.string.veera_name),getString(R.string.veera_description),getString(R.string.veera_website),R.drawable.veera,getString(R.string.veera_overview)));
        words.add(new item(getString(R.string.monal_name),getString(R.string.monal_description),getString(R.string.monal_website),R.drawable.monal,getString(R.string.monal_overview)));
        words.add(new item(getString(R.string.bundu_name),getString(R.string.bundu_description),getString(R.string.bundu_website),R.drawable.bundu,getString(R.string.bundu_overview)));
        words.add(new item(getString(R.string.Arcade_name),getString(R.string.Arcade_description),getString(R.string.Arcade_website),R.drawable.arcadian,getString(R.string.Arcade_overview)));
        words.add(new item(getString(R.string.qabail_name),getString(R.string.qabail_description),getString(R.string.qabail_website),R.drawable.qabail,getString(R.string.qabail_overview)));


        itemAdapter adapter = new itemAdapter(getActivity(),words);


        // word_list.xml layout file//
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get the position//
                item itempostion=words.get(position);

                //Intialize intent//
                final Intent intent;
                intent = new Intent(getContext(), itemdetail.class);

                // Send Image to other Activity//
                intent.putExtra("title",itempostion.getmTitle());
                intent.putExtra("over",itempostion.getmOverview());
                intent.putExtra("description",itempostion.getmLocation());

                //Send Image to other Activity//
                Bundle bundle = new Bundle();
                bundle.putInt("image", itempostion.getImageResource());
                intent.putExtras(bundle);

                //Start the intent
                startActivity(intent);
            }
        });

        return rootView;
    }
}

