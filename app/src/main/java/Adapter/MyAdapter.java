package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.recyclerviewpractice.R;
import com.sahil.recyclerviewpractice.SecondActivity;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<ListItem> list_items;

    public MyAdapter(Context context, List<ListItem> list_items) {
        this.context = context;
        this.list_items = list_items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem list_item = list_items.get(position);
        holder.setDescription(list_item.getDescription());
        holder.setTitle(list_item.getTitle());
    }

    @Override
    public int getItemCount() {
        return list_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
        public void setDescription(String description) {
            this.description.setText(description);
        }
        public void setTitle(String title) {
            this.title.setText(title);
        }

        @Override
        public void onClick(View v) {
            ListItem list_item = list_items.get(getAdapterPosition());
            Intent intent = new Intent(context, SecondActivity.class)
                    .putExtra("title", list_item.getTitle());
            context.startActivity(intent);
        }
    }
}
