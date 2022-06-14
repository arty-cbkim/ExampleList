package com.example.examplelist.multiImagerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.examplelist.R;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {

    ArrayList<String> parentArrayList;
    Context context;

    public ParentAdapter(ArrayList<String> parentArrayList, Context context) {
        this.parentArrayList = parentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.parent_item_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ViewHolder holder, int position) {
        holder.tvParentId.setText(parentArrayList.get(position));

        int[] images = {
                R.drawable.image_1
                , R.drawable.image_2
                , R.drawable.image_3
                , R.drawable.image_4
                , R.drawable.image_5};
        
        ChildAdapter child = new ChildAdapter(images);

        holder.viewPager2.setOrientation(holder.viewPager2.ORIENTATION_HORIZONTAL);
        holder.viewPager2.setAdapter(child);
    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvParentId;
        ViewPager2 viewPager2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvParentId = itemView.findViewById(R.id.tv_parent_id);
            viewPager2 = itemView.findViewById(R.id.viewPager2);


        }
    }
}
