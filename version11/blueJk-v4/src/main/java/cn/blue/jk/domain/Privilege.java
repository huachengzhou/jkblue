package cn.blue.jk.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Privilege implements Serializable {
    private String pid;
    private String privilege_name;//权限描述
    private String description;
    private Set<Role> roles = new HashSet<>();

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrivilege_name() {
        return privilege_name;
    }

    public void setPrivilege_name(String privilege_name) {
        this.privilege_name = privilege_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Privilege(){

    }

    @Override
    public String toString() {
        return "Privilege{" +
                "pid='" + pid + '\'' +
                ", privilege_name='" + privilege_name + '\'' +
                ", description='" + description + '\'' +
                ", roles=" + roles +
                '}';
    }
}
