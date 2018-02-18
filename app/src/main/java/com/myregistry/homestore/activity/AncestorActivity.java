package com.myregistry.homestore.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.myregistry.homestore.R;
import com.myregistry.homestore.fragment.HomeFragment;
import com.myregistry.homestore.utils.InternetConnectionBroadCast;
import com.myregistry.homestore.utils.PreferenceUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by nidhiparekh.
 */

public class AncestorActivity extends AppCompatActivity {


    PreferenceUtils preferenceUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceUtils = new PreferenceUtils(AncestorActivity.this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        View viewBadgeCount = menu.findItem(R.id.badge).getActionView();
        TextView notifCount = (TextView) viewBadgeCount.findViewById(R.id.badge_textView);
        notifCount.setText("" + new PreferenceUtils(this).getUserID());
        return true;
    }


    protected void showSnackbar(final String text) {
        View container = findViewById(R.id.frame_content);
        if (container != null) {
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show();
        }
    }

    //Receiver of network connection thread. reflect to all the child activity
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(InternetConnectionBroadCast.GetConnection getConnection) {
        EventBus.getDefault().removeStickyEvent(getConnection);
        if (!getConnection.isConnected) {
            showSnackbar(getString(R.string.connection_issue));
        } else {
            /**some of connection interface between code, when you are available with internet and want to do retrieve
             results and update your UI with callback **/
        }
    }

    //Receiver of network connection thread. reflect to all the child activity
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(HomeFragment.PromptMessageShow eventPrompt) {
        EventBus.getDefault().removeStickyEvent(eventPrompt);
        showSnackbar(eventPrompt.message);
    }

    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)
    public void onEvent(AddToCart event) {
        preferenceUtils.setUserID(this, preferenceUtils.getUserID() + 1);
        invalidateOptionsMenu();
    }

    class AddToCart {
        int countNumber;

        public AddToCart() {
        }
    }

}
