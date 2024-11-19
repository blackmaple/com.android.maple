package com.android.maple.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.maple.gamedto.GameObjectDisplayDTO;
import com.android.maple.ui.UIResourceManager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UIRecyclerViewAdapter<TItem extends GameObjectDisplayDTO> extends RecyclerView.Adapter<UIRecyclerViewAdapter<TItem>.UIRecyclerViewHolder> {
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
    private final LinearLayout.LayoutParams mLeftViewParams;
    private final LinearLayout.LayoutParams mDescViewParams;
    List<TItem> mListAllDataSource = new ArrayList<>(1024);
    List<TItem> mListSearchDataSource = new ArrayList<>(1024);

    private OnItemClickerListener<TItem> mOnItemClickerListener;

    public UIRecyclerViewAdapter(Context context) {
        this.mContext = context;
        initSize();
        GradientDrawable mButtonBackground = new GradientDrawable();
        mButtonBackground.setShape(GradientDrawable.RECTANGLE);
        mButtonBackground.setColor(Color.parseColor("#ffff8800"));
        mButtonBackground.setCornerRadius(12f);
        mLeftViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        mLeftViewParams.weight = 1.0f;

        mDescViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,// 宽度
                ViewGroup.LayoutParams.WRAP_CONTENT// 高度
        );
        mDescViewParams.setMargins(0, mDescViewTopMargin, 0, 0);


        mItemViewParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mItemHeight);
        mButtonParams = new LinearLayout.LayoutParams(
                mButtonWidth,
                mButtonHeight
        );
        mTagViewParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, // 宽度
                        mTagViewHeight
                        // 高度
                );
        mTagViewParams.setMargins(mTagPadding, 0, 0, 0);
        mWhiteColor = Color.parseColor("#ffffffff");
        mGreenColor = Color.parseColor("#ff669900");
        mTagViewBackground = new GradientDrawable();
        mTagViewBackground.setShape(GradientDrawable.RECTANGLE);
        mTagViewBackground.setStroke(2,
                mGreenColor); //
        // 2px宽度的蓝色边框
        mTagViewBackground.setCornerRadius(12f);
    }

    private void initSize() {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        mButtonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64,
                displayMetrics);
        mButtonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64,
                displayMetrics);
        mItemHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90,
                displayMetrics);
        mTagPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                // 100dp
                14,
                // 显示密度
                displayMetrics);
        mDescViewTopMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                // 100dp
                6,
                // 显示密度
                displayMetrics);
        mTagViewHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                // 100dp
                28,
                // 显示密度
                displayMetrics);
    }


    public void setItemClickListener(OnItemClickerListener<TItem> mListener) {
        this.mOnItemClickerListener = mListener;
    }


    @NonNull
    @Override
    public UIRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout itemView = new LinearLayout(parent.getContext());

        itemView.setPadding(mTagPadding, 0, mTagPadding, 0);
        itemView.setGravity(Gravity.CENTER);
        itemView.setOrientation(LinearLayout.HORIZONTAL);
        itemView.setLayoutParams(mItemViewParams);
        return new UIRecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UIRecyclerViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        TItem itemEntity = this.mListSearchDataSource.get(position);
        holder.setDisplayText(itemEntity);
    }

    @Override
    public int getItemCount() {
        return mListSearchDataSource.size();
    }

    public void addAll(List<TItem> items) {
        this.mListAllDataSource.addAll(items);
        this.mListSearchDataSource.addAll(items);
        int count = items.size();
        this.notifyItemRangeChanged(0, count);
    }

    public void clear() {
        int count = mListSearchDataSource.size();
        this.mListAllDataSource.clear();
        this.mListSearchDataSource.clear();
        this.notifyItemRangeRemoved(0, count);

    }

    public void replaceAll(List<TItem> items) {
        this.mListAllDataSource.clear();
        this.mListAllDataSource.addAll(items);
        this.mListSearchDataSource.clear();
        this.mListSearchDataSource.addAll(items);
        this.notifyDataSetChanged();
    }

    public interface OnItemClickerListener<TItem extends GameObjectDisplayDTO> {
        void onItemClick(TItem item);
    }

    public void onSearch(@Nullable String key) {
        if (key == null || key.isEmpty()) {
            return;
        }
        this.mListSearchDataSource.clear();
        this.mListAllDataSource.forEach(item ->
        {
            String lowKey = key.toLowerCase();
            if (containsSearch(item.DisplayName, lowKey)
                    || containsSearch(item.DisplayCategory, lowKey)
                    || containsSearch(item.DisplayDesc, lowKey)) {
                 this.mListSearchDataSource.add(item);
            }
        });
        this.notifyDataSetChanged();

    }

    static Boolean containsSearch(@Nullable String name, @NotNull String key) {
        if (name == null) {
            return false;
        }
        return name.toLowerCase().contains(key);
    }


    public class UIRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView, tagView, descView;
        ImageButton rightView;
        LinearLayout rootView;

        private UIRecyclerViewHolder(LinearLayout rootView) {
            super(rootView);
            this.rootView = rootView;


            titleView = new TextView(mContext);
            titleView.setTextColor(mWhiteColor);

            tagView = new TextView(mContext);
            tagView.setPadding(mTagPadding, 0, mTagPadding, 0);
            tagView.setLayoutParams(mTagViewParams);
            tagView.setGravity(Gravity.CENTER);
            tagView.setTextColor(mGreenColor);
            tagView.setBackground(mTagViewBackground);

            LinearLayout leftTopView = new LinearLayout(mContext);
            leftTopView.setOrientation(LinearLayout.HORIZONTAL);
            leftTopView.setGravity(Gravity.CENTER_VERTICAL);
            leftTopView.addView(titleView, 0);
            leftTopView.addView(tagView, 1);


            LinearLayout leftView = new LinearLayout(mContext);
            leftView.setGravity(Gravity.CENTER);
            leftView.setOrientation(LinearLayout.VERTICAL);
            leftView.addView(leftTopView, 0);

            descView = new TextView(mContext);
            descView.setLayoutParams(mDescViewParams);
            descView.setTextColor(mWhiteColor);
            descView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            descView.setEllipsize(TextUtils.TruncateAt.END);
            descView.setMaxLines(2);
            leftView.addView(descView, 1);

            rootView.addView(leftView, 0, mLeftViewParams);

            rightView = UIResourceManager.createSwitchButton(mContext);
            rightView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            rightView.setLayoutParams(mButtonParams);
            rightView.setTooltipText("Edit");
            rightView.setOnClickListener(this);
            rootView.addView(rightView, 1);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickerListener != null) {
                Object item = rightView.getTag();
                if (item instanceof GameObjectDisplayDTO) {
                    mOnItemClickerListener.onItemClick((TItem) item);
                }
            }
        }

        private void setDisplayText(@NonNull TItem item) {
            titleView.setText(item.DisplayName);
            tagView.setText(item.DisplayCategory);
            descView.setText(item.DisplayDesc);
            rightView.setTag(item);
        }
    }

}

