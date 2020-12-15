package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;
import com.example.puzzle.SoundPuz;

public class ButtonPauseContinue extends ButtonPuz {

	public ButtonPauseContinue(CorePuz corePuz, int x, int y) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		buttonSound = corePuz.getAudioPuz().newSound("button.wav");
		animationButton = new AnimationButtonPuz(
				ResourceUtils.buttPauseContinue.get(0),
				ResourceUtils.buttPauseContinue.get(1)
		);
	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown(90, 66, 58, 15)) {
			if (!buttonOn) {
				buttonSound.play(1f);
			}
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(90, 66, 58, 15)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

	public SoundPuz getButtonSound() {
		return buttonSound;
	}

}
