package cn.cs.pojo;

import java.io.Serializable;
import java.util.Date;

public class Shopcar implements Serializable {
    private Integer id;
    private Integer uId;
    private Integer pId;
    private Integer num;
    private Boolean status;
    private Date createTime;
    //商品单价
    private Integer price;
    //商品名称
    private String name;
    //图片路径
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return new Date();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
