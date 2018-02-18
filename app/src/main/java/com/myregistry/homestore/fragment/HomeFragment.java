package com.myregistry.homestore.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.myregistry.homestore.R;
import com.myregistry.homestore.activity.TrendItemdetailActivity;
import com.myregistry.homestore.adapter.RecyclerTrendItemAdapter;
import com.myregistry.homestore.model.GetTrendItems;
import com.myregistry.homestore.model.Item;
import com.myregistry.homestore.retrofit.RetroClient;
import com.myregistry.homestore.utils.ConstUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nidhiparekh.
 */

public class HomeFragment extends Fragment {

    RecyclerView recyclerViewItems;
    RecyclerTrendItemAdapter recyclerAdapter;
    AppCompatSpinner spinnerFilter;
    ArrayList<Item> itemArrayList;
    private RecyclerTrendItemAdapter.RecyclerViewClickListener listener = new RecyclerTrendItemAdapter.RecyclerViewClickListener() {
        @Override
        public void onClick(View view, int position) {
            Intent itemDetail = new Intent(getActivity(), TrendItemdetailActivity.class);
            Bundle b = new Bundle();
            itemDetail.putExtra(ConstUtils.TAG_PARCEL_ITEM, itemArrayList.get(position));
            startActivity(itemDetail);
        }
    };
    private AdapterView.OnItemSelectedListener onSpinnerItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0)
                return;
            else if (position == FilterType.NAME.intValue) {
                filterByName();
            } else if (position == FilterType.PRICE.intValue) {
                filterByPrice();
            } else if (position == FilterType.CUSTOMER_REVIEW.intValue) {
                filterByCustomerReview();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initControls(view);
        return view;
    }

    private void initControls(View view) {
        itemArrayList = new ArrayList<Item>();
        recyclerViewItems = (RecyclerView) view.findViewById(R.id.recycler_view_trend);
        spinnerFilter = (AppCompatSpinner) view.findViewById(R.id.spinner_filter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.filter_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);// Apply the adapter to the spinner
        spinnerFilter.setAdapter(adapter);
        recyclerAdapter = new RecyclerTrendItemAdapter(getActivity(), listener);
        recyclerViewItems.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerViewItems.setAdapter(recyclerAdapter);
        spinnerFilter.setOnItemSelectedListener(onSpinnerItemSelected);
        getTrendingItems();
    }

    private void getTrendingItems() {
        Call<GetTrendItems> getTrendingItems = RetroClient.getServiceApis().getTrendListing(ConstUtils.format, ConstUtils.API_kEY);
        getTrendingItems.enqueue(new Callback<GetTrendItems>() {
            @Override
            public void onResponse(Call<GetTrendItems> call, final Response<GetTrendItems> response) {

                if (response != null && response.body() != null) {
                    if (response.body().getItems().size() == 0) {
                        return;
                    }
                    itemArrayList.addAll(response.body().getItems());
                    recyclerAdapter.setItems(itemArrayList);
                } else {
                    EventBus.getDefault().postSticky(new PromptMessageShow(getString(R.string.server_connectivity_issue)));
                }
            }

            @Override
            public void onFailure(Call<GetTrendItems> call, Throwable t) {
                EventBus.getDefault().postSticky(new PromptMessageShow(getString(R.string.server_connectivity_issue)));
            }
        });
    }

    private void filterByName() {
        Collections.sort(itemArrayList, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                // TODO Auto-generated method stub
                return item1.getName().compareToIgnoreCase(item2.getName());
            }
        });
        recyclerAdapter.setItems(itemArrayList);
    }

    private void filterByPrice() {
        Collections.sort(itemArrayList, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Double.compare(item1.getSalePrice(), item2.getSalePrice());
            }
        });
        recyclerAdapter.setItems(itemArrayList);
    }

    private void filterByCustomerReview() {
        Collections.sort(itemArrayList, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getNumReviews(), item2.getNumReviews());
            }
        });
        recyclerAdapter.setItems(itemArrayList);
    }

    public enum FilterType {

        NAME("name", 1),
        PRICE("price", 2),
        CUSTOMER_REVIEW("customer_review", 3);

        private String stringValue;
        private int intValue;

        FilterType(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        @Override
        public String toString() {
            return stringValue;
        }

    }

    public class PromptMessageShow {
        public String message;

        public PromptMessageShow(String message) {
            this.message = message;
        }
    }

}
