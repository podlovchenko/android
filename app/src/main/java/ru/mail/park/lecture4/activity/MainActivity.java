package ru.mail.park.lecture4.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;
import ru.mail.park.lecture4.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ArticleListFragment articleListFragment = new ArticleListFragment();

        articleListFragment.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                Bundle bundle = new Bundle();

                bundle.putString("title", article.getTitle());
                bundle.putString("date", article.getDate().toString());
                bundle.putString("content", article.getContent());
                ArticleFragment articleFragment = new ArticleFragment();
                articleFragment.setArguments(bundle);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                setContentView(R.layout.article);

                fragmentTransaction.replace(R.id.main, articleFragment);
                fragmentTransaction.commit();
            }
        });

        fragmentTransaction.add(R.id.main, articleListFragment);
        fragmentTransaction.commit();
    }
}
