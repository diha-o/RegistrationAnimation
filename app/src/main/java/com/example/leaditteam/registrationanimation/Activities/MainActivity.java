package com.example.leaditteam.registrationanimation.Activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.leaditteam.registrationanimation.R;
import com.example.leaditteam.registrationanimation.Transform.FabTransform;
import com.example.leaditteam.registrationanimation.ui.AnimUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.fab_main_activity) ImageView floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showFab();
    }
    @OnClick(R.id.fab_main_activity)
    protected void fabOnClick(){
        Intent login = new Intent(this, LoginActivity.class);
        FabTransform.addExtras(login, ContextCompat.getColor(this, R
                .color.colorAccent), R.drawable.ic_add);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation
                (this, floatingActionButton, getString(R.string.transition_login));
        startActivityForResult(login, 124, options.toBundle());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 124:
                if (resultCode == RESULT_OK) {
                    showFab();// just for onCreadte
                }
                break;
        }
    }
    private void showFab() {
        floatingActionButton.setAlpha(0f);
        floatingActionButton.setScaleX(0f);
        floatingActionButton.setScaleY(0f);
        floatingActionButton.setTranslationY(floatingActionButton.getHeight() / 2);
        floatingActionButton.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .translationY(0f)
                .setDuration(300L)
                .setInterpolator(AnimUtils.getLinearOutSlowInInterpolator(this))
                .start();
    }
}
