package com.android.maple.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.android.maple.MainActivity;

public class UIEditAlertDialog {
    private final LinearLayout mRootView;
    private final EditText mEditText;

    public UIEditAlertDialog(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        this.mEditText = createValueEdit(context, displayMetrics);
        this.mRootView = createRootLinearLayout(context, displayMetrics);
        this.mRootView.addView(mEditText, 0, createEditTextLayoutParams(displayMetrics));


    }

    @NonNull
    private LinearLayout createRootLinearLayout(Context context, DisplayMetrics displayMetrics) {

        int firstViewPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);

        LinearLayout firstView = new LinearLayout(context);
        firstView.setOrientation(LinearLayout.HORIZONTAL);
        firstView.setGravity(Gravity.CENTER);


        firstView.setPadding(firstViewPadding, 0, firstViewPadding, 0);


        return firstView;
    }

    @NonNull
    private EditText createValueEdit(Context context, DisplayMetrics displayMetrics) {
        int firstViewPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);
        EditText valueEdit = new EditText(context);
        valueEdit.setHint("New Value");
        valueEdit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        valueEdit.setHintTextColor(Color.GRAY);
        valueEdit.setSingleLine();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setStroke(2, UIResourceManager.Color_Gray);
        gradientDrawable.setCornerRadius(12f);
        valueEdit.setBackground(gradientDrawable);
        valueEdit.setTextColor(Color.WHITE);
        valueEdit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

        valueEdit.setPadding(firstViewPadding, 0, firstViewPadding, 0);
        return valueEdit;
    }

    @NonNull
    private LinearLayout.LayoutParams createEditTextLayoutParams(DisplayMetrics displayMetrics) {
        int editViewHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);

        LinearLayout.LayoutParams editParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, // 宽度
                editViewHeight
                // 高度
        );
        editParams.weight = 1.0f;
        return editParams;
    }


    public View getView() {
        return this.mRootView;
    }

    public void setValueAsString(String v) {
        this.mEditText.setText(v);
    }

    public String getValueAsString() {
        return this.mEditText.getText().toString();
    }

    public void setValueAsInt(int v) {
        setValueAsString(String.valueOf(v));
    }

    public int getValueAsInt() {
        try {
            String s = this.getValueAsString();
            return Integer.parseInt(s);
        } catch (Exception ignored) {

        }
        return 0;
    }

    public void setValueAsDouble(double v) {
        setValueAsString(String.valueOf(v));
    }

    public double getValueAsDouble() {
        try {
            String s = this.getValueAsString();
            return Double.parseDouble(s);
        } catch (Exception ignored) {

        }
        return 0;
    }

    public boolean showEditView(String title, String v) {

        UIAlertDialog dialog = new UIAlertDialog(this.mRootView.getContext());
        dialog.setTitle(title);
        this.setValueAsString(v);
        return dialog.show(getView());
    }


    static class UIAlertDialog {
        AlertDialog.Builder m_InputDialog;

        boolean m_DialogType;

        public UIAlertDialog(Context context) {

            m_InputDialog = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog_Alert);
            m_InputDialog.setPositiveButton("Edit", (d, w) -> {
                        m_DialogType = true;
                        d.cancel();
                    }
            );
            m_InputDialog.setNeutralButton("Cancel", (d, w) -> {
                m_DialogType = false;
                d.cancel();
            });
            m_InputDialog.setCancelable(false);

        }

        public void setTitle(String title) {
            this.m_InputDialog.setTitle(title);
        }


        public boolean show(View view) {
            m_DialogType = false;
            this.m_InputDialog.setView(view);
            this.m_InputDialog.show();
            return m_DialogType;
        }


    }

}