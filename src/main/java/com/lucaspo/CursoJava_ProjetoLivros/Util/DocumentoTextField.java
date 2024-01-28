package com.lucaspo.CursoJava_ProjetoLivros.Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocumentoTextField extends PlainDocument {
	int maximo;

	public DocumentoTextField(int max){
	    maximo = max;
	  }

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if ((getLength() + str.length()) <= maximo)
			super.insertString(offs, str, a);
	}

}
