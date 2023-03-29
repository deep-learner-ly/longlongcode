package edu.decorate;

/**
 * @author: LongyunBian
 * @date: 2023/3/29 19:32
 * @Description: 装饰者基类
 */
public abstract class Decorator implements Component{
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}
