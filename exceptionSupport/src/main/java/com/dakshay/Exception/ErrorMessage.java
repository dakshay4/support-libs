package com.dakshay.Exception;

/**
 * Created by stpl on 20/9/18.
 */
public interface ErrorMessage {
    String SUCCESS = "Successfully Saved";
    String INVALID_AGENT_USER_NAME ="Invalid Agent name";
    String NO_USER_FOUND ="No user in database";
    String AGENT_EXIST ="Agent already exists";
    String EMAIL_EXIST = "Email already exists";
    String EXTRA_DATABASE_VALUES = "More than one value existed in the database";
    String CUSTOMER_EXIST ="Customer already exists";
    String COUPON_NOT_FOUND = "Coupon Not found";
    String COUPON_EXPIRED = "Given coupon is expired";
    String COUPON_CODE_LIMIT_EXCEEDED = "Exhausted existing coupon code limit, please retry with new Coupon";
    String COUPON_CODE_NOT_APPLICABLE_FOR_USER = "Coupon Code is not applicable for current user";
    String COUPON_ALREADY_EXISTS = "Coupon trying to add already exists for same customers";
}
