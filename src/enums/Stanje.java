package enums;

public enum Stanje {
	UKLONJEN {
		public String toString() {
			return "uklonjen";
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
