package cn.com.common.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.com.common.validate.annotation.impl.StringValidator;

/**
 * 服务器字符串验证
 *
 */
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringValidator.class})
public @interface StringValidate {
	// 是否为空
	boolean allowEmpty() default true;

	// 最小长度
	int minLength() default 0;

	// 最大长度
	int maxLength() default Integer.MAX_VALUE;

	// 只允许数字
	boolean onlyNumber() default false;

	// 只允许QQ
	boolean onlyQQ() default false;

	// 只允许手机号码
	boolean onlyMobilephone() default false;

	// 只允许身份证号码
	boolean onlyIdCard() default false;

	// 只允许中文
	boolean onlyChinese() default false;

	// 只允许英文
	boolean onlyCharacter() default false;

	// 只允许邮箱
	boolean onlyEmail() default false;

	// 允许特殊字符
	boolean allowSpecialChar() default false;

	// 提示信息
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
