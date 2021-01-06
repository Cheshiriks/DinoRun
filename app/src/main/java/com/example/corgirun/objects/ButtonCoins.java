package com.example.corgirun.objects;

import com.example.corgirun.utilits.ResourceUtils;
import com.example.puzzle.AnimationButtonPuz;
import com.example.puzzle.ButtonPuz;
import com.example.puzzle.CorePuz;
import com.example.puzzle.SoundPuz;

public class ButtonCoins extends ButtonPuz {

	public ButtonCoins(CorePuz corePuz, int x, int y, int coins) {
		super(corePuz);
		this.x = x;
		this.y = y;
		buttonOn = false;
		buttonSound = corePuz.getAudioPuz().newSound("button.wav");

		switch (coins) {
			case 500:
				animationButton = new AnimationButtonPuz(
						ResourceUtils.buttCoins.get(0),
						ResourceUtils.buttCoins.get(1)
				);
				break;
			case 1000:
				animationButton = new AnimationButtonPuz(
						ResourceUtils.buttCoins.get(2),
						ResourceUtils.buttCoins.get(3)
				);
				break;
			case 3000:
				animationButton = new AnimationButtonPuz(
						ResourceUtils.buttCoins.get(4),
						ResourceUtils.buttCoins.get(5)
				);
				break;
			case 20000: //пробег
				animationButton = new AnimationButtonPuz(
						ResourceUtils.buttCoins.get(6),
						ResourceUtils.buttCoins.get(7)
				);
				break;
			case 5000:
				animationButton = new AnimationButtonPuz(
						ResourceUtils.buttCoins.get(8),
						ResourceUtils.buttCoins.get(9)
				);
				break;
		}

	}

	@Override
	public boolean isTouch(CorePuz corePuz) {

		if (corePuz.getTouchListenerPuz().getTouchDown((int)x + 1, (int)y + 15, 58, 15)) {
			if (!buttonOn) {
				buttonSound.play(1f);
			}
			buttonOn = true;
			return false;
		}
		if (corePuz.getTouchListenerPuz().getTouchUp((int)x + 1, (int)y + 15, 58, 15)) {
			buttonOn = false;
			return true;
		}
		return false;

	}

	public SoundPuz getButtonSound() {
		return buttonSound;
	}

}