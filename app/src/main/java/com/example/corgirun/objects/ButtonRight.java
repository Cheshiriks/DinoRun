package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;
import com.example.puzzle.SoundPuz;

public class ButtonRight extends ButtonPuz {

	public ButtonRight(CorePuz corePuz, int x, int y) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		buttonSound = corePuz.getAudioPuz().newSound("button.wav");
		animationButton = new AnimationButtonPuz(
				ResourceUtils.buttArrows.get(2),
				ResourceUtils.buttArrows.get(3)
		);
	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown(162, 76, 17, 21)) {
			if (!buttonOn) {
				buttonSound.play(1f);
			}
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(162, 76, 17, 21)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

	public SoundPuz getButtonSound() {
		return buttonSound;
	}

}