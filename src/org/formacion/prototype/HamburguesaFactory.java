package org.formacion.prototype;

import java.util.ArrayList;
import java.util.List;

import org.formacion.prototype.Hamburguesa.Carne;
import org.formacion.prototype.Hamburguesa.Extra;
import org.formacion.prototype.Hamburguesa.Pan;
import org.formacion.prototype.Hamburguesa.Size;

public class HamburguesaFactory implements Cloneable {

	private Carne carne;
	private Size size;
	private Pan pan;
	private List<Extra> extras = new ArrayList<>();
	
	public Hamburguesa crea() {
		return new Hamburguesa(carne, size, pan, extras.toArray(new Extra[extras.size()]));
	}
	
	public static HamburguesaFactory from (Hamburguesa original) {
		HamburguesaFactory factory = new HamburguesaFactory();
		factory.carne = original.getCarne();
		factory.size = original.getSize();
		factory.pan = original.getPan();
		factory.extras = original.getExtras();
		return factory;
	}
	
//	@Override
//	public HamburguesaFactory clone() {
//		try {
//			return (HamburguesaFactory) super.clone();
//		} catch (CloneNotSupportedException e) {
//			throw new AssertionError();
//		}
//	}
	
	public HamburguesaFactory setCarne(Carne carne) {
		this.carne = carne;
		return this;
	}

	public HamburguesaFactory setSize(Size size) {
		this.size = size;
		return this;
	}

	public HamburguesaFactory setPan(Pan pan) {
		this.pan = pan;
		return this;
	}

	public HamburguesaFactory addExtra(Extra extra) {
		this.extras.add(extra);
		return this;
	}

	public HamburguesaFactory removeExtra(Extra extra) {
		this.extras.remove(extra);
		return this;
	}



	// -- hamburguesas de la carta
	public static Hamburguesa royal() {
		return new Hamburguesa ( Carne.VACUNO, Size.GRANDE, Pan.NORMAL, Extra.CEBOLLA, Extra.QUESO);
	}

	public static Hamburguesa king() {
		return new Hamburguesa ( Carne.VACUNO, Size.EXTRA_GRANDE, Pan.NORMAL, Extra.CEBOLLA, Extra.HUEVO);
	}


}
