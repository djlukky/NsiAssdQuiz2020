package nsi.assd.exam.nsiassdquiz2020.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import java.util.List;

import nsi.assd.exam.nsiassdquiz2020.Activity.NoteQuestionActivity;
import nsi.assd.exam.nsiassdquiz2020.Activity.QuestionActivity;
import nsi.assd.exam.nsiassdquiz2020.R;

public class NoteGridAdapter extends BaseAdapter {
    public List<String> sets;
    private String category;

    public NoteGridAdapter(List<String> sets, String category) {
        this.sets = sets;
        this.category = category;
    }

    @Override
    public int getCount() {
        return sets.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_item, parent, false);
        } else {
            view = convertView;
        }


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent questionIntent = new Intent(parent.getContext(), NoteQuestionActivity.class);
                        questionIntent.putExtra("category", category);
                        questionIntent.putExtra("setId", sets.get(position));
                        parent.getContext().startActivity(questionIntent);
                    }
                });

        ((TextView) view.findViewById(R.id.item_textview)).setText(String.valueOf(position + 1));
        return view;
    }
}
