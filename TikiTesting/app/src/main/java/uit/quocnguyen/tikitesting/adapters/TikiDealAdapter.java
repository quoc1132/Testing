package uit.quocnguyen.tikitesting.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import uit.quocnguyen.tikitesting.R;

public class TikiDealAdapter extends RecyclerView.Adapter<TikiDealAdapter.TikiDealViewHolder> {


    private List<Integer> mTikiDealResounceIds;
    private LayoutInflater mLayoutInflater;
    private Context mContext;


    public TikiDealAdapter(List<Integer> mTikiDealResounceIds, Context mContext) {
        this.mTikiDealResounceIds = mTikiDealResounceIds;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public TikiDealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.tiki_deal_item, viewGroup, false);
        return new TikiDealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TikiDealViewHolder tikiDealViewHolder, int i) {
        tikiDealViewHolder.tikiDealImageView.setImageResource(mTikiDealResounceIds.get(i));
    }

    @Override
    public int getItemCount() {
        return mTikiDealResounceIds.size();
    }

    class TikiDealViewHolder extends RecyclerView.ViewHolder {

        ImageView tikiDealImageView;

        public TikiDealViewHolder(@NonNull View itemView) {
            super(itemView);
            tikiDealImageView = itemView.findViewById(R.id.tiki_deal_item);
        }
    }
}
