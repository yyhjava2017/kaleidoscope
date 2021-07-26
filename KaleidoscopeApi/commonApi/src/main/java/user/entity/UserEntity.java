package user.entity;

import lombok.Data;

import java.util.Date;

/**
 * @zz yyh
 * @time 2020-07
 */
@Data
public class UserEntity {
    private int id;             //主键id
    private String name;        //用户姓名
    private int age;            //年龄
    private int oid;            //组织id
    private String loginName;   //登录名
    private String password;    //密码
    private String mobile;      //手机
    private String email;       //邮箱
    private Date genTime;       //创建时间
    private Date lastLoginTime; //最后登陆时间
    private Date count;         //登录次数


    public UserEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGenTime() {
        return genTime;
    }

    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTimr) {
        this.lastLoginTime = lastLoginTimr;
    }

    public Date getCount() {
        return count;
    }

    public void setCount(Date count) {
        this.count = count;
    }
}
