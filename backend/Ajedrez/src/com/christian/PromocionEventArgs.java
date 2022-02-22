package com.christian;

import java.util.function.Consumer;

public class PromocionEventArgs implements Consumer<Pieza> {

	private Pieza p;

	public Pieza getP() {
		return p;
	}

	public void setP(Pieza p) {
		this.p = p;
	}

	@Override
	public void accept(Pieza p) {
		setP(p);
	}
	
	
	
}
