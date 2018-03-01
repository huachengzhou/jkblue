package cn.blue.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
    private String roleId;

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


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
                ", roleId='" + roleId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return lock_User == user.lock_User &&
                Objects.equals(organizationid, user.organizationid) &&
                Objects.equals(username, user.username) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(time, user.time) &&
                Objects.equals(uid, user.uid) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(roleId, user.roleId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(organizationid, username, name, password, salt, lock_User, time, uid, roles, roleId);
    }

    public User() {
    }

    public User(String username) {
        this.username = username;
    }
}
