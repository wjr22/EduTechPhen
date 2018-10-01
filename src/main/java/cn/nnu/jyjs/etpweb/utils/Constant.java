package cn.nnu.jyjs.etpweb.utils;

/**
 * @Project :   etpweb
 * @Time :   9/6/2018 14:59
 * @Auther :   wangj
 * @Description:
 *
 */
public enum Constant {
    /**
     * User type
     */
    ADMINISTRATOR("administrator"),
    VISITOR("visitor"),
    USER("user"),

    /**
     * create user Message
     */
    EMAIL_UNIQUE("email_unique"),
    NAME_UNIQUE("name_unique"),
    SUCCESS("success"),
    ;

    Constant(String str) {
    }
}
