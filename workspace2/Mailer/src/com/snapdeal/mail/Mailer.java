package com.snapdeal.mail;

import java.util.Set;

import org.hibernate.SessionFactory;

public interface Mailer {

	/*
	 * Sends mail to each id present in participantList. Assumes each id to be
	 * present in the USERS table with randomly generated passwords.
	 */
	void sendMail(Set<String> participantsSet, SessionFactory factory);
}
