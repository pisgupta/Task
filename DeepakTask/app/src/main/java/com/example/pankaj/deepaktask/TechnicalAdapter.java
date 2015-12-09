package com.example.pankaj.deepaktask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Pankaj on 12/9/2015.
 */
public class TechnicalAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context mContext;
    ArrayList<TechnicalBean> beens;

    public TechnicalAdapter(Context mContext, ArrayList<TechnicalBean> beens) {
        this.mContext = mContext;
        this.beens = beens;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return beens.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.layout_adapter, parent, false);
            viewHolder.skil = (Spinner) convertView.findViewById(R.id.sp_skilname);
            viewHolder.performance = (Spinner) convertView.findViewById(R.id.sp_performance);
            viewHolder.delete = (ImageView) convertView.findViewById(R.id.btndelete);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beens.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    ViewHolder viewHolder;

    class ViewHolder {
        Spinner skil, performance;
        ImageView delete;
    }
}
