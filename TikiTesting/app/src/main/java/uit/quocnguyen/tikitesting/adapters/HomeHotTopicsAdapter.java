package uit.quocnguyen.tikitesting.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import uit.quocnguyen.tikitesting.R;
import uit.quocnguyen.tikitesting.commons.Utils;

public class HomeHotTopicsAdapter extends RecyclerView.Adapter<HomeHotTopicsAdapter.HomeHotTopicsViewHolder> {

    private List<String> mHotTopics;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private Random mRandom;

    public HomeHotTopicsAdapter(List<String> mHotTopics, Context mContext) {
        this.mHotTopics = mHotTopics;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        mRandom = new Random();
    }

    @NonNull
    @Override
    public HomeHotTopicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.hot_topics_item, viewGroup, false);
        return new HomeHotTopicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHotTopicsViewHolder homeHotTopicsViewHolder, int i) {
        homeHotTopicsViewHolder.hotTopicsTextView.setText(Utils.getTextWithTwoLineWithMinimunWidth(homeHotTopicsViewHolder.hotTopicsTextView,mHotTopics.get(i)));

        int colorCase = mRandom.nextInt(8);
        switch (colorCase) {
            case 0:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_red_700));
                break;
            case 1:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_blue_700));
                break;
            case 2:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_green_700));
                break;
            case 3:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_yellow_700));
                break;
            case 4:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_purple_700));
                break;
            case 5:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_grey_700));
                break;
            case 6:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_brown_700));
                break;
            case 7:
                homeHotTopicsViewHolder.hotTopicsCardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.md_orange_700));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mHotTopics.size();
    }

    class HomeHotTopicsViewHolder extends RecyclerView.ViewHolder {

        TextView hotTopicsTextView;
        CardView hotTopicsCardView;

        public HomeHotTopicsViewHolder(@NonNull View itemView) {
            super(itemView);

            hotTopicsTextView = itemView.findViewById(R.id.hot_topics_item_text_view);
            hotTopicsCardView = itemView.findViewById(R.id.hot_topics_item_card_view);
        }
    }
}
