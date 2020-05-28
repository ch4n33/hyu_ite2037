package selfTest;

import java.util.Arrays;

public class MyCustom implements MyInterface {
	private Integer move_type = 0;
	private Boolean isAttack = false;
	
	public void move(String key) {
		if (key.equals("w")) {
			this.move_type = 1;
		}else if (key.equals("s")) {
			this.move_type = 2;
		}else if (key.equals("a")) {
			this.move_type = 3;
		}else if (key.equals("d")) {
			this.move_type = 4;
		}else {
			this.move_type = 5;
		}
	}
	public void attack(String key) {
		if (key.equals("spacebar")) {
			this.isAttack = true;
		}else {
			this.isAttack = false;
		}
	}
	public void sortItem(Item[] itemList) {
		Arrays.sort(itemList);
	}
	public Integer getMoveType() {
		return this.move_type;
	}
	public Boolean getIsAttack() {
		return this.isAttack;
	}
}
