package com.yijian2033.recyclerstaticdemo;

/**
 * Created by yijian2033 on 2018/3/27.
 * Email : yijian2033@163.com
 * Description :
 */

public class Bean {

    public Bean(String content, int type) {
        this.name = content;
        this.type = type;
    }

    public Bean(String content) {
        this(content, 11);
    }

    private String name;
    private int type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
