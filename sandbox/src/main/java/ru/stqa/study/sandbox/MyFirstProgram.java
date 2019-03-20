package ru.stqa.study.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {

		Point p = new Point(4,2,8,4);
		System.out.println("Расстояние между двумя точками с координатами " + "("+p.x1 + "," + p.y1 +")"+ " и " +"("+ p.x2 + "," + p.y2 +")"+ " = " + p.distance());
	}

}