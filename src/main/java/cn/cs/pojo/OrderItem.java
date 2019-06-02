package cn.cs.pojo;

import org.springframework.dao.DataRetrievalFailureException;

import java.io.Serializable;
import java.util.Date;

public class OrderItem implements Serializable {
    private Integer id;
    private String oId;
    private Integer pId;
    private Integer numbers;
    private Boolean status;
    private Date createTime;
    private String name;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
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
