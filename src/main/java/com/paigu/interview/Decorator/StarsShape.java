package com.paigu.interview.Decorator;

public class StarsShape extends ShapeDecorator{
	public StarsShape(IShape shape){
		super(shape);
	}

	@Override
	public void draw(){
		super.draw();
		System.out.println("我最后还要画星星");
	}
}
