package ru.amtrend.mvvmretrofitdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import ru.amtrend.mvvmretrofitdemo.R;
import ru.amtrend.mvvmretrofitdemo.databinding.ResultListItemBinding;
import ru.amtrend.mvvmretrofitdemo.model.Result;
import ru.amtrend.mvvmretrofitdemo.view.MovieDetailsActivity;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder>{

    private Context context;
    private ArrayList<Result> results;

    public ResultAdapter(Context context, ArrayList<Result> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ResultListItemBinding resultListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.result_list_item, parent, false);

        return new ResultViewHolder(resultListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {

        Result result = results.get(position);

        holder.resultListItemBinding.setResult(result);

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {

        private ResultListItemBinding resultListItemBinding;

        public ResultViewHolder(@NonNull ResultListItemBinding resultListItemBinding) {
            super(resultListItemBinding.getRoot());
            this.resultListItemBinding = resultListItemBinding;

            resultListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Result result = results.get(position);
                        Intent intent = new Intent(context, MovieDetailsActivity.class);
                        intent.putExtra("movieData", result);
                        context.startActivity(intent);
                    }

                }
            });

        }
    }
}
