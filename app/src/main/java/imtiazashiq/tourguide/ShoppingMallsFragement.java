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
public class ShoppingMallsFragement extends Fragment {


    public ShoppingMallsFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview, container, false);

        //Populate the ArrayList//
        final ArrayList<item> words = new ArrayList<item>();
        words.add(new item(getString(R.string.emporium_mall),getString(R.string.emporium_address),getString(R.string.emporium_website),R.drawable.emporium,getString(R.string.emporium_overview)));
        words.add(new item(getString(R.string.package_name),getString(R.string.package_address),getString(R.string.package_address),R.drawable.packages,getString(R.string.package_overview)));
        words.add(new item(getString(R.string.monal_name),getString(R.string.mall_address),getString(R.string.mall_website),R.drawable.malloflahore,getString(R.string.mall_overview)));
        words.add(new item(getString(R.string.fortress_name),getString(R.string.fortress_address),getString(R.string.fortress_website),R.drawable.fortress,getString(R.string.fortress_overview)));
        words.add(new item(getString(R.string.liberty_name),getString(R.string.liberty_address),getString(R.string.liberty_website),R.drawable.liberty,getString(R.string.liberty_overview)));
        words.add(new item(getString(R.string.amanah_name),getString(R.string.amanah_address),getString(R.string.amanah_website),R.drawable.amanah,getString(R.string.amanah_overview)));


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

                // Send Image to other Activity//
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

