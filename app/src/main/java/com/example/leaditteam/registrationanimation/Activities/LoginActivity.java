package com.example.leaditteam.registrationanimation.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.leaditteam.registrationanimation.R;
import com.example.leaditteam.registrationanimation.Transform.FabTransform;
import com.example.leaditteam.registrationanimation.Transform.MorphTransform;

import butterknife.BindView;

/**
 * Created by leaditteam on 04.05.17.
 */

public class LoginActivity extends Activity {
    @BindView(R.id.container_login) CardView container;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (!FabTransform.setup(this, container)) {
            MorphTransform.setup(this, container,
                    ContextCompat.getColor(this, R.color.colorBackground),
                    getResources().getDimensionPixelSize(R.dimen.card_radius));
        }
        onNewIntent(getIntent());
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
       // setIntent(intent);
        setResult(Activity.RESULT_OK);
    }
    public void dismiss(View view) {
        setResult(Activity.RESULT_CANCELED);
        finishAfterTransition();
    }
}
