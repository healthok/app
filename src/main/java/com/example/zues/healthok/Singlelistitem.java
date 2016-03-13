package com.example.zues.healthok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Kullu Garima Manali on 13-Mar-16.
 */
public class Singlelistitem extends Activity {





    public class SingleListItem extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.single_list_item_view);

            TextView txtProduct = (TextView) findViewById(R.id.product_label);

            Intent i = getIntent();
            // getting attached intent data
            String product = i.getStringExtra("product");
            // displaying selected product name
            txtProduct.setText(product);

        }
    }
}
