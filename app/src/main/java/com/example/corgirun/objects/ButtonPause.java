package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;

public class ButtonPause extends ButtonPuz {

	public ButtonPause(CorePuz corePuz, int x, int y) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		animationButton = new AnimationButtonPuz(
				ResourceUtils.buttPause.get(0),
				ResourceUtils.buttPause.get(1)
		);
	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown(0, 20, 20, 20)) {
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(0, 20, 20, 20)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

}
