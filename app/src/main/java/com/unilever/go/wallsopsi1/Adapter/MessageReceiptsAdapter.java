package com.unilever.go.wallsopsi1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cometchat.pro.models.MessageReceipt;
import com.unilever.go.wallsopsi1.CustomView.CircleImageView;
import com.unilever.go.wallsopsi1.R;
import com.unilever.go.wallsopsi1.Utils.DateUtils;

import java.util.List;

public class MessageReceiptsAdapter extends RecyclerView.Adapter<MessageReceiptsAdapter.ReceiptsHolder> {

    private Context context;

    private List<MessageReceipt> messageReceiptList;

    public MessageReceiptsAdapter(Context context, List<MessageReceipt> messageReceiptList) {
        this.context = context;
        this.messageReceiptList = messageReceiptList;
    }


    @NonNull
    @Override
    public ReceiptsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ReceiptsHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.receipts_view,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptsHolder receiptsHolder, int i) {
         MessageReceipt messageReceipt=messageReceiptList.get(i);

         receiptsHolder.tvRead.setText("Read At:"+DateUtils.getTimeStringFromTimestamp(messageReceipt.getReadAt(), "hh:mm a"));
         receiptsHolder.tvDelivery.setText("Delivered At:"+DateUtils.getTimeStringFromTimestamp(messageReceipt.getDeliveredAt(), "hh:mm a"));

         Glide.with(context).load(messageReceipt.getSender().getAvatar()).into(receiptsHolder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return messageReceiptList.size();
    }

    class ReceiptsHolder extends RecyclerView.ViewHolder {

        TextView tvDelivery;

        TextView tvRead;

         CircleImageView ivAvatar;

         ReceiptsHolder(@NonNull View itemView) {
            super(itemView);

            tvDelivery=itemView.findViewById(R.id.tvDelivery);
            tvRead=itemView.findViewById(R.id.tvRead);
            ivAvatar=itemView.findViewById(R.id.ivAvatar);
        }
    }
}
