package com.yijian2033.sticklibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yijian2033 on 2018/3/27.
 * Email : yijian2033@163.com
 * Description :
 */

public class StickViewItemDecoration extends RecyclerView.ItemDecoration {

    private ExampleStickView mStickView;
    private Paint mPaint;
    private LinearLayoutManager mLayoutManager;
    private boolean mCurrentUIFindSticView;
    private View view;
    /**
     * 绑定的数据
     */
    private int mBindDataPosition = -1;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private RecyclerView.ViewHolder mViewHolder;
    private int mStickItemViewHeight;
    private View mStickItemView;

    private List<Integer> mStickPostionList = new ArrayList<>();
    private int mStickItemViewMarginTop;

    public StickViewItemDecoration() {
        mStickView = new ExampleStickView();
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    /**
     * 滚动时候会调用的方法
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        mLayoutManager = (LinearLayoutManager) parent.getLayoutManager();
        mCurrentUIFindSticView = false;

        for (int i = 0, size = parent.getChildCount(); i < size; i++) {
            view = parent.getChildAt(i);

            if (mStickView.isStickView(view)) {
                mCurrentUIFindSticView = true;
                getStickViewHolder(parent);
                cacheStickViewPosition(i);
                if (view.getTop() <= 0) {
                    bindDataForSticBkView(mLayoutManager.findFirstVisibleItemPosition(), parent.getMeasuredWidth());
                } else {
                    if (mStickPostionList.size() > 0) {
                        if (mStickPostionList.size() == 1) {
                            bindDataForSticBkView(mStickPostionList.get(0), parent.getMeasuredWidth());
                        } else {
                            int currentPosition = getStickViewPositionOfRecyclerView(i);
                            int indexCurrentPosition = mStickPostionList.lastIndexOf(currentPosition);
                            bindDataForSticBkView(mStickPostionList.get(indexCurrentPosition - 1), parent.getMeasuredWidth());
                        }
                    }
                }

                if (view.getTop() > 0 && view.getTop() <= mStickItemViewHeight) {
                    mStickItemViewMarginTop = mStickItemViewHeight - view.getTop();
                } else {
                    mStickItemViewMarginTop = 0;
                }
                drawStickViewItemView(c);
                break;
            }

        }
        if (!mCurrentUIFindSticView) {
            mStickItemViewMarginTop = 0;
            if (mLayoutManager.findFirstVisibleItemPosition() + mLayoutManager.getChildCount() == mAdapter.getItemCount()) {
                bindDataForSticBkView(mStickPostionList.get(mStickPostionList.size() - 1), parent.getMeasuredWidth());
            }
            drawStickViewItemView(c);
        }
    }

    /**
     * 给stickView绑定数据
     *
     * @param position
     * @param width
     */
    private void bindDataForSticBkView(int position, int width) {
        if (mBindDataPosition == position) return;
        mBindDataPosition = position;
        mAdapter.bindViewHolder(mViewHolder, mBindDataPosition);
        measureLayoutStickItemView(width);
        mStickItemViewHeight = mViewHolder.itemView.getBottom() - mViewHolder.itemView.getTop();

    }

    /**
     * 缓存吸附的view position
     */
    private void cacheStickViewPosition(int m) {

        int position = getStickViewPositionOfRecyclerView(m);
        if (!mStickPostionList.contains(position)) {
            mStickPostionList.add(position);
        }
    }

    /**
     * 获取吸附view 在Recycler View 的 position
     *
     * @param m
     * @return
     */
    private int getStickViewPositionOfRecyclerView(int m) {
        int position = mLayoutManager.findFirstVisibleItemPosition() + m;
        return position;
    }

    /**
     * 得到绑定的ViewHolder 以及itemView
     *
     * @param recyclerView
     */
    private void getStickViewHolder(RecyclerView recyclerView) {
        if (mAdapter != null) return;
        mAdapter = recyclerView.getAdapter();
        mViewHolder = mAdapter.onCreateViewHolder(recyclerView, mStickView.getStickViewType());
        mStickItemView = mViewHolder.itemView;
    }


    /**
     * 计算吸附item的高度
     *
     * @param parentWidth
     */
    private void measureLayoutStickItemView(int parentWidth) {
        if (!mStickItemView.isLayoutRequested()) return;
        int widthSpec = View.MeasureSpec.makeMeasureSpec(parentWidth, View.MeasureSpec.EXACTLY);
        int heightSpec;
        ViewGroup.LayoutParams layoutParams = mStickItemView.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            heightSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, View.MeasureSpec.EXACTLY);
        } else {
            heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }

        mStickItemView.measure(widthSpec, heightSpec);
        mStickItemView.layout(0, 0, mStickItemView.getMeasuredWidth(), mStickItemView.getMeasuredHeight());

    }

    /**
     * 绘制吸附的ItemView
     *
     * @param canvas
     */
    private void drawStickViewItemView(Canvas canvas) {
        int saveCount = canvas.save();
        canvas.translate(0, -mStickItemViewMarginTop);
        mStickItemView.draw(canvas);
        canvas.restoreToCount(saveCount);
    }


    /**
     * 根据手机分辨率从DP转成PX
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
