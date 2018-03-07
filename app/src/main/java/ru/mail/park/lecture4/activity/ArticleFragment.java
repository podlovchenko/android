package ru.mail.park.lecture4.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.mail.park.lecture4.R;

public class ArticleFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final LinearLayout layout = new LinearLayout(getContext());

        final TextView title = new TextView(getContext());
        final TextView date = new TextView(getContext());
        final TextView content = new TextView(getContext());

        title.setText(this.getArguments().getString("title"));
        date.setText(this.getArguments().getString("date"));
        content.setText(this.getArguments().getString("content"));

        layout.addView(title);
        layout.addView(date);
        layout.addView(content);

        return container;
    }

}
