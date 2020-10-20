package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;

public class ButtonPauseExit extends ButtonPuz {

	public ButtonPauseExit(CorePuz corePuz, int x, int y) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		animationButton = new AnimationButtonPuz(
				ResourceUtils.buttPauseExit.get(0),
				ResourceUtils.buttPauseExit.get(1)
		);
	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown(90, 84, 58, 15)) {
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(90, 84, 58, 15)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

}
