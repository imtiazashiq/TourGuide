package imtiazashiq.tourguide;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Create ViewPager
        ViewPager viewPager = findViewById(R.id.viewpager);

        //Create CategoryAdapter and bind with ViewPager

        Myadapter adapter = new Myadapter(MainActivity.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //Create TabLayout and setup with ViewPager
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);



    }
}
