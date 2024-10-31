package com.krf.twocs.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 用户实体类，对应数据库中的user表
 */
@TableName(value ="user") // 指定实体类对应的数据库表名
public class User implements Serializable {
    /**
     * 用户ID，使用自增主键
     */
    @TableId(type = IdType.AUTO) // 指定ID生成策略为自增
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户电话号码
     */
    private String phoneNumber;

    /**
     * 序列化版本号，用于版本控制
     */
    @TableField(exist = false) // 指定该字段不对应数据库表的列
    private static final long serialVersionUID = 1L;

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户ID
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户地址
     * @return 用户地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置用户地址
     * @param address 用户地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取用户电话号码
     * @return 用户电话号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置用户电话号码
     * @param phoneNumber 用户电话号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 重写equals方法，用于比较两个User对象是否相等
     * @param that 要比较的User对象
     * @return 如果相等返回true，否则返回false
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()));
    }

    /**
     * 重写hashCode方法，用于计算对象的哈希码
     * @return 对象的哈希码
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        return result;
    }

    /**
     * 重写toString方法，用于输出User对象的字符串表示
     * @return User对象的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}