package com.shiro.bean;
/**
* @Author LiuFei
* @Description 权限实体类
* @Date 16:58 2018/11/30
* @Param
* @return
**/
public class Function {
    private Integer id;

    private String name;

    private Integer fatherid;

    private String url;

    private Integer type;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fatherid=" + fatherid +
                ", url='" + url + '\'' +
                ", type=" + type +
                '}';
    }
}