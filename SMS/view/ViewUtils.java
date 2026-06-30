package com.sms.view;

import java.awt.Component;

import javax.swing.JOptionPane;

public class ViewUtils {
	public ViewUtils() {		
	}
	
	public static void showMessage(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message);
	}
}
