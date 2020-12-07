package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;

public class ButtonPlay extends ButtonPuz {

	public ButtonPlay(CorePuz corePuz, int x, int y) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		animationButton = new AnimationButtonPuz(
				ResourceUtils.buttPlay.get(0),
				ResourceUtils.buttPlay.get(1)
		);
	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown((int)x + 1, (int)y + 21, 21, 21)) {
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp((int)x + 1, (int)y + 21, 21, 21)) {
			buttonOn = false;
			return true;
		}
		return false;

	}
}
