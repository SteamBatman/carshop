package com.example.carshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CartAdapter extends ArrayAdapter<Car> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<Car> productList;

    CartAdapter(Context context, int resource, ArrayList<Car> products) {
        super(context, resource, products);
        this.productList = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        Car state = productList.get(position);
        TextView textView1 = view.findViewById(R.id.descriptionView);
        ImageView flagView = view.findViewById(R.id.photo);
        textView1.setText(state.getDescription());
        flagView.setImageResource(state.getCarResource());

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Car product = productList.get(position);

        viewHolder.nameView.setText(product.getName());
        viewHolder.countView.setText(product.getCount() + " " );
        viewHolder.descriptionView.setText(product.getDescription());
        viewHolder.photo.setImageResource(product.getCarResource());
        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() - 1;
                if (count < 0) count = 0;
                product.setCount(count);
                viewHolder.countView.setText(count + " " );
            }
        });
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = product.getCount() + 1;
                product.setCount(count);
                viewHolder.countView.setText(count + " " );
            }
        });

        return convertView;
    }

    private class ViewHolder {
        final Button addButton, removeButton;
        final TextView nameView, countView, descriptionView;
        final ImageView photo;
        ViewHolder(View view) {
            addButton = view.findViewById(R.id.addButton);
            removeButton = view.findViewById(R.id.removeButton);
            nameView = view.findViewById(R.id.nameView);
            countView = view.findViewById(R.id.countView);
            descriptionView = view.findViewById(R.id.descriptionView);
            photo = view.findViewById(R.id.photo);
        }
    }


}
