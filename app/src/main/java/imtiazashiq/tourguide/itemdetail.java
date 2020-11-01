package imtiazashiq.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class itemdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetail);

        ImageView imageView=(ImageView)findViewById(R.id.item_image);

        TextView texttitle=(TextView)findViewById(R.id.item_title);

        TextView textlocation=(TextView)findViewById(R.id.item_location);

        TextView textoverview=(TextView)findViewById(R.id.overview);


        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        imageView.setImageResource(pic);



        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        texttitle.setText(title);


        String overview = intent.getStringExtra("over");
        textoverview.setText(overview);

        String location = intent.getStringExtra("description");
        textlocation.setText(location);








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    //Change the behavior for Up-button to act as Back-button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }


}
