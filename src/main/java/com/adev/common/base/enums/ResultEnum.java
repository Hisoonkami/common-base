package com.adev.common.base.enums;

public enum ResultEnum {
	 /* 成功状态码 */
    SUCCESS(1, "成功"),
    
    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    VERIFICATION_CODE_IS_INVALID(10005, "验证码无效"),
    METHOD_NOT_ALLOWED(10006, "请求方法不支持"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    WRONG_PASSWORD(20006, "用户密码有误"),
    FAILED_LOGIN_ATTEMPTS_OVER_LIMIT(20007, "登录失败次数超限，账号冻结5分钟"),
    MOBILE_FORMAT_ERROR(20008, "您输入的手机号码有误，请检查后重试"),
    TRY_AGAIN_LATER(20009, "请稍后重试"),
    TOKEN_INVALID(20010, "token过期"),
    TOKEN_ILLEGAL(20010, "token无效"),
    
    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),
    
    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    
    /* 数据错误：50001-599999 */
    RESULT_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    REFERENCED_DATA_CANNOT_BE_DELETED(50004, "数据被引用，无法删除"),
    
    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),
    
    /* 权限错误：70001-79999 */
    SCOPE_NO_ACCESS(70001, "访问范围受限"),
    ROLE_NO_ACCESS(70002, "角色访问受限"),
    PERMISSION_NO_ACCESS(70003, "无访问权限");
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultEnum item : ResultEnum.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultEnum item : ResultEnum.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    public static ResultEnum getEnumByCode(Integer code) {
        for (ResultEnum item : ResultEnum.values()) {
            if (item.code().equals(code)) {
                return item;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return this.name();
    }
}
