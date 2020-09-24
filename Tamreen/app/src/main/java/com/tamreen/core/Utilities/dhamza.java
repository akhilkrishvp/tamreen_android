package com.tamreen.core.Utilities;

import android.content.Context;

import com.bigkoo.svprogresshud.SVProgressHUD;

/**
 * Created by diyaa on 10/3/17.
 */

public class dhamza {
    public enum IndicatorType {
        None, Success, Fail
    }


    public static class Indicator {
        private SVProgressHUD mSVProgressHUD;
        private Context context;

        public Indicator(Context context) {
            this.context = context;

            mSVProgressHUD = new SVProgressHUD(this.context);

        }

        public void Start() {
            mSVProgressHUD.show();
            //mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
        }

        public void Start(Boolean withMask) {
            mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.None);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Black);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Clear);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.ClearCancel);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.Gradient);
//        mSVProgressHUD.showWithMaskType(SVProgressHUD.SVProgressHUDMaskType.GradientCancel);
        }


        public void Start(String label) {
            mSVProgressHUD.showWithStatus(label);
        }

        public void Start(IndicatorType type, String label) {
            switch (type) {
                case None:
                    mSVProgressHUD.showInfoWithStatus(label, SVProgressHUD.SVProgressHUDMaskType.None);
                    break;

                case Success:
                    mSVProgressHUD.showSuccessWithStatus(label);
                    break;

                case Fail:
                    mSVProgressHUD.showErrorWithStatus(label, SVProgressHUD.SVProgressHUDMaskType.GradientCancel);
                    break;
            }

        }


        public void Stop() {
            if (mSVProgressHUD.isShowing()) {
                mSVProgressHUD.dismiss();
            }
        }


    }


}
