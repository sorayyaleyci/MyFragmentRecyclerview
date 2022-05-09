package com.sorayya.myfragmentrecyclerview;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private final List<DataModel> list;
    private final ItemClicklistener clicklistener;
    public RecyclerviewAdapter(List<DataModel> list,ItemClicklistener clicklistener){
        this.list=list;
        this.clicklistener=clicklistener;
    }
    @NonNull
    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.MyViewHolder holder, int position) {
         holder.titleTextView.setText(list.get(position).getTitle());
         holder.imageView.setImageDrawable(list.get(position).getDrawable());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 clicklistener.onItemClick(list.get(position));

             }
         });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView=itemView.findViewById(R.id.titleTextView);
            imageView=itemView.findViewById(R.id.titleImageView);
        }
    }
    public interface ItemClicklistener{
        void onItemClick(DataModel dataModel);
    }


}
