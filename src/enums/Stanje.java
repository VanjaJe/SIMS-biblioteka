package enums;

public enum Stanje {
	IZGUBLJEN {
		public String toString() {
			return "izgubljen";
		}
	},
	OSTECEN {
		public String toString() {
			return "ostecen";
		}
	},
	DOSTUPAN {
		public String toString() {
			return "dostupan";
		}
	},
	IZNAJMLJEN {
		public String toString() {
			return "iznajmljen";
		}
	}
}
