package com.wl.domain;

import java.util.List;

/***
 * 封装了分页的数据
 *  该页学生集合
 *  总记录数
 *  总页数
 *  当前页
 *  每页显示记录数
 */
public class PageStudentBean<T> {
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalSize;
    private List<T> list;

    public PageStudentBean() {
    }

    public PageStudentBean(int currentPage, int totalPage, int pageSize, int totalSize, List<T> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageStudentBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                ", list=" + list +
                '}';
    }
}
