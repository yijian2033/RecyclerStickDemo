package com.yijian2033.recyclerstaticdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yijian2033.sticklibrary.StickViewItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerVier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerVier = (RecyclerView) findViewById(R.id.rv);
        recyclerVier.setLayoutManager(new LinearLayoutManager(this));
        recyclerVier.addItemDecoration(new StickViewItemDecoration());
        recyclerVier.setAdapter(new RVAdapter(this,getData()));
    }
    private ArrayList<Bean> getData() {
        ArrayList<Bean> beans = new ArrayList<>();

        Bean bean = new Bean("香港明星");
        beans.add(bean);

        Bean ldh = new Bean("刘德华", 10);
        beans.add(ldh);
        Bean zxy = new Bean("张学友", 10);
        beans.add(zxy);
        Bean zrf = new Bean("周润发", 10);
        beans.add(zrf);
        Bean lcw = new Bean("梁朝伟", 10);
        beans.add(lcw);
        Bean wyj = new Bean("吴毅将", 10);
        beans.add(wyj);
        Bean lm = new Bean("黎明", 10);
        beans.add(lm);
        Bean cgx = new Bean("陈冠希", 10);
        beans.add(cgx);
        Bean gfc = new Bean("郭富城", 10);
        beans.add(gfc);
        Bean xtf = new Bean("谢霆锋", 10);
        beans.add(xtf);

        Bean beanTw = new Bean("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久");
        beans.add(beanTw);

        Bean rxq = new Bean("任贤齐", 10);
        beans.add(rxq);
        Bean mtw = new Bean("孟庭苇", 10);
        beans.add(mtw);
        Bean ldy = new Bean("罗大佑", 10);
        beans.add(ldy);
        Bean lzs = new Bean("李宗盛", 10);
        beans.add(lzs);
        Bean xc = new Bean("小虫", 10);
        beans.add(xc);
        Bean zhj = new Bean("周华健", 10);
        beans.add(zhj);
        Bean zhl = new Bean("周杰伦", 10);
        beans.add(zhl);

        Bean BeanNl = new Bean("内陆明星");
        beans.add(BeanNl);

        Bean lh = new Bean("鹿晗", 10);
        beans.add(lh);
        Bean wzw = new Bean("王志文", 10);
        beans.add(wzw);
        Bean yq = new Bean("羽泉", 10);
        beans.add(yq);
        Bean lxl = new Bean("李小璐", 10);
        beans.add(lxl);
        Bean hh = new Bean("韩红", 10);
        beans.add(hh);
        Bean ny = new Bean("那英", 10);
        beans.add(ny);
        Bean lhh = new Bean("刘欢", 10);
        beans.add(lhh);
        Bean yk = new Bean("杨坤", 10);
        beans.add(yk);
        Bean zj = new Bean("周杰", 10);
        beans.add(zj);

        Bean BeanOm = new Bean("美国明星");
        beans.add(BeanOm);
        Bean mm = new Bean("梅梅", 10);
        beans.add(mm);
        Bean ade = new Bean("Gaga", 10);
        beans.add(ade);
        Bean hff = new Bean("黑寡妇", 10);
        beans.add(hff);
        Bean xlz = new Bean("小李子", 10);
        beans.add(xlz);

        Bean BeanNba = new Bean("NBA明星");
        beans.add(BeanNba);
        Bean xhd = new Bean("小皇帝", 10);
        beans.add(xhd);
        Bean kb = new Bean("科比", 10);
        beans.add(kb);
        Bean ym = new Bean("姚明", 10);
        beans.add(ym);
        Bean md = new Bean("麦迪", 10);
        beans.add(md);
        Bean dlt = new Bean("杜兰特", 10);
        beans.add(dlt);
        Bean kl = new Bean("库里", 10);
        beans.add(kl);
        Bean ouw = new Bean("欧文", 10);
        beans.add(ouw);
        Bean qd = new Bean("乔丹", 10);
        beans.add(qd);
        Bean alzw = new Bean("奥拉朱旺", 10);
        beans.add(alzw);
        Bean pp = new Bean("皮蓬", 10);
        beans.add(pp);
        Bean ldm = new Bean("罗德曼", 10);
        beans.add(ldm);
        Bean ke = new Bean("科尔", 10);
        beans.add(ke);
        Bean pesi = new Bean("皮尔斯", 10);
        beans.add(pesi);
        Bean jnt = new Bean("加内特", 10);
        beans.add(jnt);
        Bean lal = new Bean("雷阿伦", 10);
        beans.add(lal);
        Bean zmg = new Bean("字母哥", 10);
        beans.add(zmg);
        Bean adn = new Bean("安东尼", 10);
        beans.add(adn);

        Bean BeanDy = new Bean("导演");
        beans.add(BeanDy);
        Bean jzk = new Bean("贾樟柯", 10);
        beans.add(jzk);
        Bean ly = new Bean("李杨", 10);
        beans.add(ly);
        Bean fxg = new Bean("冯小刚", 10);
        beans.add(fxg);
        Bean lyy = new Bean("娄烨", 10);
        beans.add(lyy);
        Bean zym = new Bean("张艺谋", 10);
        beans.add(zym);

        return beans;
    }
}
