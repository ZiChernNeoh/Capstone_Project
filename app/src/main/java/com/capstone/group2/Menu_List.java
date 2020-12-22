package com.capstone.group2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.capstone.group2.Interface.ItemClickListener;
import com.capstone.group2.Model.Food;
import com.capstone.group2.Service.ListenOrder;
import com.capstone.group2.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Menu_List extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase db;
    DatabaseReference foodList;

    FirebaseRecyclerAdapter<Food, MenuViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__list);

        //Firebase
        db = FirebaseDatabase.getInstance();
        foodList = db.getReference("Category");

        recyclerView = (RecyclerView) findViewById(R.id.recyclermenu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadListMenu();

        Intent service = new Intent(Menu_List.this, ListenOrder.class);
        startService(service);
    }

    private void loadListMenu() {
        adapter = new FirebaseRecyclerAdapter<Food, MenuViewHolder>(Food.class,
                R.layout.menu_item,
                MenuViewHolder.class,
                foodList.orderByChild("Name")) {
            @Override
            protected void populateViewHolder(MenuViewHolder menuViewHolder, Food food, int i) {
                menuViewHolder.txtMenuName.setText(food.getName());
                Picasso.with(getBaseContext()).load(food.getImage()).into(menuViewHolder.imageView);

                final Food local = food;
                menuViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //start new activity
                        Intent foodDetail = new Intent(Menu_List.this, FoodDetail.class);
                        foodDetail.putExtra("Name", adapter.getRef(position).getKey());
                        startActivity(foodDetail);
                    }
                });
            }
        };
        //set adapter
        recyclerView.setAdapter(adapter);
    }
}