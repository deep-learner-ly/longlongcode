package edu.decorate;

/**
 * @author: LongyunBian
 * @date: 2023/3/29 19:32
 * @Description: 具体组件
 */
public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("基础操作");
    }
}
