package at.int32.sweaty.ui.controls;

public class DropdownItem {

	private String key, value;

	public DropdownItem(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String key() {
		return this.key;
	}

	public String value() {
		return this.value;
	}
}
