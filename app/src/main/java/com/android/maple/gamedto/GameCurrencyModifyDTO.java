package com.android.maple.gamedto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class GameCurrencyModifyDTO extends GameCurrencyObjectDTO {
    @Nullable
    @SerializedName("newValue")
    public String NewValue;

    public GameCurrencyModifyDTO(@NonNull String session, @NonNull String currencyObject) {
        super(session, currencyObject);
    }

    public int getIntValue() {
        if (this.NewValue == null || this.NewValue.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(this.NewValue);
        } catch (Exception ex) {
            return 0;
        }


    }

    public void setIntValue(int val) {
        this.NewValue = String.valueOf(val);
    }


    public float getFloatValue() {
        if (this.NewValue == null || this.NewValue.isEmpty()) {
            return 0F;
        }
        try {
            return Float.parseFloat(this.NewValue);
        } catch (Exception ex) {
            return 0F;
        }
    }

    public void setFloatValue(float val) {
        this.NewValue = String.valueOf(val);
    }

    public double getDoubleValue() {
        if (this.NewValue == null || this.NewValue.isEmpty()) {
            return 0D;
        }
        try {
            return Double.parseDouble(this.NewValue);
        } catch (Exception ex) {
            return 0D;
        }
    }

    public void setDoubleValue(double val) {
        this.NewValue = String.valueOf(val);
    }

}


