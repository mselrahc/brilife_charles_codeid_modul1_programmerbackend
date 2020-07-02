package com.brilife.backend.models;

import java.util.List;
import org.springframework.data.domain.Page;

public class PageableList<T> {
  private List<T> list;
  private long total;

  public PageableList(List<T> list, long total) {
    this.list = list;
    this.total = total;
  }

  public List<T> getList() {
    return this.list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  public long getTotal() {
    return this.total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public static <T> PageableList<T> fromPage(Page<T> page) {
    return new PageableList<>(page.toList(), page.getTotalElements());
  }
}
