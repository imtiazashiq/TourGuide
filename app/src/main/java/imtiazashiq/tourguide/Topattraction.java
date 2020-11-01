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

public class Topattraction extends Fragment {


    public Topattraction() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);
        //populate Arraylist//
        final ArrayList<item> words = new ArrayList<item>();
        words.add(new item(getString(R.string.wagah_name),getString(R.string.wagah_address),getString(R.string.wagah_buildby),R.drawable.wagah,getString(R.string.wagah_history)));
        words.add(new item(getString(R.string.museum_name),getString(R.string.museum_address),getString(R.string.museum_buildby),R.drawable.armymuesum,getString(R.string.museum_history)));
        words.add(new item(getString(R.string.shalimar_name),getString(R.string.shalimar_address),getString(R.string.shalimar_buildby),R.drawable.shalimar,getString(R.string.shalimar_history)));
        words.add(new item(getString(R.string.zoo_name),getString(R.string.zoo_address),getString(R.string.zoo_buidby),R.drawable.zoo,getString(R.string.zoo_history)));
        words.add(new item(getString(R.string.tower_name),getString(R.string.tower_address),getString(R.string.tower_buildby),R.drawable.eiffel,getString(R.string.tower_history)));
        words.add(new item(getString(R.string.tomb_name),getString(R.string.tomb_address),getString(R.string.tomb_buildby),R.drawable.datadarbar,getString(R.string.tomb_history)));


        itemAdapter adapter = new itemAdapter(getActivity(),words);


        // word_list.xml layout file.
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

                //send intent//
                intent.putExtra("title",itempostion.getmTitle());
                intent.putExtra("over",itempostion.getmOverview());
                intent.putExtra("description",itempostion.getmLocation());

                // Send Image to other Activity//
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