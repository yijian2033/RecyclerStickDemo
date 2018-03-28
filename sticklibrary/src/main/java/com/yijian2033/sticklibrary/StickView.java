package com.yijian2033.sticklibrary;

import android.view.View;

/**
 * Created by yijian2033 on 2018/3/27.
 * Email : yijian2033@163.com
 * Description :吸附View相关的信息
 */

public interface StickView {

    /**
     * 是否有吸附的view
     * @param view
     * @return
     */
    boolean isStickView(View view);

    /**
     * 得到吸附View的类型
     * @return
     */
    int getStickViewType();

}
