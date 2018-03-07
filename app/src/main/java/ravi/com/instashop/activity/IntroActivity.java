package ravi.com.instashop.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ravi.com.instashop.fragment.IntroFragment1;
import ravi.com.instashop.fragment.IntroFragment2;
import ravi.com.instashop.R;

public class IntroActivity extends AppCompatActivity implements Animation.AnimationListener{

    int i = 0;
    @BindAnim(R.anim.slide_in_right)
    Animation slideRight;
    @BindAnim(R.anim.slide_in_left)
    Animation slideLeft;
    @BindAnim(R.anim.fade_out)
    Animation fadeOut;
    @BindAnim(R.anim.fade_in)
    Animation fadeIn;
    @BindAnim(R.anim.fade_in_slow)
    Animation fadeInSlow;
    @BindAnim(R.anim.fade_out_slow)
    Animation fadeOutSlow;

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this); // set ButterKnife
        listeners();
        loadFragment(new IntroFragment1());
    }
    @Override
    protected void onStart() {
        super.onStart();
        frameLayout.startAnimation(slideRight);
        loadFragment(new IntroFragment1());
    }

    @OnClick(R.id.btn_next)
    public void nextfragment(View view){
        if (i == 0){
            frameLayout.startAnimation(fadeInSlow);
            loadFragment(new IntroFragment2());
            i = 1;
        } else {
            startActivity(new Intent(IntroActivity.this,MainActivity.class));
            overridePendingTransition(R.anim.fade_in_slow,R.anim.slide_out);
            finish();
        }
    }

    private void listeners() {
        slideLeft.setAnimationListener(this);
        slideRight.setAnimationListener(this);

    }
    private void loadFragment(Fragment fragment) {
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout, fragment);
//        fragmentTransaction.commit();
        android.support.v4.app.FragmentManager fragmentManage = getSupportFragmentManager();
        fragmentManage.popBackStack();
        fragmentManage.beginTransaction().add(R.id.frameLayout, fragment).commit();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
