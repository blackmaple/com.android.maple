package com.android.maple.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.MotionEvent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;

import kotlinx.coroutines.ObsoleteCoroutinesApi;

public final class UIResourceManager {
    static final String Base64Image_Menu =
            "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";



    static final String Base64Image_Currency =
            "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";


    static final String Base64Image_Inventory =
            "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";


    static final String Base64Image_Character =
            "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAAAXNSR0IArs4c6QAABM5JREFUeF7t3f1x1DAQBXClE1IJoROoBFIJdAKdQCeQHU4zNzeOvZJ2V0/a538jW/K+3yn+Ot9T4ZK6Ak+p9547XwggOQICIIDkFUi++5wBCCB5BZLvPmcAAkhegeS7zxmAAJJXIPnucwYggOQVSL77nAEIIHkFku8+ZwACGK7A3+EtXG/gTynl+boZW7RWwGIGiAAg+0UErekq2q8EgAgUgbY2WQ0AEbQmfNF+RQBEYIhgVQBEYIRgZQBEYIBgdQBEMIhgBwBEMIBgFwBE0IkgGsAP5Tg/K9s9NuPFosbCRQP4Vkp5VYxRAHxXtDtqQgQNhYsGIEMjgoaAvJvOAEAE3qk2bH8WACJoCMmz6UwALQg+lFJ+dxaCxwQnhZsNgAg6VVuthgCACKzS7NgOCgAi6AjPYhUkAERgkWjjNtAAEEFjgKPNEQEQwWiqDeujAiCChhBHmiIDIIKRZJXrogMgAmWQvc0sAPwspbz0DkC5nvYGEq8YKgtam1kAkKLLrVsiaCw+QnMLALIfRICQZscYrAAQQUfxEVaxBEAECIk2jsEaABE0BjC7uQcAIpidakP/XgCIoCGEmU09ARDBzGSVfXsDIAJlELOaRQAgglnpKvqNAkAEijBmNIkEQAQzEr7oMxoAEYAhmAGACIAQzAJABP8RyE00uZ3+6fYavHAaMwFkR3D/7IJ8e2kKgtkAsiI4enBlCgIEANkQnD21FI4ABUAWBJpH1kIRIAHYHYEm/HoQGIYADcCuCFrCD0WACGBHBAKgZ/l1OzvoWVe1DiqA3RCownhoJP8Gvrw9bS0I3BZkAJkRhIQvBUYHkBFBWPirAMiEIDT8lQBkQBAe/moAdkYwJfwVASAhsPo63LTwVwWAgGCL8FcGMBNBz1W9o/P4qZ/8OqAVTgPPLoJYfRKvLrTU9xNsFf7qM0ANLQqB/NZB7+8Y3AOD+OTvMgNEI7iaKa7+DhX+LjPAKgjgwt8NQOSB4dUn/ejv8syf642dnkGtfhB4tM9RxwSt9da+6Kp1u0PtdwSAPBPAIdgVABEo54WdARCBAsHuAIjgAkEGAERwgiALACJ4B0EmAERwgCAbACJ4QJARABHcIcgKgAhuCLIDGPk10t5v+yjOztU/sK3Z1mmbrABGHuyod/U+vlVWLu16LSGXjTMCsAi/3tX7ujqCbAAsw6+f/KURZALgEf7yCLIA8Ax/aQQZAESEH4HA5ZGyDADkVK/nlK234J7HBOYvjMgAoL6MsQVBb/jeM4GM69nyvDMDgHrVT97IqUEwGr43AtPMTDdmKdNhW5qZwCp8LwTy5RR5bYzZkgnA1UxgHb4HAglfEJgt2QC8h8ArfEsE5geAMriMAB4ReIdvgcD84K8OKiuAikB+9Po18Bs7PaeIbuFnngHM/od2bKgFgWv4BNCRntEqGgTu4ROAUZqdmzlD4HLAdzTOzMcAnbmZribXJgTCy91W5TRPjktCFgIIKTNuJwSAm03IyAggpMy4nRAAbjYhIyOAkDLjdkIAuNmEjIwAQsqM2wkB4GYTMjICCCkzbicEgJtNyMgIIKTMuJ0QAG42ISMjgJAy43ZCALjZhIyMAELKjNsJAeBmEzIyAggpM24nBICbTcjICCCkzLidEABuNiEj+wff7GOQOwkNAQAAAABJRU5ErkJggg==";


    static final String Base64Image_Switch =
            "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";


    static final String Base64Image_Close =
            "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAAAXNSR0IArs4c6QAABAhJREFUeF7t3Ot100AQBeBNJ5SSVAJ0Qil0Ap1AJ5Ah7DkmKJFX0u7MffhvLGdn7uexZWv90HyT7sCDdPUuvhmAOAIDMADxDoiX7wlgAOIdEC/fE8AAxDsgXr4ngAGId0C8fE8AAxDvgHj5ngAGIN4B8fI9AQxAvAPi5XsCGIB4B8TL9wQwAPEOiJfvCWAA4h0QL98TwADEOyBevieAAZTpwIfW2s8yq5m7kDK1VpkA31pr0ZQnAQRR54/ner+21j7Pdbb/6BUARPiPf5caE4AZQQ+/J5OOIBvAbfi9KawIXodfAkEmgK3wWRG8FX46giwA74XPhmAv/FQEGQDuCZ8Fwb3hpyFYDWAkfHQEo+GnIFgJIBrST/f2z0/+vQfaG8Oj4UfVUWucHn4fbdKR+68EEOtTQAATfgSyGgA7AqjwswCwIoALPxMAGwLI8LMBsCCADb8CAHQE0OFXAYCKAD78SgDQEFCEXw0ACgKa8CsCqI6AKvyqAKoioAu/MoBqCCjDrw6gCgLa8BEAZCOgDh8FQBYC+vCRAKxGIBE+GoBVCGTCRwQwG4FU+KgAZiGQCx8ZwNUIJMNHB3AVgnic2Kt35Lb0As4jC9w7JuOawL01jf797IWmcfyRG3z4DBOgB3cGgWz4TADOvhyMIKB45veCGV4CbsObPQmowmebALNfDujCZwUw4+WAMnxmAFcioA2fHcAVCKjDVwFw9EOe6A/aruSRs5k/92U7C3h9RnAm/P5Y1AhYAZz5bH/rWUSLgBHA1eFTTwI2ALPCp0XABGB2+JQIWACsCp8OAQOAM+H3H6c+8pUwxRtDdABnw49f44ogVX697L8zHGQAV4Tff4rtzLeI0JMAFcCV4V/xLSIsAkQAM8KXRYAGYGb4kgiQAKwIXw4BCoCV4UshQACQEb4MguoAMsOXQFAZQIXw6RFUBVApfGoEFQFUDJ8WQTUAlcOnRFAJAEL4dAiqAEAKnwpBBQCI4dMgyAaAHD4FgkwADOHDI8gCwBQ+NIIMAIzhwyJYDYA5fEgEqwH8Gt69+HIA2i5dmGsMVwKIpnx8TvPLIAK08M9OgrhQ9WmwR4fvvhJALHIUAWr4RxEsDT8WuRrACAL08EcRLA8/C8A9CFjCvxdBSviZAN5DwBb+HoK08LMBbCFgDf8tBKnhVwBwi+BTay326vXtWoff2RY/sJ8i9t1EqcvNeBO4VXDfndt366Y2ZcE/j3pL1FoFwIKe+19sdcAAxF0YgAGId0C8fE8AAxDvgHj5ngAGIN4B8fI9AQxAvAPi5XsCGIB4B8TL9wQwAPEOiJfvCWAA4h0QL98TwADEOyBevieAAYh3QLx8TwADEO+AePmeAAYg3gHx8j0BDEC8A+Ll/wanMoGQDitqeAAAAABJRU5ErkJggg==";


    static final String Base64Image_Search =
            "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";

    static final String Base64Image_Edit =
            "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";

    public static int Color_Gray = Color.parseColor("#475569");
    public static int Color_Blue = Color.parseColor("#0891b2");
    public static int Color_Black = Color.parseColor("#333333");
    public static int Color_Orange = Color.parseColor("#ea580c");
    public static int Color_Green = Color.parseColor("#ff339933");

    @SuppressLint("ClickableViewAccessibility")
    public static void onTouchChangeButtonColor(ImageButton button, int defColor, int touchColor) {
        setImageButtonColor(button, defColor);
        button.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                setImageButtonColor(button, touchColor);
            } else {
                setImageButtonColor(button, defColor);
            }
            return false;
        });
    }

    public static void setImageButtonColor(ImageButton button, int color) {
        Drawable orgDrawable = button.getDrawable();
        //    m_button.getBackground().setTint(Color.BLACK);
        Drawable tintDrawable = DrawableCompat.wrap(orgDrawable).mutate();
        DrawableCompat.setTint(tintDrawable, color);
        button.setImageDrawable(tintDrawable);
    }

    @NonNull
    public static ImageButton createEditButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Edit);
        ImageButton button = createImageButton(context, imageMenu);
        button.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createSearchButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Search);
        ImageButton button = createImageButton(context, imageMenu);
        button.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createCloseButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Close);
        ImageButton button = createImageButton(context, imageMenu);
        button.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onTouchChangeButtonColor(button, Color_Orange, Color.RED);
        return button;
    }

    @NonNull
    public static ImageButton createMenuButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Menu);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color_Green, Color_Orange);
        return button;
    }

    @NonNull
    public static ImageButton createCurrencyButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Currency);

        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createInventoryButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Inventory);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createCharacterButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Character);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createSwitchButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Switch);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static Bitmap createBitmap(String base64) {
        byte[] decode = Base64.decode(base64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    @ObsoleteCoroutinesApi
    @NonNull
    static Bitmap createBitmap(String base64, int color) {
        byte[] decode = Base64.decode(base64, Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(decode, 0, decode.length);

        return setBitmapColor(image, color);
    }

    @NonNull
    public static ImageButton createImageButton(Context context, Bitmap image) {
        ImageButton imageButton = new ImageButton(context);
        imageButton.setImageBitmap(image);
        //  imageButton.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        imageButton.setBackgroundColor(Color.TRANSPARENT);
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return imageButton;
    }

    @NonNull
    public static LinearLayout createLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        return linearLayout;
    }

    @ObsoleteCoroutinesApi
    @NonNull
    static Bitmap setBitmapColor(@NonNull Bitmap inputImage, int color) {
        Bitmap outputImage = Bitmap.createBitmap(
                inputImage.getWidth(),
                inputImage.getHeight(),
                inputImage.getConfig());

        Canvas canvas = new Canvas(outputImage);
        Paint paint = new Paint();
        paint.setColorFilter(
                new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(inputImage, 0, 0, paint);
        return outputImage;
    }


}
