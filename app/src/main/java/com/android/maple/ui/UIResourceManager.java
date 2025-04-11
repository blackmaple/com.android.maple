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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import kotlinx.coroutines.ObsoleteCoroutinesApi;

public final class UIResourceManager {
    static final String Base64Image_Menu =
            "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";

    static final String Base64Image_Currency =
            "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";

    static final String Base64Image_Inventory =
            "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";

    static final String Base64Image_Character =
            "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";

    static final String Base64Image_Switch =
            "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";

    static final String Base64Image_Close =
            "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAAAXNSR0IArs4c6QAABAhJREFUeF7t3Ot100AQBeBNJ5SSVAJ0Qil0Ap1AJ5Ah7DkmKJFX0u7MffhvLGdn7uexZWv90HyT7sCDdPUuvhmAOAIDMADxDoiX7wlgAOIdEC/fE8AAxDsgXr4ngAGId0C8fE8AAxDvgHj5ngAGIN4B8fI9AQxAvAPi5XsCGIB4B8TL9wQwAPEOiJfvCWAA4h0QL98TwADEOyBevieAAZTpwIfW2s8yq5m7kDK1VpkA31pr0ZQnAQRR54/ner+21j7Pdbb/6BUARPiPf5caE4AZQQ+/J5OOIBvAbfi9KawIXodfAkEmgK3wWRG8FX46giwA74XPhmAv/FQEGQDuCZ8Fwb3hpyFYDWAkfHQEo+GnIFgJIBrST/f2z0/+vQfaG8Oj4UfVUWucHn4fbdKR+68EEOtTQAATfgSyGgA7AqjwswCwIoALPxMAGwLI8LMBsCCADb8CAHQE0OFXAYCKAD78SgDQEFCEXw0ACgKa8CsCqI6AKvyqAKoioAu/MoBqCCjDrw6gCgLa8BEAZCOgDh8FQBYC+vCRAKxGIBE+GoBVCGTCRwQwG4FU+KgAZiGQCx8ZwNUIJMNHB3AVgnic2Kt35Lb0As4jC9w7JuOawL01jf797IWmcfyRG3z4DBOgB3cGgWz4TADOvhyMIKB45veCGV4CbsObPQmowmebALNfDujCZwUw4+WAMnxmAFcioA2fHcAVCKjDVwFw9EOe6A/aruSRs5k/92U7C3h9RnAm/P5Y1AhYAZz5bH/rWUSLgBHA1eFTTwI2ALPCp0XABGB2+JQIWACsCp8OAQOAM+H3H6c+8pUwxRtDdABnw49f44ogVX697L8zHGQAV4Tff4rtzLeI0JMAFcCV4V/xLSIsAkQAM8KXRYAGYGb4kgiQAKwIXw4BCoCV4UshQACQEb4MguoAMsOXQFAZQIXw6RFUBVApfGoEFQFUDJ8WQTUAlcOnRFAJAEL4dAiqAEAKnwpBBQCI4dMgyAaAHD4FgkwADOHDI8gCwBQ+NIIMAIzhwyJYDYA5fEgEqwH8Gt69+HIA2i5dmGsMVwKIpnx8TvPLIAK08M9OgrhQ9WmwR4fvvhJALHIUAWr4RxEsDT8WuRrACAL08EcRLA8/C8A9CFjCvxdBSviZAN5DwBb+HoK08LMBbCFgDf8tBKnhVwBwi+BTay326vXtWoff2RY/sJ8i9t1EqcvNeBO4VXDfndt366Y2ZcE/j3pL1FoFwIKe+19sdcAAxF0YgAGId0C8fE8AAxDvgHj5ngAGIN4B8fI9AQxAvAPi5XsCGIB4B8TL9wQwAPEOiJfvCWAA4h0QL98TwADEOyBevieAAYh3QLx8TwADEO+AePmeAAYg3gHx8j0BDEC8A+Ll/wanMoGQDitqeAAAAABJRU5ErkJggg==";


    static final String Base64Image_Search =
            "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";

    static final String Base64Image_Edit =
            "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";

    static final String Base64Image_Html =
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

    public static void setImageButtonColor(@NonNull ImageButton button, int color) {
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

        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createSearchButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Search);
        ImageButton button = createImageButton(context, imageMenu);

        onTouchChangeButtonColor(button, Color_Orange, Color_Blue);
        return button;
    }

    @NonNull
    public static ImageButton createCloseButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Close);
        ImageButton button = createImageButton(context, imageMenu);
        onTouchChangeButtonColor(button, Color.WHITE, Color.RED);
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
    public static ImageButton createHtmlButton(Context context) {
        Bitmap imageMenu = createBitmap(Base64Image_Html);
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
        imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);

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


    @NonNull
    public static String copyStaticFile(@NonNull Context context) {
        File wwwrootDir = new File(context.getExternalFilesDir(null), "wwwroot");
        if (!wwwrootDir.exists()) {
            try {
                copyAssetsToWWWRoot(context, "wwwroot", wwwrootDir.getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return wwwrootDir.getPath();
    }

    static void copyAssetsToWWWRoot(@NonNull Context context, String assetPath, String targetPath) throws IOException {
        // 获取 assets 目录下的文件列表
        String[] assets = context.getAssets().list(assetPath);
        if (assets == null || assets.length == 0) return;

        // 创建目标目录（如果不存在）
        File targetDir = new File(targetPath);
        if (!targetDir.exists()) {
            Boolean a = targetDir.mkdirs();
        }

        // 遍历并复制每个文件
        for (String asset : assets) {
            String sourcePath = assetPath.isEmpty() ? asset : assetPath + "/" + asset;
            String destPath = targetPath + "/" + asset;

            // 检查是否是子目录（递归处理）
            String[] tmp = context.getAssets().list(sourcePath);
            if (tmp != null && tmp.length > 0) {
                copyAssetsToWWWRoot(context, sourcePath, destPath);
            } else {
                // 复制文件
                try (InputStream source = context.getAssets().open(sourcePath);
                     OutputStream dest = Files.newOutputStream(Paths.get(destPath))) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = source.read(buffer)) > 0) {
                        dest.write(buffer, 0, length);
                    }
                }
            }
        }
    }


}
