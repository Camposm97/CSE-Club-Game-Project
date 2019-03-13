package attributeDialers;

import utilties.AttributeDialBagUtil;
import view.CharacterBuilderPane;

public class AttributeDialBag {
	private AttributeDial[] array;

	public AttributeDialBag(CharacterBuilderPane charPane) {
		this.array = AttributeDialBagUtil.loadAttributeDial(charPane);
		disableDialersWithNoPoints();
	}

	public AttributeDial get(int i) {
		return array[i];
	}

	public StrengthDial getStrDial() {
		return (StrengthDial) array[0];
	}

	public DexterityDial getDexDial() {
		return (DexterityDial) array[1];
	}

	public ConsitutionDial getConDial() {
		return (ConsitutionDial) array[2];
	}

	public IntelligenceDial getIntDial() {
		return (IntelligenceDial) array[3];
	}

	public WisdomDial getWisDial() {
		return (WisdomDial) array[4];
	}

	public CharismaDial getChaDial() {
		return (CharismaDial) array[5];
	}

	public void disableDialersWithNoPoints() {
		for (int i = 0; i < array.length; i++) {
			if (AttributeDialBagUtil.hasNoPointsInvested(array[i])) {
				array[i].btPlus.setDisable(false);
				array[i].btMinus.setDisable(true);
			} else {
				array[i].btMinus.setDisable(false);
				array[i].btPlus.setDisable(false);
			}
		}
	}

	public void disableDialersWithPoints() {
		for (int i = 0; i < array.length; i++) {
			if (AttributeDialBagUtil.hasPointsInvested(array[i])) {	// Has Attr. Points Invested
				array[i].btMinus.setDisable(false);
				array[i].btPlus.setDisable(true);
			} else {												// No Attr. Points Invested
				array[i].btMinus.setDisable(true);
				array[i].btPlus.setDisable(true);
			}
		}
	}

	public int size() {
		return array.length;
	}
}
