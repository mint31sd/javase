package any.mint;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AnnotationMyDefine
public class AnnotationMyBean {
    private String name;
    private int age;
}