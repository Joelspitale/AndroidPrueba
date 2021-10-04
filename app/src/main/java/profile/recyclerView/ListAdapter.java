package profile.recyclerView;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity4;
import com.example.myapplication.R;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ProfileListViewHolder>{

    private List<Profile> data;
    private  RecyclerViewOnClickListener listener;


    public ListAdapter(List<Profile> data, RecyclerViewOnClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProfileListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_profile, parent, false);
        return new ProfileListViewHolder(row,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileListViewHolder holder, int position) {
        Profile profile = data.get(position);
        holder.getTitleTextView().setText(profile.getName());
        holder.getSubtitleTextView().setText(profile.gethexa());
/*
        GradientDrawable gradientDrawable = (GradientDrawable) holder.getCircleView().getBackground();
        int colorId = android.graphics.Color.parseColor(profile.gethexa());
        gradientDrawable.setColor(colorId);*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public  class ProfileListViewHolder extends RecyclerView.ViewHolder {
        private View circleView;
        private TextView titleTextView;
        private TextView subtitleTextView;

        public ProfileListViewHolder(@NonNull View itemView, RecyclerViewOnClickListener listener) {
            super(itemView);
            circleView = itemView.findViewById(R.id.profile_circle_view);
            titleTextView = (TextView) itemView.findViewById(R.id.text_view_profile_name);
            subtitleTextView = (TextView) itemView.findViewById(R.id.text_view_profile_hexa);
            itemView.setOnClickListener(listener.onItemClick(getAdapterPosition()));
        }

        public View getCircleView() {
            return circleView;
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public TextView getSubtitleTextView() {
            return subtitleTextView;
        }
    }
}


