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

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;
import java.util.List;


public class UIRecyclerViewAdapter<TItem extends GameObjectDisplayDTO>
        extends RecyclerView.Adapter<UIRecyclerViewAdapter<TItem>.UIRecyclerViewHolder> {
    private final GradientDrawable mTagViewBackground;
    private final LinearLayout.LayoutParams mItemViewParams;
    private final LinearLayout.LayoutParams mButtonParams;
    private final LinearLayout.LayoutParams mTagViewParams;
    private int mItemHeight;
    private int mTagPadding;
    private int mTagViewHeight;
    private int mTagViewWidth;
    private int mDescViewTopMargin;
    private int mButtonWidth;
    private int mButtonHeight;
    private final LinearLayout.LayoutParams mLeftViewParams;
    private final LinearLayout.LayoutParams mDescViewParams;
    List<TItem> mListAllDataSource = new ArrayList<>(1024);
    List<TItem> mListSearchDataSource = new ArrayList<>(1024);

    private OnItemClickerListener<TItem> mOnItemClickerListener;


    public UIRecyclerViewAdapter(Context context) {

        initDisplaySize(context);

        this.mLeftViewParams = createLeftViewParams();
        this.mDescViewParams = createDescViewParams();
        this.mItemViewParams = createItemViewParams();
        this.mButtonParams = createButtonParams();
        this.mTagViewParams = createTagViewParams();
        this.mTagViewBackground = createTagViewBackground();

    }

    private void initDisplaySize(@NonNull Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mButtonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, displayMetrics);
        mButtonHeight = mButtonWidth + 1 - 1;//(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, displayMetrics);
        mItemHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 72, displayMetrics);
        mTagPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14, displayMetrics);
        mDescViewTopMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6, displayMetrics);
        mTagViewHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
        mTagViewWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 128, displayMetrics);
    }

    @NonNull
    private LinearLayout.LayoutParams createLeftViewParams() {
        LinearLayout.LayoutParams leftViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        leftViewParams.weight = 1.0f;
        return leftViewParams;
    }

    @NonNull
    private LinearLayout.LayoutParams createDescViewParams() {
        LinearLayout.LayoutParams descViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,// 宽度
                ViewGroup.LayoutParams.WRAP_CONTENT// 高度
        );
        descViewParams.setMargins(0, mDescViewTopMargin, 0, 0);
        return descViewParams;
    }

    @NonNull
    @Contract(" -> new")
    private LinearLayout.LayoutParams createItemViewParams() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mItemHeight);
    }

    @NonNull
    @Contract(" -> new")
    private LinearLayout.LayoutParams createButtonParams() {
        return new LinearLayout.LayoutParams(
                mButtonWidth,
                mButtonHeight
        );
    }

    @NonNull
    private LinearLayout.LayoutParams createTagViewParams() {
        LinearLayout.LayoutParams tagViewParams = new LinearLayout.LayoutParams(
                mTagViewWidth,
                mTagViewHeight
        );
        tagViewParams.setMargins(mTagPadding, 0, 0, 0);
        return tagViewParams;
    }

    @NonNull
    private GradientDrawable createTagViewBackground() {
        GradientDrawable tagViewBackground = new GradientDrawable();
        tagViewBackground.setShape(GradientDrawable.RECTANGLE);
        tagViewBackground.setStroke(4, UIResourceManager.Color_Green); //
        tagViewBackground.setCornerRadius(8F);
        return tagViewBackground;
    }


    public void setItemClickListener(OnItemClickerListener<TItem> l) {
        this.mOnItemClickerListener = l;
    }


    @NonNull
    @Override
    public UIRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UIRecyclerViewHolder(createRootLinearLayout(parent.getContext()));
    }

    private LinearLayout createRootLinearLayout(Context context) {
        LinearLayout rootView = new LinearLayout(context);
        rootView.setPadding(mTagPadding, 0, mTagPadding, 0);
        rootView.setGravity(Gravity.CENTER);
        rootView.setOrientation(LinearLayout.HORIZONTAL);
        rootView.setLayoutParams(mItemViewParams);
        return rootView;
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

    @SuppressLint("NotifyDataSetChanged")
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

    public interface OnCloseListener {
        void onClose();
    }

//    public interface OnSearchListener {
//        void onSearch();
//    }

    public interface OnLoadListener {
        void OnLoad();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void onSearch(@Nullable String key) {
        this.mListSearchDataSource.clear();
        if (key == null || key.isEmpty()) {
            this.mListSearchDataSource.addAll(this.mListAllDataSource);
        } else {
            this.mListAllDataSource.forEach(item ->
            {
                String lowKey = key.toLowerCase();
                if (containsSearch(item.DisplayName, lowKey)
                        || containsSearch(item.DisplayCategory, lowKey)
                        || containsSearch(item.DisplayDesc, lowKey)) {
                    this.mListSearchDataSource.add(item);
                }
            });

        }
        this.notifyDataSetChanged();

    }

    static Boolean containsSearch(@Nullable String name, @NotNull String key) {
        if (name == null) {
            return false;
        }
        return name.toLowerCase().contains(key);
    }


    public class UIRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitleView, mTagView, mDescView;
        ImageButton mEditButton;
        LinearLayout mRootView;

        private UIRecyclerViewHolder(LinearLayout rootView) {

            super(rootView);
            this.mRootView = rootView;

            Context context = rootView.getContext();
            this.mTitleView = createTitleTextView(context);
            this.mTagView = createTagTextView(context);
            LinearLayout leftTopView = createLeftTopLinearLayout(context);
            leftTopView.addView(this.mTitleView, 0);
            leftTopView.addView(this.mTagView, 1);

            this.mDescView = createDescTextView(context);
            LinearLayout leftView = createLeftLinearLayout(context);
            leftView.addView(leftTopView, 0);
            leftView.addView(this.mDescView, 1);

            this.mEditButton = createEditButton(context);
            this.mRootView.addView(leftView, 0, mLeftViewParams);
            this.mRootView.addView(this.mEditButton, 1);
        }


        @NonNull
        private TextView createTitleTextView(Context context) {
            TextView titleView = new TextView(context);
            titleView.setTextColor(Color.WHITE);
            return titleView;
        }

        @NonNull
        private TextView createTagTextView(Context context) {
            TextView tagView = new TextView(context);
            tagView.setPadding(mTagPadding, 0, mTagPadding, 0);
            tagView.setLayoutParams(mTagViewParams);
            tagView.setGravity(Gravity.CENTER);
            tagView.setTextColor(UIResourceManager.Color_Green);
            tagView.setBackground(mTagViewBackground);
            return tagView;
        }

        @NonNull
        @SuppressLint("RtlHardcoded")
        private TextView createDescTextView(Context context) {
            TextView descView = new TextView(context);
            descView.setLayoutParams(mDescViewParams);
            descView.setTextColor(Color.WHITE);
            descView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            descView.setEllipsize(TextUtils.TruncateAt.END);
            descView.setMaxLines(2);
            return descView;
        }

        @NonNull
        private LinearLayout createLeftTopLinearLayout(Context context) {
            LinearLayout leftTopView = new LinearLayout(context);
            leftTopView.setOrientation(LinearLayout.HORIZONTAL);
            leftTopView.setGravity(Gravity.CENTER_VERTICAL);
            return leftTopView;
        }

        @NonNull
        private LinearLayout createLeftLinearLayout(Context context) {
            LinearLayout leftView = new LinearLayout(context);
            leftView.setGravity(Gravity.CENTER);
            leftView.setOrientation(LinearLayout.VERTICAL);
            return leftView;
        }

        @NonNull
        private ImageButton createEditButton(Context context) {
            ImageButton editButton = UIResourceManager.createEditButton(context);

            editButton.setLayoutParams(mButtonParams);
            editButton.setTooltipText("Edit");
            editButton.setOnClickListener(this);
            return editButton;
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickerListener != null) {
                Object item = this.mEditButton.getTag();
                if (item instanceof GameObjectDisplayDTO)
                    mOnItemClickerListener.onItemClick((TItem) item);
            }
        }

        private void setDisplayText(@NonNull TItem item) {
            this.mTitleView.setText(item.DisplayName);
            this.mTagView.setText(item.DisplayCategory);
            this.mDescView.setText(item.DisplayDesc);
            this.mEditButton.setTag(item);
        }
    }

}

