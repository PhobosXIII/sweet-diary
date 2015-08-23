package ru.quect.sweetdiary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.quect.sweetdiary.models.DiaryEntry;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {
    private List<DiaryEntry> mDiaryEntries;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private Context mContext;

    public DiaryAdapter(Context context, List<DiaryEntry> diaryEntries) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mDiaryEntries = diaryEntries;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_list_diary, viewGroup, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final DiaryEntry diaryEntry = mDiaryEntries.get(position);
        final String glucose = Utils.formatGlucose(mContext, diaryEntry.getGlucose());
        viewHolder.tvGlucose.setText(glucose);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, glucose, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDiaryEntries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final View view;
        final TextView tvGlucose;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvGlucose = (TextView) itemView.findViewById(R.id.tv_glucose);
        }
    }
}
