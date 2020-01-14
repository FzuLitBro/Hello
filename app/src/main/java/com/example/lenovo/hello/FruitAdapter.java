package com.example.lenovo.hello;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private final Context context;
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(Context context, List<Fruit> fruitList) {
        this.context = context;
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        holder.fruitName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                DetailsActivity.actionStart(context, fruit.getName(), fruit.getMessage());
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        if (position % 2 == 0) {
            holder.fruitName.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
