package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;
import com.example.puzzle.SoundPuz;

public class ButtonQues extends ButtonPuz {

	public ButtonQues(CorePuz corePuz, int x, int y) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		buttonSound = corePuz.getAudioPuz().newSound("button.wav");
		animationButton = new AnimationButtonPuz(
				ResourceUtils.buttQues.get(0),
				ResourceUtils.buttQues.get(1)
		);
	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown(220, 19, 15, 15)) {
			if (!buttonOn) {
				buttonSound.play(1f);
			}
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp(220, 19, 15, 15)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

	public SoundPuz getButtonSound() {
		return buttonSound;
	}

}
