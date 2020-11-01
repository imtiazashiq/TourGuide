package imtiazashiq.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalPlacesFragement extends Fragment {


    public HistoricalPlacesFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.listview, container, false);

        //populate the array list//
        final ArrayList<item> words = new ArrayList<item>();
        words.add(new item(getString(R.string.fort_name),getString(R.string.fort_address),getString(R.string.fort_owner),R.drawable.fort,getString(R.string.fort_history)));
        words.add(new item(getString(R.string.delhi_name),getString(R.string.delhi_address),getString(R.string.delhi_owner),R.drawable.delhigate,getString(R.string.delhi_history)));
        words.add(new item(getString(R.string.Chauburji_name),getString(R.string.Chauburji_address),getString(R.string.Chauburji_owner),R.drawable.chauburji,getString(R.string.Chauburji_History)));
        words.add(new item(getString(R.string.badshahi_name),getString(R.string.badshahi_address),getString(R.string.badshahi_owner),R.drawable.badshahi,getString(R.string.badshahi_history)));
        words.add(new item(getString(R.string.minar_name),getString(R.string.minar_address),getString(R.string.minar_owner),R.drawable.minarepakistan,getString(R.string.minar_history)));
        words.add(new item(getString(R.string.aitchison_name),getString(R.string.aitchison_address),getString(R.string.aitchison_owner),R.drawable.aitchison,getString(R.string.aitchison_history)));

        itemAdapter adapter = new itemAdapter(getActivity(),words);


        // word_list.xml layout file//
        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get the position//
                item itempostion=words.get(position);
                //intialize intent//
                final Intent intent;

                intent = new Intent(getContext(), itemdetail.class);

                //send intent//
                intent.putExtra("title",itempostion.getmTitle());
                intent.putExtra("description",itempostion.getmLocation());
                intent.putExtra("over",itempostion.getmOverview());

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