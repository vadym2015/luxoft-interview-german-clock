package net.interview;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.response.NotFoundException;

/**
 * Defines v1 of API
 */
@Api(name = "helloworld", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
		Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
		Constants.IOS_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE })
public class Greetings {

	public GermanTime getGermanTime() throws NotFoundException {
		GermanTime response = GermanTimeUtil.getGermanTime(LocalTime.now(DateTimeZone.forID("Europe/Kiev")));
		return response;
	}

}
