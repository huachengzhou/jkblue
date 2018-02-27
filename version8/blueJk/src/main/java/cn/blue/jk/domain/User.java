package cn.blue.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable, Comparable<User> {
    private String organizationid;// 公司
    private String username;
    private String name;
    private String password;
    private String salt;
    private boolean lock_User;//不要写成lock
    private Date time;
    private String uid;
    private Set<Role> roles = new HashSet<>();

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isLock_User() {
        return lock_User;
    }

    public void setLock_User(boolean lock_User) {
        this.lock_User = lock_User;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int compareTo(User o) {
        return this.getUsername().compareTo(o.getUsername());
    }

    @Override
    public String toString() {
        return "User{" +
                "organizationid='" + organizationid + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", lock_User=" + lock_User +
                ", time=" + time +
                ", uid='" + uid + '\'' +
                ", roles=" + roles +
                '}';
    }
}
