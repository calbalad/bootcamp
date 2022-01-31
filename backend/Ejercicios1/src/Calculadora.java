import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Calculadora {

	public Calculadora() {
	}

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
			System.out.println(iter.next());

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

}
