package com.example.carshop;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ArrayList<Car> products = new ArrayList<Car>();
            if(products.size()==0){
                products.add(new Car("Nissan", "Skyline GT-r 35", 0, R.drawable.gtr35));
                products.add(new Car("Honda", "Integra", 0, R.drawable.integra));
                products.add(new Car("Audi", "RS6", 0, R.drawable.audirs6));
                products.add(new Car("Dodge", "Challenger", 0, R.drawable.challenger ));
                products.add(new Car("Porshe", "911", 0, R.drawable.porshe911 ));
            }
            ListView productList = findViewById(R.id.productList);
            CartAdapter adapter = new CartAdapter(this, R.layout.list_item, products);
            productList.setAdapter(adapter);
        }
}