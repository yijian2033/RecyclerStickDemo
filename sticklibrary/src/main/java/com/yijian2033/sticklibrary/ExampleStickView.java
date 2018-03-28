package com.yijian2033.sticklibrary;

import android.view.View;

/**
 * Created by yijian2033 on 2018/3/27.
 * Email : yijian2033@163.com
 * Description :
 */

public class ExampleStickView implements StickView {
    @Override
    public boolean isStickView(View view) {
        return (boolean) view.getTag();
    }

    @Override
    public int getStickViewType() {
        return 11;
    }
}
