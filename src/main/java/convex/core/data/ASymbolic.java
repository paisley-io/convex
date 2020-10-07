package convex.core.data;

import convex.core.exceptions.InvalidDataException;

/**
 * Abstract based class for symbolic objects (Keywords, Symbols)
 */
public abstract class ASymbolic extends ACell {

	protected final AString name;

	public static final int MAX_LENGTH = 32;

	protected ASymbolic(AString name) {
		this.name = name;
	}
	
	public AString getName() {
		return name;
	}

	protected static boolean validateName(CharSequence name2) {
		if (name2 == null) return false;
		int n = name2.length();
		if ((n < 1) || (n > (MAX_LENGTH))) {
			return false;
		}
		return true;
	}

	@Override
	public void validateCell() throws InvalidDataException {
		if (!validateName(name)) throw new InvalidDataException("Invalid name: " + name, this);
	}

}
