package com.soonyoong.youtube;

import java.util.List;

public class TriangleList {

	List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		System.out.println("TriangleList [points=" + points + "]");
	}

}
