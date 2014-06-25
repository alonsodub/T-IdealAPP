package com.code.t_idealapp.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class NavAdapter extends BaseAdapter {

    public static class Fila {
        TextView item;
        ImageView icon;
    }
    private Activity activity;
    ArrayList<Item> arrayitems;
    public NavAdapter(Activity activity, ArrayList<Item> listItems) {
        super();
        this.activity = activity;
        this.arrayitems = listItems;
    }

    @Override
    public int getCount() {
        return arrayitems.size();
    }
    @Override
    public Object getItem(int i) {
        return arrayitems.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View Mainview, ViewGroup parent) {
        Fila view;
        LayoutInflater inflater = activity.getLayoutInflater();
        if (Mainview == null) {
            view = new Fila();
            Item itm = arrayitems.get(i);
            Mainview = inflater.inflate(R.layout.list_items, null);
            view.item = (TextView) Mainview.findViewById(R.id.title_item);
            view.item.setText(itm.getTitulo());
            view.icon = (ImageView) Mainview.findViewById(R.id.icon);
            view.icon.setImageResource(itm.getIcono());
            Mainview.setTag(view);
        } else {
            view = (Fila) Mainview.getTag();}
            return Mainview;
    }
}
