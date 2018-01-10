package com.jaja.material.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaja.material.R;
import com.jaja.material.model.BackColorSelect;

import java.util.List;

/**
 * Created by ${Terry} on 2018/1/10.
 */
public class MenuAdapter extends BaseListAdapter<BackColorSelect> {

    private List<BackColorSelect> list;
    private Context mContext;

    public MenuAdapter(Context context, List<BackColorSelect> list) {
        super(context, list);
        this.list = list;
        this.mContext = context;
    }

    @Override
    public View initView(BackColorSelect backColorSelect, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
            convertView = mInflater.inflate(R.layout.act_menu_item, null);
            holder = new ViewHolder();
            holder.itemView = (TextView) convertView.findViewById(R.id.item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemView.setText(backColorSelect.getColor().toString());
        return convertView;
    }

    public class ViewHolder {
        TextView itemView;
    }

}
