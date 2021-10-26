package com.paigu.interview.Decorator;

/**
 * 圆
 *
 * @author LiaoXM
 * @date 2021/10/26
 */
public class Circle implements IShape {
	@Override
	public void draw(){
		System.out.println("画一个：圆形-----");
	}
}
