package com.example.kingofread;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> implements Filterable {
    private ArrayList<Book> mBook;
    private ArrayList<Book> mBookFull;
    private Context mContext;
    ;

    public DataAdapter(Context mContext, ArrayList<Book> mBook) {
        this.mContext = mContext;
        this.mBook = mBook;
        mBookFull = new ArrayList<>(mBook);
    }

    @NonNull
    @Override
    public DataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.tvTitle.setText(mBook.get(position).getTitle());
        myViewHolder.tvDescription.setText(mBook.get(position).getDescriptions());
        myViewHolder.ivCover.setImageResource(mBook.get(position).getCover());
    }


    @Override
    public int getItemCount() {
        return mBook.size();
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    private Filter myFilter = new Filter() { //filer de do ket qua search ra view
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Book> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mBookFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Book item : mBookFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mBook.clear();
            mBook.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        public TextView tvTitle;
        public TextView tvDescription;
        public ImageView ivCover;
        public Button favBtn;
        CardView layoutBook;

        public View View;

        public MyViewHolder(View view) {
            super(view);
            this.view = view;
            tvTitle = this.view.findViewById(R.id.tv_book_title);
            tvDescription = this.view.findViewById(R.id.tv_book_description);
            ivCover = this.view.findViewById(R.id.iv_book_cover);
            favBtn = this.view.findViewById(R.id.fav_btn);
            layoutBook = this.view.findViewById(R.id.cardview_item);


            layoutBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Book book = mBook.get(getAdapterPosition());
                    Toast.makeText(mContext.getApplicationContext(), "You Selected " + book.getTitle(), Toast.LENGTH_SHORT).show();
//                    notifyItemChanged(getAdapterPosition());
                }
            });
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(android.view.View v) {
                    Book book = mBook.get(getAdapterPosition());
                    if(book.getFavStatus()==0) {
                        book.setFavStatus(1);
                        favBtn.setBackgroundResource(R.drawable.ic_fav_added);
                        Toast.makeText(mContext.getApplicationContext(), "You Added " + book.getTitle() + "To Favorite", Toast.LENGTH_SHORT).show();
                    }else {
                        book.setFavStatus(0);
                        favBtn.setBackgroundResource(R.drawable.ic_fav_original);
                        Toast.makeText(mContext.getApplicationContext(), "You Removed " + book.getTitle() + "To Favorite", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
}
