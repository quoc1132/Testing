package uit.quocnguyen.tikitesting.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import uit.quocnguyen.tikitesting.R;
import uit.quocnguyen.tikitesting.models.UtilityServiceItem;

public class HomeUtilityServiceAdapter extends RecyclerView.Adapter<HomeUtilityServiceAdapter.HomeUtilityServiceViewHolder> {

    private List<UtilityServiceItem> mUtilityServiceItems;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public HomeUtilityServiceAdapter(List<UtilityServiceItem> mUtilityServiceItems, Context mContext) {
        this.mUtilityServiceItems = mUtilityServiceItems;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public HomeUtilityServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.utility_service_item, viewGroup, false);
        return new HomeUtilityServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeUtilityServiceViewHolder homeUtilityServiceViewHolder, int i) {
        homeUtilityServiceViewHolder.titleTextView.setText(mUtilityServiceItems.get(i).getName());
        homeUtilityServiceViewHolder.iconImageView.setImageResource(mUtilityServiceItems.get(i).getmIconResource());
    }

    @Override
    public int getItemCount() {
        return mUtilityServiceItems.size();
    }

    class HomeUtilityServiceViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView iconImageView;

        public HomeUtilityServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.utility_service_text_view_title);
            iconImageView = itemView.findViewById(R.id.utility_service_text_view_icon);
        }
    }
}
