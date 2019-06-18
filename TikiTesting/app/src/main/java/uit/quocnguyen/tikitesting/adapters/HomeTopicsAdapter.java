package uit.quocnguyen.tikitesting.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import uit.quocnguyen.tikitesting.R;

public class HomeTopicsAdapter extends RecyclerView.Adapter<HomeTopicsAdapter.HomeTopicsViewHolder> {

    private List<String> mTopics;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public HomeTopicsAdapter(List<String> mTopics, Context mContext) {
        this.mTopics = mTopics;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public HomeTopicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.topics_item, viewGroup, false);
        return new HomeTopicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeTopicsViewHolder homeTopicsViewHolder, int i) {
        homeTopicsViewHolder.topicsItemTextView.setText(mTopics.get(i));
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    class HomeTopicsViewHolder extends RecyclerView.ViewHolder {
        private TextView topicsItemTextView;

        public HomeTopicsViewHolder(@NonNull View itemView) {
            super(itemView);
            topicsItemTextView = itemView.findViewById(R.id.topics_text_view);
        }
    }
}
