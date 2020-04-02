package com.jason.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Jason
 * @Date: 2020/1/1 16:51
 * @Description:
 */
public class Page<T> {

    private int pageNo = 1;//当前页
    private int pageSize = Integer.parseInt(PropertiesLoader.getProperty("page.pageSize"));//每页大小
    private int count;//总记录数
    private int first;//首页索引
    private int last;//尾页索引
    private int prev;//上一页
    private int next;//下一页
    private boolean firstPage;//是否为第一页
    private boolean lastPage;//是否为最后一页
    private List<T> list = new ArrayList<>();
    private String orderBy;

    public Page initialize(){
        this.first = 1;
        this.last = (this.count / (this.pageSize < 1 ? 20 :this.pageSize) + first -1);

        if(this.count % this.pageSize != 0 || this.last == 0){
            this.last++;
        }

        if(this.last < this.first){
            this.last = this.first;
        }

        if(this.pageNo <= 1){
            this.pageNo = this.first;
            this.firstPage = true;
        }

        if(this.pageNo >= this.last){
            this.pageNo = this.last;
            this.lastPage = true;
        }

        if(this.pageNo < this.last - 1){
            this.next = this.pageNo + 1;
        }else{
            this.next = this.last;
        }

        if(this.pageNo > 1){
            this.prev = this.pageNo - 1;
        }else{
            this.prev = this.first;
        }
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public Page<T> setPageNo(int pageNo) {
        if(pageNo > 1){
            this.pageNo = pageNo;
        }
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page<T> setPageSize(int pageSize) {
        if(pageSize > this.pageSize){
            this.pageSize = pageSize;
        }
        return this;
    }

    public int getCount() {
        return count;
    }

    public Page<T> setCount(int count) {
        this.count = count;
        return this;
    }

    public int getFirst() {
        return first;
    }

    public Page<T> setFirst(int first) {
        this.first = first;
        return this;
    }

    public int getLast() {
        return last;
    }

    public Page<T> setLast(int last) {
        this.last = last;
        return this;
    }

    public int getPrev() {
        return prev;
    }

    public Page<T> setPrev(int prev) {
        this.prev = prev;
        return this;
    }

    public int getNext() {
        return next;
    }

    public Page<T> setNext(int next) {
        this.next = next;
        return this;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public Page<T> setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
        return this;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public Page<T> setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public Page<T> setList(List<T> list) {
        this.list = list;
        initialize();
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public Page<T> setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public boolean isDisabled() {
        return this.pageSize==-1;
    }

    public boolean isNotCount() {
        return this.count==-1;
    }

    public int getLimitNum(){
        int limit = (getPageNo() -1) * getPageSize();
        if(limit >= count){
            limit = 0;
        }
        return limit;
    }
}
