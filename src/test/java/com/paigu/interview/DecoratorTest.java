package com.paigu.interview;

import com.paigu.interview.Decorator.Circle;
import com.paigu.interview.Decorator.IShape;
import com.paigu.interview.Decorator.RedShape;
import com.paigu.interview.Decorator.StarsShape;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DecoratorTest {
	@Test
	void redDecorator(){
		IShape shape = new Circle();
		IShape starsShape = new StarsShape(shape);
		IShape redShape = new RedShape(starsShape);
		redShape.draw();
	}
}
