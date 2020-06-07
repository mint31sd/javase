package any.mint.annotation;

import lombok.Getter;
import lombok.Setter;

/**
 * 定义数据模型
 * 这里用User类来表示具体待处理的数据对象
 */
@Setter
@Getter
public class User {
    private String username;

    @ValidateAge(min = 20, max = 35, value = 22)
    private int age;

    @InitSex(sex = InitSex.SEX_TYPE.MAN)
    private String sex;
}
