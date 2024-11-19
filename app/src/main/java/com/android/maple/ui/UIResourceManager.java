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

public class UIResourceManager {
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
    public static ImageButton createCloseButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Close);
        ImageButton button = createImageButton(context, imageMenu);
        button.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onTouchChangeButtonColor(button, Color.parseColor("#475569"), Color.RED);
        return button;
    }

    @NonNull
    public static ImageButton createMenuButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Menu);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color.parseColor("#475569"), Color.parseColor("#0891b2"));
        return button;
    }

    @NonNull
    public static ImageButton createCurrencyButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Currency);

        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color.parseColor("#475569"), Color.parseColor("#0891b2"));
        return button;
    }

    @NonNull
    public static ImageButton createInventoryButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Inventory);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color.parseColor("#475569"), Color.parseColor("#0891b2"));
        return button;
    }

    @NonNull
    public static ImageButton createCharacterButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Character);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color.parseColor("#475569"), Color.parseColor("#0891b2"));
        return button;
    }

    @NonNull
    public static ImageButton createSwitchButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Switch);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color.parseColor("#475569"), Color.parseColor("#0891b2"));
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
