package cn.blue.shiro.realm;

import cn.blue.common.help.ZhouBase64;
import cn.blue.common.other.CredentialEnum;
import cn.blue.jk.domain.Privilege;
import cn.blue.jk.domain.Role;
import cn.blue.jk.domain.User;
import cn.blue.jk.service.RoleService;
import cn.blue.jk.service.UserService;
import cn.blue.shiro.other.MySimpleByteSource;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RealmUtil implements Serializable {
    private final int SIZE = 10;
    private static final long serialVersionUID = 3185082762119680769L;

    private UserService userService;

    private RoleService roleService;

    public RealmUtil(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public RealmUtil() {
    }


    /**
     * 角色遍历
     *
     * @param user
     * @return
     */
    public Set<String> resolt(User user) {
        Set<String> stringSet = new HashSet<>();
        user.getRoles().forEach((role -> {
            stringSet.add(role.getRole_name());
        }));
        System.out.println(stringSet);
        return stringSet;
    }

    /**
     * 权限遍历
     *
     * @param user
     * @return
     */
    public Set<String> getPermissions(User user) {
        Set<String> set = new HashSet<>();

        user.getRoles().forEach((role -> {
            try {
                Role r = roleService.get(role.getRid());
                Set<Privilege> privileges = r.getPrivileges();
                privileges.forEach((privilege -> {
                    set.add(privilege.getPrivilege_name());
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }));
        return set;
    }

    /**
     * 对密码进行处理
     *
     * @param pass
     * @param id
     * @return
     */
    public Object getPassword(String pass, String id, CredentialEnum credentialEnum) {
        String hashAlgorithmName = credentialEnum.getVar();
        Object credentials = pass;
        MySimpleByteSource mySimpleByteSource = new MySimpleByteSource(id);
        Object result = new SimpleHash(hashAlgorithmName, credentials, mySimpleByteSource, SIZE);
        return result;
    }

}
