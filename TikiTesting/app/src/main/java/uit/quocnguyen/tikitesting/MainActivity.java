package uit.quocnguyen.tikitesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uit.quocnguyen.tikitesting.adapters.HomeHotTopicsAdapter;
import uit.quocnguyen.tikitesting.adapters.HomeTopicsAdapter;
import uit.quocnguyen.tikitesting.adapters.HomeUtilityServiceAdapter;
import uit.quocnguyen.tikitesting.adapters.TikiDealAdapter;
import uit.quocnguyen.tikitesting.models.UtilityServiceItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mHomeRecyclerViewTopics;
    private HomeTopicsAdapter mHomeTopicsAdapter;
    private List<String> mTopics;


    private RecyclerView mHomeRecyclerViewUtilityService;
    private List<UtilityServiceItem> mUtilityServiceItems;
    private HomeUtilityServiceAdapter mHomeUtilityServiceAdapter;


    private RecyclerView mHomeRecyclerViewHotTopics;
    private List<String> mHotTopics;
    private HomeHotTopicsAdapter mHomeHotTopicsAdapter;


    private RecyclerView mHomeRecyclerViewTikiDeal;
    private List<Integer> mTikiDeals;
    private TikiDealAdapter mTikiDealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHomeRecyclerViewTopics = findViewById(R.id.home_recycler_view_topics);
        mTopics = Arrays.asList(getResources().getStringArray(R.array.topics_arr));
        mHomeTopicsAdapter = new HomeTopicsAdapter(mTopics,this);
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mHomeRecyclerViewTopics.setLayoutManager(layoutManager1);
        mHomeRecyclerViewTopics.setAdapter(mHomeTopicsAdapter);


        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mHomeRecyclerViewUtilityService = findViewById(R.id.home_recycler_view_utility_service);
        mHomeRecyclerViewUtilityService.setLayoutManager(layoutManager2);
        mUtilityServiceItems = new ArrayList<>();
        mUtilityServiceItems.add(new UtilityServiceItem("Vé Máy Bay",R.drawable.airplane));
        mUtilityServiceItems.add(new UtilityServiceItem("Mua Bảo Hiểm \nOnline",R.drawable.security));
        mUtilityServiceItems.add(new UtilityServiceItem("Mua Thẻ Điện \nThoại",R.drawable.credit_card));
        mUtilityServiceItems.add(new UtilityServiceItem("Mua Thẻ Game",R.drawable.gamepad_variant));

        mHomeUtilityServiceAdapter = new HomeUtilityServiceAdapter(mUtilityServiceItems,this);
        mHomeRecyclerViewUtilityService.setAdapter(mHomeUtilityServiceAdapter);


        mHotTopics = new ArrayList<>();

        try
        {
            String jsonLocation = loadJSONFromAsset();
            JSONArray jarray = new JSONArray(jsonLocation);
            for(int i=0;i<jarray.length();i++)
            {
                String jb =(String) jarray.get(i);
                mHotTopics.add(jb);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayoutManager layoutManager3
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        mHomeRecyclerViewHotTopics = findViewById(R.id.home_recycler_view_hot_topics);
        mHomeRecyclerViewHotTopics.setLayoutManager(layoutManager3);
        mHomeHotTopicsAdapter = new HomeHotTopicsAdapter(mHotTopics,this);
        mHomeRecyclerViewHotTopics.setAdapter(mHomeHotTopicsAdapter);


        mHomeRecyclerViewTikiDeal = findViewById(R.id.home_recycler_view_tiki_deal);
        mTikiDeals = new ArrayList<>();
        mTikiDeals.add(R.drawable.tiki_deal_1);
        mTikiDeals.add(R.drawable.tiki_deal_2);
        mTikiDealAdapter = new TikiDealAdapter(mTikiDeals, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mHomeRecyclerViewTikiDeal.setLayoutManager(gridLayoutManager);
        mHomeRecyclerViewTikiDeal.setAdapter(mTikiDealAdapter);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("keywords.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
