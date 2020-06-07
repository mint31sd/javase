package any.mint.annotation;

public class AnnotationMyTest {
    //isAnnotationPresent：判断当前元素是否被指定注解修饰
    //getAnnotation：返回指定的注解
    //getAnnotations：返回所有的注解
    public static void main(String[] args) {
        try {
            //获取AnnotationMyBean的Class对象
            AnnotationMyBean bean = AnnotationMyBean.builder().build();
            Class clazz = bean.getClass();

            //判断AnnotationMyBean对象上是否有AnnotationMyDefine注解
            if (clazz.isAnnotationPresent(AnnotationMyDefine.class)) {
                System.out.println("AnnotationMyBean类上配置了AnnotationMyDefine注解！");
                //获取该对象上AnnotationMyDefine类型的注解
                AnnotationMyDefine annotation = (AnnotationMyDefine) clazz.getAnnotation(AnnotationMyDefine.class);
                System.out.println(annotation.value());
            } else {
                System.out.println("AnnotationMyBean类上没有配置AnnotationMyDefine注解！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * print:
 * AnnotationMyBean类上配置了AnnotationMyDefine注解！
 * test
 *
 */