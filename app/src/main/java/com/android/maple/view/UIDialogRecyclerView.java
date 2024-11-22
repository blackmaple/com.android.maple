package com.android.maple.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.maple.gamedto.GameObjectDisplayDTO;
import com.android.maple.ui.UIComponent;
import com.android.maple.ui.UIMenuMain;
import com.android.maple.ui.UIResourceManager;

import java.util.ArrayList;
import java.util.List;

public class UIDialogRecyclerView<TItem extends GameObjectDisplayDTO> extends UIComponent implements
        UIRecyclerViewAdapter.OnItemClickerListener<TItem>,
        UIRecyclerViewAdapter.OnCloseListener,
        UIRecyclerViewAdapter.OnLoadListener {

    LinearLayout mRootView;
    RecyclerView mRecyclerView;
    protected UIRecyclerViewAdapter<TItem> mViewAdapter;


    public UIDialogRecyclerView(UIMenuMain main) {
        super(main);
        Context context = main.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        EditText searchEdit = createSearchEdit(context, displayMetrics);
        searchEdit.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                UIDialogRecyclerView.this.mViewAdapter.onSearch(searchEdit.getText().toString());
            }
            return false;
        });
        ImageButton refreshButton = createRefreshButton(context);
        refreshButton.setOnClickListener((view) -> this.OnLoad());

        ImageButton closeButton = createCloseButton(context);
        closeButton.setOnClickListener((view) -> this.onClose());

        LinearLayout toolsView = createToolsLinearLayout(context, displayMetrics);
        toolsView.addView(searchEdit, 0, createEditTextLayoutParams(displayMetrics));
        LinearLayout.LayoutParams buttonParams = createButtonLayoutParams(displayMetrics);
        toolsView.addView(refreshButton, 1, buttonParams);
        toolsView.addView(closeButton, 2, buttonParams);


        this.mRecyclerView = createRecyclerView(context);
        this.mRecyclerView.addItemDecoration(createItemDecoration(displayMetrics));
        this.mViewAdapter = new UIRecyclerViewAdapter<>(context);
        this.mRecyclerView.swapAdapter(this.mViewAdapter, false);

        this.mRootView = createRootLinearLayout(context);
        this.mRootView.addView(toolsView, 0, createToolsViewLayoutParams(displayMetrics));
        this.mRootView.addView(mRecyclerView, 1, createRecyclerViewLayoutParams());
    }


    public final void setDataSource(List<TItem> items) {
        this.mViewAdapter.replaceAll(items);
        this.mRecyclerView.scrollToPosition(0);

    }

    @NonNull
    private LinearLayout createRootLinearLayout(Context context) {
        LinearLayout rootView = new LinearLayout(context);
        rootView.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        rootView.setLayoutParams(params);
        rootView.setBackgroundColor(UIResourceManager.Color_Black);
        return rootView;
    }


    @NonNull
    private UIDividerItemDecoration createItemDecoration(DisplayMetrics displayMetrics) {
        int dividerHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1,
                // 显示密度
                displayMetrics); // 分割线高度
        return new UIDividerItemDecoration(dividerHeight, UIResourceManager.Color_Gray);
    }

    @NonNull
    private LinearLayout.LayoutParams createRecyclerViewLayoutParams() {
        LinearLayout.LayoutParams recyclerViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, // 宽度
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f
                // 高度
        );
        recyclerViewParams.weight = 1.0f;
        return recyclerViewParams;
    }

    @NonNull
    private RecyclerView createRecyclerView(Context context) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(manager);
        return recyclerView;

    }

    @NonNull
    private LinearLayout.LayoutParams createToolsViewLayoutParams(DisplayMetrics displayMetrics) {
        int firstViewHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, displayMetrics);
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, // 宽度
                firstViewHeight
                // 高度
        );
    }

    @NonNull
    private LinearLayout createToolsLinearLayout(Context context, DisplayMetrics displayMetrics) {

        int firstViewPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);

        LinearLayout firstView = new LinearLayout(context);
        firstView.setOrientation(LinearLayout.HORIZONTAL);
        firstView.setGravity(Gravity.CENTER);


        firstView.setPadding(firstViewPadding, 0, firstViewPadding, 0);


        return firstView;
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

    @NonNull
    private EditText createSearchEdit(Context context, DisplayMetrics displayMetrics) {
        int firstViewPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, displayMetrics);

        EditText searchEdit = new EditText(context);
        searchEdit.setHint("Search");
        searchEdit.setHintTextColor(Color.GRAY);
        searchEdit.setSingleLine();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setStroke(2, UIResourceManager.Color_Gray);
        gradientDrawable.setCornerRadius(12f);
        searchEdit.setBackground(gradientDrawable);
        searchEdit.setTextColor(Color.WHITE);
        searchEdit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

        searchEdit.setPadding(firstViewPadding, 0, firstViewPadding, 0);
        return searchEdit;
    }

    @NonNull
    private LinearLayout.LayoutParams createButtonLayoutParams(DisplayMetrics displayMetrics) {
        int buttonMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, displayMetrics);

        int buttonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, displayMetrics);
        int buttonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, displayMetrics);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(buttonWidth, buttonHeight);
        buttonParams.setMargins(buttonMargin, 0, 0, 0);
        return buttonParams;
    }

    @NonNull
    private ImageButton createRefreshButton(Context context) {
        ImageButton refreshButton = UIResourceManager.createSearchButton(context);
        refreshButton.setTooltipText("Refresh");
        return refreshButton;
    }

    @NonNull
    private ImageButton createCloseButton(Context context) {
        ImageButton closeButton = UIResourceManager.createCloseButton(context);
        closeButton.setTooltipText("Close");
        return closeButton;
    }


    public View getView() {
        return this.mRootView;
    }

    @Override
    public void onItemClick(TItem tItem) {

    }

    @Override
    public final void onClose() {
        this.getMenuMain().changeMenuSelected();
    }

    @Override
    public void OnLoad() {

    }


}
