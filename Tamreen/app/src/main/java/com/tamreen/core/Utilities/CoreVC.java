package com.tamreen.core.Utilities;


import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.snackbar.Snackbar;
import com.sun.easysnackbar.EasySnackBar;
import com.tamreen.R;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import id.voela.actrans.AcTrans;

import static com.tamreen.core.Utilities.Converter.fromJSON;


/**
 * Created by diyaa on 10/3/17.
 */

public class CoreVC extends AppCompatActivity {
    protected dhamza.Indicator mDialog;

    public int page = 1;
    public Context context;
    private static final String TAG = "CoreVC";

    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private BroadcastReceiver mMessageReceiver = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_select_area_vc);
        Window window = this.getWindow();
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }*/

        mDialog = new dhamza.Indicator(CoreVC.this);
        context = getApplicationContext();


    }

    public void finishActivity() {
        finish();
        if (UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }

    public void finishMenuActivity() {
        finish();
        if (UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        Context context = LocaleManager.setLocale(base);
        super.attachBaseContext(context);
    }

    public void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }


    RelativeLayout.LayoutParams layoutparams;


    public int dpToPx(int dp) {
        float density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }

    public void Launch(Class<?> distention) {
        Intent intent = new Intent(this, distention);
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }

    public void LaunchWithOutAnim(Class<?> distention) {
        Intent intent = new Intent(this, distention);
        startActivity(intent);
        new AcTrans.Builder(this).performNoAnimation();
    }

    public void LaunchWithAnim(Class<?> distention) {
        Intent intent = new Intent(this, distention);
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }

    public void Launch(Class<?> distention, boolean value) {
        Intent intent = new Intent(this, distention);
        intent.putExtra(Constants.IS_EDIT, value);
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }

    public void LaunchCart(Class<?> distention, boolean subscription) {
        Intent intent = new Intent(this, distention);
        intent.putExtra("CART", subscription);
        startActivity(intent);
    }

    public void Launch(Class<?> distention, String key, Object dataObj) {
        String result = Converter.toJSON(dataObj);
        Intent intent = new Intent(this, distention);
        Bundle b = new Bundle();
        b.putString(key, result);
        intent.putExtras(b);
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }


    public void LaunchWithExtras(Class<?> distention, String key, Object dataObj, HashMap<String, Boolean> extras) {
        String result = Converter.toJSON(dataObj);
        Intent intent = new Intent(this, distention);

        for (Map.Entry<String, Boolean> entry : extras.entrySet()) {
            intent.putExtra(entry.getKey(), entry.getValue());
        }

        Bundle b = new Bundle();
        b.putString(key, result);
        intent.putExtras(b);
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }
    }


    public void Launch(Class<?> distention, String key, int dataObj) {
        Intent intent = new Intent(this, distention);
        intent.putExtra(key, dataObj);
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }

    }

    public void Launch(Class<?> distention, String key, String dataObj) {
        Intent intent = new Intent(this, distention);
        intent.putExtra(key, dataObj);
        startActivity(intent);
        if (UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }

    }

    public void Launch(Class<?> distention, String key, String dataObj,String key1,int value) {
        Intent intent = new Intent(this, distention);
        intent.putExtra(key, dataObj);
        intent.putExtra(key1, value);
        startActivity(intent);
        if (UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }

    }

    public void Launch(Class<?> distention, String key, String dataObj, @Nullable Bundle bundle) {
        Intent intent = new Intent(this, distention);
        intent.putExtra(key, dataObj);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (!UserSettings.isArabic()) {
            new AcTrans.Builder(this).performSlideToLeft();
        } else {
            new AcTrans.Builder(this).performSlideToRight();
        }

    }

    public Bundle CreateBundle(String key, Object dataObj) {
        String result = Converter.toJSON(dataObj);
        Bundle b = new Bundle();
        b.putString(key, result);

        return b;
    }


    public Object getPassedModel(String key, Class<?> dataObj) throws Exception {
        Bundle b = getIntent().getExtras();
        Object dataOb = new Object();
        if (b != null) {
            try {
                String data = b.getString(key);
                dataOb = fromJSON(data, dataObj);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dataOb;
    }

   /* public void checkLogin() {
        if (!UserSettings.isLoggedIn(context)) {
            //Intent intent = new Intent(context, LoginVC.class);
            //startActivity(intent);
        }

    }*/

    public void showAlertDialog(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(CoreVC.this);
        alert.setTitle("");
        alert.setMessage(message);
        alert.setPositiveButton(getResources().getString(R.string.ok), (dialog, which) -> dialog.dismiss());
        alert.show();
    }

    public void showAlertDialog(String message, Callable<Void> action) {
        AlertDialog.Builder alert = new AlertDialog.Builder(CoreVC.this);
        alert.setTitle("");
        alert.setMessage(message);
        alert.setPositiveButton(getResources().getString(R.string.ok), (dialog, which) -> {
            dialog.dismiss();
            try {
                action.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        alert.show();
    }

    public void showAlert(final String msg) {
      /*  runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(getWindow().getDecorView().getRootView(), msg,Snackbar.LENGTH_SHORT).show();
            }
        });
*/


        showErrorAlert(msg);


    }

    public void alertShow(String message) {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }


    private void showAlert(final String msg, final int duration) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Snackbar.make(getWindow().getDecorView().getRootView(), msg, Snackbar.LENGTH_LONG).show();
                /*
                 */
                Snackbar snackbar;
                snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), msg, duration);
                View snackBarView = snackbar.getView();
                snackBarView.setBackgroundColor(context.getResources().getColor(R.color.red));
                snackbar.setDuration(5000);
                //TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                //textView.setTextColor(textColor);

                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackBarView.getLayoutParams();
                params.gravity = Gravity.TOP;
                snackBarView.setLayoutParams(params);
                snackbar.show();

            }
        });

    }

    public void showSnackBar(final String msg) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
        runOnUiThread(() -> {
            Snackbar snackbar;
            snackbar = Snackbar.make(getWindow().getDecorView().getRootView(), msg, Snackbar.LENGTH_SHORT);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(context.getResources().getColor(R.color.btn_green));
            snackbar.setDuration(3000);

            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) snackBarView.getLayoutParams();
            params.gravity = Gravity.TOP;
            snackBarView.setLayoutParams(params);
            snackbar.show();

        });
    }

    public void pushShowCart() {
        Intent intent = new Intent(Constants.PUSHSHOWCART);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public void print(String msg) {
        Log.d("**", msg);
    }

    public void print(String msg, String msg2) {
        Log.d("**", msg + " " + msg2);
    }

    public void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void showActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
    }

   /* public void exitVC() {
        Intent intent = new Intent(getApplicationContext(), HomeNewVC.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);

    }*/

    public void startIndicator() {
        try {
            mDialog.Start();
        } catch (Exception ex) {

        }

    }

    public void stopIndicator() {
        runOnUiThread(() -> mDialog.Stop());

    }

    @Override
    public void onBackPressed() {
        /*finish();
        overridePendingTransition(R.anim.anim_slide_in_left,
                R.anim.anim_slide_out_left);*/
        //super.onBackPressed();
        finishActivity();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showErrorAlert(String message) {
        View contentView = EasySnackBar.convertToContentView(getWindow().getDecorView().getRootView(), R.layout.custom_shackbar);
        ImageView icon = (ImageView) contentView.findViewById(R.id.image);
        TextView messageTV = (TextView) contentView.findViewById(R.id.messageTV);
        ImageView cartIcon = (ImageView) contentView.findViewById(R.id.cartIcon);
        messageTV.setText(message);
        cartIcon.setVisibility(View.GONE);
        icon.setVisibility(View.VISIBLE);
        contentView.setBackgroundResource(R.drawable.snackbar_error_bg);
        EasySnackBar.make(getWindow().getDecorView().getRootView(), contentView, 3000, true).show();
    }


    public String getStringValue(int id) {
        return context.getResources().getString(id);
    }
}
