package com.faculdade.utilities;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Objects<Tipo> {
	private Class classe;
	private List<Field> fields;
	private JComponent[] components;

	public Objects(Class classe) {
		super();
		this.classe = classe;
		fields = readClassFields(classe);
		components = new JComponent[fields.size() * 2];
	}

	private void buildAndShowMessage() {
		int i = 0;
		for (Field field : fields) {
			components[i++] = new JLabel(field.getName() + ":");
			components[i++] = new JTextField();
		}
		JOptionPane.showMessageDialog(null, components, classe.getSimpleName(), JOptionPane.PLAIN_MESSAGE);
	}

	public Tipo inputNewObject() {
		buildAndShowMessage();
		Tipo object = null;
		Method setField;
		try {
			object = (Tipo) classe.newInstance();
			for (int h = 0; h < fields.size(); h++) {
				System.err.println(fields.get(h));
				Class type = fields.get(h).getType();
				String typeComPrimeiraLetraMaiuscula = Utilities.firstCharatereUpperCase(type.getSimpleName());
				if (typeComPrimeiraLetraMaiuscula.equals("Boolean")) {
					setField = classe.getDeclaredMethod("set" + Utilities.firstCharatereUpperCase(fields.get(h).getName().substring(2)), type);
				} else {
					setField = classe.getDeclaredMethod("set" + Utilities.firstCharatereUpperCase(fields.get(h).getName()), type);
				}
				Method parse = null;
				if (type.getName().equals("char")) {
					setField.invoke(object, ((JTextField) components[(2 * h) + 1]).getText().toUpperCase().charAt(0));
				} else if (type.getName().equals("java.lang.String")) {
					setField.invoke(object, ((JTextField) components[(2 * h) + 1]).getText());
				} else {
					Class typeForParseMethod = type;
					if (type.isPrimitive()) {
						typeForParseMethod = defineWraperClass(type);
					}
					parse = typeForParseMethod.getDeclaredMethod("parse" + typeComPrimeiraLetraMaiuscula, String.class);
					setField.invoke(object, parse.invoke(typeForParseMethod, ((JTextField) components[(2 * h) + 1]).getText()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return object;
	}

	private Class defineWraperClass(Class classe) {
		if (classe.getSimpleName().equals("int")) {
			return Integer.class;
		} else {
			try {
				return Class.forName("java.lang." + Utilities.firstCharatereUpperCase(classe.getSimpleName()));
			} catch (ClassNotFoundException e) {
			}
		}
		return null;
	}

	private static List<Field> readClassFields(Class classe) {
		List<Field>fields = new ArrayList<>();
		for (Field field : classe.getDeclaredFields()) {
			if (isPrimitiveOrWrapperClass(field.getType())) {
				fields.add(field);
			} else {
				System.out.println(field.getName());
			}
		}
		return fields;
	}

	private static boolean isPrimitiveOrWrapperClass(Class clazz) {
		String package1 = "java.lang.";
		return (clazz.isPrimitive() || clazz.getName().equals(package1 + "String") || clazz.getName().equals(package1 + "Character")
				|| clazz.getName().equals(package1 + "Boolean") || clazz.getName().equals(package1 + "Double") || clazz.getName().equals(package1 + "Integer")
				|| clazz.getName().equals(package1 + "Long") || clazz.getName().equals(package1 + "Short") || clazz.getName().equals(package1 + "Byte")
				|| clazz.getName().equals(package1 + "Float") || clazz.getName().equals(package1 + "Boolean"));
	}

	public static String generateToStringForAnObject(Object object) {
		String toString = "";
		Method method = null;
		for (Field field : readClassFields(object.getClass())) {
			try {
				if (field.getType().getSimpleName().toUpperCase().equals("BOOLEAN")) {
					method = object.getClass().getDeclaredMethod(field.getName());
				} else {
					method = object.getClass().getDeclaredMethod("get" + Utilities.firstCharatereUpperCase(field.getName()));
				}
				toString += Utilities.firstCharatereUpperCase(field.getName() + ": " + method.invoke(object).toString() + ". ");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return toString;
	}
}
