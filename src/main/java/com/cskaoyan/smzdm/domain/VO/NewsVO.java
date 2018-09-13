package com.cskaoyan.smzdm.domain.VO;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:17 2018/9/13
 * @Modified By:
 */
public class NewsVO extends News{

    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
