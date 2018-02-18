package com.myregistry.homestore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myregistry.homestore.R;
import com.myregistry.homestore.model.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nidhi parekh.
 */

public class RecyclerTrendItemAdapter extends RecyclerView.Adapter<RecyclerTrendItemAdapter.ItemViewHolder> {

    ArrayList<Item> responseArrayList;
    Context context;
    private RecyclerViewClickListener mListener;

    public RecyclerTrendItemAdapter(Context context, RecyclerViewClickListener listener) {
        this.context = context;
        responseArrayList = new ArrayList<Item>();
        mListener = listener;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_row_items, null);
        return new ItemViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.textItemName.setText(responseArrayList.get(position).getName());
        holder.textItemPrice.setText("$ " + responseArrayList.get(position).getSalePrice());
        Picasso.with(context).load(responseArrayList.get(position).getMediumImage()).noFade().into(holder.imageThumb);
    }

    public void setItems(ArrayList<Item> items) {
        responseArrayList.clear();
        responseArrayList.addAll(items);
        notifyDataSetChanged();
    }

    public Item getClickedItem(int position) {
        return responseArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return responseArrayList.size();
    }

    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textItemPrice;
        TextView textItemName;
        ImageView imageThumb;
        RecyclerViewClickListener listener;

        public ItemViewHolder(View itemView, RecyclerViewClickListener mListener) {
            super(itemView);
            textItemPrice = itemView.findViewById(R.id.txt_item_price);
            textItemName = itemView.findViewById(R.id.txt_item_name);
            imageThumb = itemView.findViewById(R.id.img_item_thumb);
            listener = mListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
}
