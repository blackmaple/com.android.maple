package com.android.maple.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.maple.gamedto.GameCurrencyDisplayDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public  class UIDialogComponent extends LinearLayout
{
    public RecyclerView mRecyclerView;
    Gson mGson;

    public UIDialogComponent(Context context) {
        super(context);
        InitView(context);
        mGson =   new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        this.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, // 宽度
                ViewGroup.LayoutParams.MATCH_PARENT

                // 高度
        );
        this.setLayoutParams(params);
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private  void InitView(Context context)
    {
        int firstViewHeight = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                60,
                getResources().getDisplayMetrics()
        );
        int firstViewPadding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                14,
                getResources().getDisplayMetrics()
        );
        int buttonMargin = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                8,
                getResources().getDisplayMetrics()
        );
        int editViewHeight = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                40,
                getResources().getDisplayMetrics()
        );
        int buttonWidth = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                80,
                getResources().getDisplayMetrics()
        );
        int buttonHeight = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                40,
                getResources().getDisplayMetrics()
        );
        setBackgroundColor(Color.parseColor("#e0000000"));

        LinearLayout firstView = new LinearLayout(context);
        firstView.setOrientation(HORIZONTAL);
        //firstView.setBackgroundColor(getResources().getColor(R.color.black));
        firstView.setGravity(Gravity.CENTER);
        mRecyclerView = new RecyclerView(context);

        EditText editText = new EditText(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setStroke(2, getResources().getColor(android.R.color.holo_green_dark));
        // 2px宽度的蓝色边框
        gradientDrawable.setCornerRadius(12f);
        editText.setBackground(gradientDrawable);
        editText.setTextColor(getResources().getColor(android.R.color.white));
        LayoutParams editParams = new LayoutParams(
                LayoutParams.MATCH_PARENT, // 宽度
                editViewHeight
                // 高度
        );
        editParams.weight = 1.0f;
        editText.setPadding(firstViewPadding, 0, firstViewPadding, 0);
        firstView.addView(editText, 0, editParams);
        //Button firstButton = new Button(context);
        ImageButton firstButton = UIResourceManager.createCharacterButton(context);
        LayoutParams buttonParams = new LayoutParams(
                buttonWidth,
                buttonHeight

                // 高度
        );
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(getResources().getColor(android.R.color.holo_orange_dark));
        gradientDrawable.setCornerRadius(12f);
        buttonParams.setMargins(buttonMargin, 0, 0, 0);
        firstButton.setTooltipText("Search");
     //   firstButton.setBackground(gradientDrawable);
        firstView.addView(firstButton, 1, buttonParams);
        ImageButton secondButton = UIResourceManager.createCloseButton(context);
        secondButton.setTooltipText("Close");
   //     secondButton.setBackground(gradientDrawable);
        firstView.addView(secondButton, 2, buttonParams);
        LayoutParams firstViewParams = new LayoutParams(
                LayoutParams.MATCH_PARENT, // 宽度
                firstViewHeight
                // 高度
        );
        firstView.setPadding(firstViewPadding, 0, firstViewPadding, 0);
        addView(firstView, 0, firstViewParams);
        LayoutParams recyclerViewParams = new LayoutParams(
                LayoutParams.MATCH_PARENT, // 宽度
                LayoutParams.MATCH_PARENT,
                1.0f
                // 高度
        );
        recyclerViewParams.weight = 1.0f;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(manager);
        int dividerHeight = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                1,
                // 显示密度
                getResources().getDisplayMetrics()
        ); // 分割线高度


        addView(mRecyclerView, 1, recyclerViewParams);
       // 分割线颜色
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(dividerHeight,Color.GRAY);


        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }


    public void setData(String actionIndex, String json) {
        Type listType = new TypeToken<List<GameCurrencyDisplayDTO>>() {
        }.getType();
        List<GameCurrencyDisplayDTO> list = mGson.fromJson(json, listType);
        CustomAdapter adapter = new CustomAdapter(getContext(), list);
        mRecyclerView.setAdapter(adapter);
        adapter.setItemClickListener((view, data, position) -> Toast.makeText(getContext(), data +
                "被点击了", Toast.LENGTH_SHORT).show());
    }


    public  static class DividerItemDecoration extends RecyclerView.ItemDecoration {

        private final Paint paint;
        private final int dividerHeight;

        public DividerItemDecoration(int height, int color) {
            this.dividerHeight = height;
            paint = new Paint();
            paint.setColor(color);
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            for (int i = 0; i < parent.getChildCount() - 1; i++) {
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + dividerHeight;
                c.drawRect(left, top, right, bottom, paint);
            }
        }
    }

    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RecyclerHolder> {
        private final GradientDrawable mTagViewBackground;
        private final LinearLayout.LayoutParams mItemViewParams;
        private final LinearLayout.LayoutParams mButtonParams;
        private final LinearLayout.LayoutParams mTagViewParams;
        private final int mWhiteColor;
        private final int mGreenColor;
        private int mItemHeight;
        private final Context mContext;
        private int mTagPadding;
        private int mTagViewHeight;
        private int mDescViewTopMargin;
        private int mButtonWidth;
        private int mButtonHeight;
        private final GradientDrawable mButtonBackground;
        private final LinearLayout.LayoutParams mLeftViewParams;
        private final LinearLayout.LayoutParams mDescViewParams;
        List<GameCurrencyDisplayDTO> data = new ArrayList<>();
        private onRecyclerItemClickerListener mListener;

        public CustomAdapter(Context context, List<GameCurrencyDisplayDTO> data) {
            this.mContext = context;
            this.data = data;
            initSize();
            mButtonBackground = new GradientDrawable();
            mButtonBackground.setShape(GradientDrawable.RECTANGLE);
            mButtonBackground.setColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
            mButtonBackground.setCornerRadius(12f);
            mLeftViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    // 宽度
                    ViewGroup.LayoutParams.MATCH_PARENT
                    // 高度
            );
            mLeftViewParams.weight = 1.0f;

            mDescViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    // 宽度
                    ViewGroup.LayoutParams.WRAP_CONTENT
                    // 高度
            );
            mDescViewParams.setMargins(0, mDescViewTopMargin, 0, 0);


            mItemViewParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mItemHeight);
            mButtonParams = new LinearLayout.LayoutParams(mButtonWidth,
                    mButtonHeight

                    // 高度
            );
            mTagViewParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, // 宽度
                            mTagViewHeight
                            // 高度
                    );
            mTagViewParams.setMargins(mTagPadding, 0, 0, 0);
            mWhiteColor = mContext.getResources().getColor(android.R.color.white);
            mGreenColor = mContext.getResources().getColor(android.R.color.holo_green_dark);
            mTagViewBackground = new GradientDrawable();
            mTagViewBackground.setShape(GradientDrawable.RECTANGLE);
            mTagViewBackground.setStroke(2,
                    mGreenColor); //
            // 2px宽度的蓝色边框
            mTagViewBackground.setCornerRadius(12f);
        }

        private void initSize() {
            mButtonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60,
                    mContext.getResources().getDisplayMetrics());
            mButtonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40,
                    mContext.getResources().getDisplayMetrics());
            mItemHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90,
                    mContext.getResources().getDisplayMetrics());
            mTagPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    // 100dp
                    14,
                    // 显示密度
                    mContext.getResources().getDisplayMetrics());
            mDescViewTopMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    // 100dp
                    6,
                    // 显示密度
                    mContext.getResources().getDisplayMetrics());
            mTagViewHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    // 100dp
                    28,
                    // 显示密度
                    mContext.getResources().getDisplayMetrics());
        }


        public void setItemClickListener(onRecyclerItemClickerListener mListener) {
            this.mListener = mListener;
        }

        @NonNull
        @Override
        public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LinearLayout itemView = new LinearLayout(parent.getContext());

            itemView.setPadding(mTagPadding, 0, mTagPadding, 0);
            itemView.setGravity(Gravity.CENTER);
            itemView.setOrientation(LinearLayout.HORIZONTAL);
            itemView.setLayoutParams(mItemViewParams);
            return new RecyclerHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerHolder holder,
                                     @SuppressLint("RecyclerView") int position) {
            GameCurrencyDisplayDTO itemEntity = data.get(position);
            holder.titleView.setText(itemEntity.DisplayName);
            holder.tagView.setText(itemEntity.DisplayCategory);
            holder.descView.setText(itemEntity.DisplayDesc);
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        mListener.onRecyclerItemClick(view, data.get(position), position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public      class RecyclerHolder extends RecyclerView.ViewHolder {
            TextView titleView, tagView, descView;
            LinearLayout rootView;

            private RecyclerHolder(LinearLayout rootView) {
                super(rootView);
                this.rootView = rootView;
                //rootView.setBackgroundColor(mContext.getResources().getColor(android.R.color.black));
                LinearLayout leftView = new LinearLayout(mContext);
                leftView.setGravity(Gravity.CENTER);
                leftView.setOrientation(LinearLayout.VERTICAL);
                LinearLayout leftTopView = new LinearLayout(mContext);
                ImageButton rightView = UIResourceManager.createSwitchButton(mContext);

       //         rightView.setBackground(mButtonBackground);
                rightView.setLayoutParams(mButtonParams);
                rightView.setTooltipText("Edit");
                leftTopView.setOrientation(LinearLayout.HORIZONTAL);
                titleView = new TextView(mContext);
                titleView.setTextColor(mWhiteColor);

                tagView = new TextView(mContext);
                tagView.setPadding(mTagPadding, 0, mTagPadding, 0);
                tagView.setLayoutParams(mTagViewParams);
                tagView.setGravity(Gravity.CENTER);
                tagView.setTextColor(mGreenColor);
                tagView.setBackground(mTagViewBackground);

                leftTopView.setGravity(Gravity.CENTER_VERTICAL);
                leftTopView.addView(titleView, 0);
                leftTopView.addView(tagView, 1);

                descView = new TextView(mContext);
                descView.setLayoutParams(mDescViewParams);
                descView.setTextColor(mWhiteColor);
                descView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                descView.setEllipsize(TextUtils.TruncateAt.END);
                descView.setMaxLines(2);

                leftView.addView(leftTopView, 0);
                leftView.addView(descView, 1);

                rootView.addView(leftView, 0, mLeftViewParams);
                rootView.addView(rightView, 1);
            }
        }

        public interface onRecyclerItemClickerListener {
            void onRecyclerItemClick(View view, GameCurrencyDisplayDTO data, int position);
        }


    }

}
