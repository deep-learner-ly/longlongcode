package edu.decorate;

/**
 * @author: LongyunBian
 * @date: 2023/3/29 19:33
 * @Description: 具体装饰类
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void operation() {
        // 添加额外的功能
        System.out.println("添加额外的功能");
        component.operation();
    }
}
