package com.mmall.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2020/8/7 - 16:08
 */
public class CartVo {
    private List<CartProductVo> cartProductVoList;
    private BigDecimal cartTotalPrice;//总价
    private Boolean allCheck;//是否全部勾选
    private String imageHost;

    public List <CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List <CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllCheck() {
        return allCheck;
    }

    public void setAllCheck(Boolean allCheck) {
        this.allCheck = allCheck;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
