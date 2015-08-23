package ru.quect.sweetdiary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

import ru.quect.sweetdiary.models.DiaryEntry;

public class DiaryFragment extends Fragment {
    private RecyclerView mDiaryList;
    private DiaryAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_diary, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDiaryList = (RecyclerView) view.findViewById(R.id.diary_list);
        mDiaryList.setHasFixedSize(true);
        mDiaryList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDiaryList.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        ArrayList<DiaryEntry> dataset = new ArrayList<>(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DiaryEntry entry = new DiaryEntry(random.nextDouble() * 10);
            dataset.add(entry);
        }
        mAdapter = new DiaryAdapter(getActivity(), dataset);
        mDiaryList.setAdapter(mAdapter);
    }
}
