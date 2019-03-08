package technology.nine.customdialogbox;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class CustomAlertDialog {
    private String title, message, positiveBtnText, negativeBtnText, imageUrl, checkBoxText;
    private Activity activity;
    private int icon;
    private technology.nine.customdialogbox.Icon visibility;
    private technology.nine.customdialogbox.CheckBox checkBoxVisibility;
    private CustomDialogListener listener, nListener;
    private int pBtnColor, color, bgColor;
    private int titleFontSize, messageFontSize;
    private ImageView.ScaleType scaleType;
    private boolean cancel;

    private CustomAlertDialog(Builder builder) {
        this.title = builder.title;
        this.message = builder.message;
        this.activity = builder.activity;
        this.icon = builder.icon;
        this.visibility = builder.visibility;
        this.listener = builder.listener;
        this.positiveBtnText = builder.positiveBtnText;
        this.negativeBtnText = builder.negativeBtnText;
        this.pBtnColor = builder.pBtnColor;
        this.color = builder.color;
        this.bgColor = builder.bgColor;
        this.cancel = builder.cancel;
        this.titleFontSize = builder.titleFontSize;
        this.messageFontSize = builder.messageFontSize;
        this.scaleType = builder.scaleType;
        this.nListener = builder.nListener;
        this.checkBoxVisibility = builder.checkBoxVisibility;
        this.checkBoxText = builder.checkBoxText;

    }

    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText, imageUrl, checkBoxText;
        private Activity activity;
        private int icon;
        private technology.nine.customdialogbox.Icon visibility;
        private technology.nine.customdialogbox.CheckBox checkBoxVisibility;
        private CustomDialogListener listener, nListener;
        private int pBtnColor, color, bgColor;
        private int titleFontSize, messageFontSize;
        private ImageView.ScaleType scaleType;
        private boolean cancel;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setTitle(String title, int fontSize) {
            this.title = title;
            this.titleFontSize = fontSize;
            return this;
        }

        public Builder setMessage(String message, int fontSize) {
            this.message = message;
            this.messageFontSize = fontSize;
            return this;
        }

        public Builder setImage(String imageUrl, ImageView.ScaleType scaleType) {
            this.imageUrl = imageUrl;
            this.scaleType = scaleType;
            return this;
        }

        //setIcon
        public Builder setIcon(int icon, Icon visibility, CustomDialogListener listener) {
            this.icon = icon;
            this.visibility = visibility;
            this.listener = listener;
            return this;
        }

        public Builder isCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder checkBoxVisibility(String checkBoxText, technology.nine.customdialogbox.CheckBox checkBoxVisibility) {
            this.checkBoxText = checkBoxText;
            this.checkBoxVisibility = checkBoxVisibility;
            return this;
        }

        public Builder checkBoxTextColor(int color) {
            this.color = color;
            return this;
        }

        public CustomAlertDialog show() {
            TextView txTitle, txMessage, txCheckBox;
            ImageView imgClose, imgAds;
            RelativeLayout rlCheckBox;
            final CheckBox checkbox;
            final Dialog dialog;
            dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.act_alert_dialog);
            txTitle = dialog.findViewById(R.id.txTitle);
            txMessage = dialog.findViewById(R.id.txMessage);
            txCheckBox = dialog.findViewById(R.id.txCheckBox);
            imgClose = dialog.findViewById(R.id.imgClose);
            imgAds = dialog.findViewById(R.id.imgAds);
            checkbox = dialog.findViewById(R.id.checkbox);
            rlCheckBox = dialog.findViewById(R.id.rlCheckBox);
            txTitle.setText(title);
            txTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleFontSize);
            txMessage.setText(Html.fromHtml(message));
            txMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, messageFontSize);
            imgClose.setBackgroundDrawable(ContextCompat.getDrawable(activity, icon));
            if (visibility == Icon.Visible) {
                imgClose.setVisibility(View.VISIBLE);
            } else {
                imgClose.setVisibility(View.GONE);
            }
            if (imageUrl != null) {
                imgAds.setVisibility(View.VISIBLE);
                imgAds.setScaleType(scaleType);
                Glide.with(activity)
                        .load(imageUrl)
                        .into(imgAds);
            } else {
                imgAds.setVisibility(View.GONE);
            }
            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dialog, checkbox.isChecked());
                }
            });
            if (checkBoxVisibility == technology.nine.customdialogbox.CheckBox.Visible) {
                rlCheckBox.setVisibility(View.VISIBLE);
                txCheckBox.setText(checkBoxText);
                if (color != 0) {
                    txCheckBox.setTextColor(color);
                }

            } else {
                rlCheckBox.setVisibility(View.GONE);
            }
            dialog.show();
            return new CustomAlertDialog(this);
        }
    }
}
