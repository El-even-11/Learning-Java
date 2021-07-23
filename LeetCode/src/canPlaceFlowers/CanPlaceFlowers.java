package canPlaceFlowers;

public class CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (flowerbed.length == 1) {
			if (flowerbed[0] == 1) {
				return n == 0;
			} else {
				return n == 0 || n == 1;
			}
		}

		for (int i = 0; i < flowerbed.length; i++) {
			if (i == 0) {
				if (flowerbed[0] == 0 && flowerbed[1] == 0) {
					n--;
					flowerbed[0] = 1;
				}

			} else if (i == flowerbed.length - 1) {
				if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
					n--;
				}

			} else {

				if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
					flowerbed[i] = 1;
					n--;
				}

			}
		}

		return n <= 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
