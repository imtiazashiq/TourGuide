package imtiazashiq.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;


public class Myadapter extends FragmentPagerAdapter {
    //Create global vars
    private Context thisContext;
    private int currentPos = -1;

    //Create CategoryAdapter constructor
    public Myadapter(Context context, FragmentManager fm) {
        super(fm);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.commit();

        thisContext = context;
    }

    //Override getItem method
    @Override
    public Fragment getItem(int position) {
        //Setup Fragment
        if (position == 0) { //If pos:0, create TourFragment
            currentPos = 0;
            return new FoodFragement();
        } else if (position == 1) { //If pos:1, create FoodFragment
            currentPos = 1;
            return new ShoppingMallsFragement();
        } else if (position == 2) { //If pos:2, create HotelFragment
            currentPos = 2;
            return new HistoricalPlacesFragement();
        } else { //If pos:3, create MustSeeFragment
            currentPos = 3;
            return new Topattraction();
        }
    }

    //Override getCount method and return total of 4 (fragments)
    @Override
    public int getCount() {
        return 4;
    }

    //Override getPageTitle method
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) { //When pos:0, return City Tour title
            return "Food";
        } else if (position == 1) { //When pos:1, return Food title
            return "Shopping Malls";
        } else if (position == 2) { //When pos:2, return Hotel title
            return "Historical Places";
        } else if (position == 3) { //When pos:3, return MustSee title
            return "Top Attra-ction";
        } else {
            return "";
        }
    }

}
