package com.bayviewglen.firstArrays;

public class ContactNode {
	private Contact data;
	private ContactNode link;
	
	public ContactNode(Contact data, ContactNode link) {
		
	}

	public Contact getData() {
		return data;
	}

	public void setData(Contact data) {
		this.data = data;
	}

	public ContactNode getLink() {
		return link;
	}

	public void setLink(ContactNode link) {
		this.link = link;
	}

}
