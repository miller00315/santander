package br.com.miller.testeAndroid.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.fragments.ContactFragment;
import br.com.miller.testeAndroid.home.fragments.InvestimentFragment;
import br.com.miller.testeAndroid.home.presenters.ContactPresenter;
import br.com.miller.testeAndroid.home.presenters.InvestimentPresenter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TabLayout tabLayout = findViewById(R.id.page_tab);
        ViewPager viewPager = findViewById(R.id.view_pager);

        PageAdapter  pageAdapter = new PageAdapter(getSupportFragmentManager());

        pageAdapter.addFragment(new InvestimentFragment(), getString(R.string.title_investiments));
        pageAdapter.addFragment(new ContactFragment(), getString(R.string.title_contact));

        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);

        for(Fragment fragment: pageAdapter.getFragments())
            if(fragment instanceof ContactFragment)
                new ContactPresenter((ContactFragment) fragment);
            else if(fragment instanceof InvestimentFragment)
                new InvestimentPresenter((InvestimentFragment) fragment);

    }
}
