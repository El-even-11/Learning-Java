package licenseKeyFormatting;

public class LicenseKeyFormatting {

	public static String licenseKeyFormatting(String S, int K) {

		String[] unities = S.split("-");
		StringBuilder all = new StringBuilder();
		StringBuilder ret = new StringBuilder();

		for (int i = 0; i < unities.length; i++) {
			all.append(unities[i]);
		}

		int start = all.length() % K;
		ret.append(all.substring(0, all.length() % K));

		for (int i = 0; start + (i + 1) * K <= all.length(); i++) {
			if (start != 0 || i != 0) {
				ret.append("-");
			}
			ret.append(all.substring(start + i * K, start + (i + 1) * K));
		}

		return ret.toString().toUpperCase();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
	}

}
