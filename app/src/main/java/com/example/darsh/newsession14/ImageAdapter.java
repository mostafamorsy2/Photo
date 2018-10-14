package com.example.darsh.newsession14;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    Bundle setimage=new Bundle();
    public Context context;
    private List<ImageModel> mList;

    public ImageAdapter(Context context, List<ImageModel> mList) {
        this.context = context;
        this.mList = mList;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
        }
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image,viewGroup,false);
        return new ImageViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        final ImageModel model = mList.get(i);
        imageViewHolder.img.setImageResource(model.getImg());
        imageViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShowImage.class);
                setimage.putInt("img",model.getImg());
                intent.putExtras(setimage);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}
