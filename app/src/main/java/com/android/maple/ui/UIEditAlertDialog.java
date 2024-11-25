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

public final class UIEditAlertDialog extends LinearLayout {

    private final EditText mEditText;

    public UIEditAlertDialog(Context context) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.initRootLinearLayout(context, displayMetrics);
        this.mEditText = createValueEdit(context, displayMetrics);
        this.addView(this.mEditText, 0, createEditTextLayoutParams(displayMetrics));
    }


    private void initRootLinearLayout(Context context, DisplayMetrics displayMetrics) {

        int firstViewPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER);
        this.setPadding(firstViewPadding, 0, firstViewPadding, 0);
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

    public void showEditView(String title, String v, OnEditClickerListener l) {
        this.setValueAsString(v);
        AlertDialog.Builder dialog = createAlertDialog(this, title);
        dialog.setPositiveButton("Edit", (d, w) -> l.onEdit(this));
        dialog.show();
    }

    private AlertDialog.Builder createAlertDialog(View view, String title) {
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(view.getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert);
        inputDialog.setTitle(title);
        inputDialog.setView(view);
        inputDialog.setNeutralButton("Cancel", (d, w) -> {
          //  d.cancel();
        });
        inputDialog.setCancelable(false);
        return inputDialog;
    }


    public interface OnEditClickerListener {
        void onEdit(UIEditAlertDialog dialog);
    }

}