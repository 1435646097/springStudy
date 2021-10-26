package com.paigu.interview.Decorator;

/**
 * 形状装饰
 *
 * @author LiaoXM
 * @date 2021/10/26
 */
public abstract class ShapeDecorator implements IShape {
	private final IShape shape;

	public ShapeDecorator(IShape shape){
		this.shape = shape;
	}

	@Override
	public void draw(){
		shape.draw();
	}
}
