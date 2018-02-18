package com.myregistry.homestore.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.myregistry.homestore.R;
import com.myregistry.homestore.model.Item;
import com.myregistry.homestore.utils.ConstUtils;
import com.myregistry.homestore.utils.PreferenceUtils;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

public class TrendItemdetailActivity extends AncestorActivity {

    TextView textPrice;
    TextView textItemName;
    TextView textItemDescription;
    Item item;
    ImageView imageItem;
    TextView textCustomerReview;
    Button btnAddToCart;
    PreferenceUtils preferenceUtils;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAddToCart:
                    //Make a service or other logic for add to cart.. this is static implementation only
                    EventBus.getDefault().post(new AddToCart());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_itemdetail);
        Bundle extras = getIntent().getExtras();
        if (extras == null)
            return;
        item = extras.getParcelable(ConstUtils.TAG_PARCEL_ITEM);
        initControls();
        setDetailsToView();
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initControls() {
        textPrice = (TextView) findViewById(R.id.txt_item_sale_price);
        textItemName = (TextView) findViewById(R.id.txt_item_name);
        textItemDescription = (TextView) findViewById(R.id.txt_description);
        imageItem = (ImageView) findViewById(R.id.item_image);
        textCustomerReview = (TextView) findViewById(R.id.txt_customer_review);
        btnAddToCart = (Button) findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(onClickListener);
    }

    private void setDetailsToView() {
        textPrice.setText("$ " + item.getSalePrice());
        textItemName.setText(item.getName());
        Picasso.with(this).load(item.getLargeImage()).into(imageItem);
        textCustomerReview.setText("Review (" + item.getNumReviews() + ")");
        textItemDescription.setText(Html.fromHtml("\n" + item.getLongDescription()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}