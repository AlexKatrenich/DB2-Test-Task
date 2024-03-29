package com.katrenich.alex.exchangerate.exchange_rate_screen.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.katrenich.alex.exchangerate.R;
import com.katrenich.alex.exchangerate.exchange_rate_screen.presentation.ExchangeRateActivityPresenter;
import com.katrenich.alex.exchangerate.exchange_rate_screen.view.ExchangeRateMainView;

public class ExchangeRateActivity extends MvpAppCompatActivity implements ExchangeRateMainView {
    private Toolbar mToolbar;

    @InjectPresenter
    ExchangeRateActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rate);
        init(savedInstanceState);

    }

    // initialize all view`s here
    private void init(Bundle savedInstanceState) {
        mToolbar = findViewById(R.id.tb_exchange_rate_activity);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exchange_rate_activity_toolbar_menu, menu);
        return true;
    }

    @Override
    public void bindFragment(Fragment fragment, int container) {
        if (fragment == null || container == 0) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }

    @Override
    public void showMessage(String message) {
        if(message != null) Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        setSupportActionBar(null);
        super.onDestroy();
    }
}
