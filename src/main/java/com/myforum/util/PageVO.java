package com.myforum.util;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageVO<T> {
    private final static int DEFAULT_CURRENT_PAGE=1;
    private final static int DEFAULT_PAGE_SIZE=5;

    private Integer currentPage;            //当前页面
    private Integer pageSize;               //页面总数
    private Integer totalPage;              //总页数
    private Long totalRow;                  //元素总数量
    private List<T> items;
    public PageVO(){
        this.currentPage=DEFAULT_CURRENT_PAGE;
        this.pageSize=DEFAULT_PAGE_SIZE;
        this.items=new ArrayList<>();
    }

    public PageVO<T> toPage(Page page){
        this.setCurrentPage(page.getNumber());
        this.setPageSize(page.getSize());
        this.setTotalPage(page.getTotalPages());
        this.setTotalRow(page.getTotalElements());
        return this;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        if(items!=null) {
            this.items = items;
        }
    }
}
