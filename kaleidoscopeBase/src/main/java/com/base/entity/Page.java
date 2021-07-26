package com.base.entity;

import java.util.List;

/**
 * @zz yyh
 * @time 2020-07
 */
public class Page<T> {
    private Long total;
    private List<T> dlist;

    public Page() {
    }

    public Page(Long total, List<T> dlist) {
        this.total = total;
        this.dlist = dlist;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getDlist() {
        return dlist;
    }

    public void setDlist(List<T> dlist) {
        this.dlist = dlist;
    }
}
