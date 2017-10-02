package com.quantummlabs.android.droidsamples;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nag on 02/10/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {

    private String[] mDataset;
    private ListItemClickListener itemClickListener;
    private LayoutInflater layoutInflater;

    public ListAdapter(String[] myDataset, Context context) {
        mDataset = myDataset;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ListAdapter.Holder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View view = layoutInflater
                .inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.mTextView.setText(mDataset[position]);
        if (itemClickListener != null) {
            holder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public ListItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ListItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    interface ListItemClickListener {
        void onClick(int position);
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public Holder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.listItemTxt);
        }
    }
}