package com.example.puzzle.service;

import com.example.puzzle.GraphicsPuz;

public interface AnimationPuz {

	/** управление анимацией спрайтов */
	void runAnimation();

	/** отрисовываем спрайт на экране */
	void drawingAnimation(GraphicsPuz graphicsPuz, double x, double y);

}
