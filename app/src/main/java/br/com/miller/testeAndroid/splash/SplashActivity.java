package br.com.miller.testeAndroid.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import br.com.miller.testeAndroid.R;
import br.com.miller.testeAndroid.home.HomeActivity;
import br.com.miller.testeAndroid.utils.ConnectionCheck;
import br.com.miller.testeAndroid.utils.PermissionsCheck;

import static com.google.common.base.Preconditions.checkNotNull;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{

    public static String TAG = SplashActivity.class.getSimpleName();

    public static final String EXTRA_TASK_ID = "TASK_ID";

    private PermissionsCheck permissionsCheck;

    private SplashContract.Presenter mSplashPresenter;

    private Handler handler;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConnectionCheck connectionCheck = ConnectionCheck.newInstance();

        permissionsCheck = PermissionsCheck.newInstace();

        permissionsCheck.setPermissions();

        mSplashPresenter = new SplashPresenter(this);

        if(!permissionsCheck.checkSelfPermissions(this))
            permissionsCheck.requestSelfPermission(this);

        if(!connectionCheck.isNetworkAvailable(this))
            Log.w(TAG, "No internet");

        setContentView(R.layout.splash_view);

        mSplashPresenter = new SplashPresenter(this);

        mSplashPresenter.start();

        /*
        String taskId = getIntent().getStringExtra(EXTRA_TASK_ID);

        SplashFragment splashFragment = (SplashFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if(splashFragment == null){
            splashFragment = SplashFragment.newInstance(taskId);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    splashFragment,
                    R.id.contentFrame);
        }

        new SplashPresenter(splashFragment); */
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(!permissionsCheck.checkSelfPermissions(this))
            permissionsCheck.requestSelfPermission(this);
    }


    @Override
    public void drawView() {

    }

    @Override
    public void updateView() {
        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);

                finish();

            }
        }, 3000);
    }


    @Override
    public boolean isActive() {
        return false;
    }


    @Override
    public void setPresenter(SplashContract.Presenter presenter) {
        mSplashPresenter = checkNotNull(presenter);
    }
}
