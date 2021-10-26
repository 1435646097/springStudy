package com.paigu.interview.Decorator;

/**
 * 红色的形状
 *
 * @author LiaoXM
 * @date 2021/10/26
 */
public class RedShape extends ShapeDecorator {
	public RedShape(IShape shape){
		super(shape);
	}

	@Override
	public void draw(){
		super.draw();
		System.out.println("画出来拉，这个是一个红色的形状");
	}
}
