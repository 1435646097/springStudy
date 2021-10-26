package com.paigu.interview.Decorator;

/**
 * 正方形
 *
 * @author LiaoXM
 * @date 2021/10/26
 */
public class Square implements IShape {
	@Override
	public void draw(){
		System.out.println("正方形");
	}
}
