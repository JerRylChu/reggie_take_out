package com.zjr.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

public class Setmeal implements Serializable {

  private static final long serialVersionUID=1L;

  private Long id;
  private Long categoryId;
  private String name;
  private Double price;
  private Long status;
  private String code;
  private String description;
  private String image;
  @TableField(fill = FieldFill.INSERT)
  private java.time.LocalDateTime createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private java.time.LocalDateTime updateTime;

  @TableField(fill = FieldFill.INSERT)
  private Long createUser;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateUser;
  private Long isDeleted;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public java.time.LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.time.LocalDateTime createTime) {
    this.createTime = createTime;
  }


  public java.time.LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.time.LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }


  public Long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Long createUser) {
    this.createUser = createUser;
  }


  public Long getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Long updateUser) {
    this.updateUser = updateUser;
  }


  public Long getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Long isDeleted) {
    this.isDeleted = isDeleted;
  }

}
