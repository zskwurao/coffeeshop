package cn.cs.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @create by zhangsk on 2018-12-07 10:55
 **/

public class PageBean {
    private Integer page = 1;//当前页码
    private Integer total;//总条数
    private Integer totalPage;//总页数
    private Integer pageSize =6;//每页记录数
    private List rows = new ArrayList();//数据集合

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}