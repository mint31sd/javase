package any.mint.annotation;

import java.lang.annotation.*;

/**
 * 性别赋值
 * 这里定义两个注解，一个用来赋值，一个用来校验。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface InitSex {
    enum SEX_TYPE {MAN, WOMAN}
    SEX_TYPE sex() default SEX_TYPE.MAN;
}