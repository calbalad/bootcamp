import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Calculadora {

	public Calculadora() {
	}
	String cadena = "";
	public double calcularCadena(String cadena) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(cadena, "-+*=/", true);
		while (st.hasMoreTokens()) {
			String id = st.nextToken();
			String desc = st.nextToken();
			list.add(id + " " + desc);
		}
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			//System.out.println(iter.next());
			this.cadena += iter.next() + "\n";

		double agregate = Double.parseDouble(list.get(0).split(" ")[0].replace(",", "."));
		int o = 1;
		for (int i = 0; i < list.size(); i++) {
			var tmp = list.get(i).split(" ");
			if (tmp[1].equals("+"))
				agregate += Double.parseDouble(list.get(o++).split(" ")[0].replace(",", "."));
			else if (tmp[1].equals("-"))
				agregate -= Double.parseDouble(list.get(o++).split(" ")[0].replace(",", "."));
			else if (tmp[1].equals("*"))
				agregate *= Double.parseDouble(list.get(o++).split(" ")[0].replace(",", "."));
			else if (tmp[1].equals("/"))
				agregate /= Double.parseDouble(list.get(o++).split(" ")[0].replace(",", "."));
		}

		return (double) Math.round(agregate * 100000d) / 100000d;
	}

	public static Double division(double op1, double op2) {
		if (op2 == 0)
			throw new ArithmeticException("/ by zero");
		return op1 / op2;
	}
	
	public String getCadena() {
		return this.cadena;
	}

}
