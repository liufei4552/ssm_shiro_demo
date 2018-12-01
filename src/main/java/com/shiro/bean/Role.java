package com.shiro.bean;
/**
* @Author LiuFei
* @Description  角色实体类
* @Date 16:58 2018/11/30
* @Param
* @return
**/
public class Role {
    private Integer id;

    private String name;

    private String explain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", explain='" + explain + '\'' +
                '}';
    }
}