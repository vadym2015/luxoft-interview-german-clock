/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 */

/** google global namespace for Google projects. */
var google = google || {};

/** devrel namespace for Google Developer Relations projects. */
google.devrel = google.devrel || {};

/** samples namespace for DevRel sample code. */
google.devrel.samples = google.devrel.samples || {};

/** hello namespace for this sample. */
google.devrel.samples.hello = google.devrel.samples.hello || {};

/**
 * Client ID of the application (from the APIs Console).
 * 
 * @type {string}
 */
google.devrel.samples.hello.CLIENT_ID = '232037506227-vq367u2c1nc5bbbpjncevqko6hs4m9v2.apps.googleusercontent.com';

/**
 * Scopes used by the application.
 * 
 * @type {string}
 */
google.devrel.samples.hello.SCOPES = 'https://www.googleapis.com/auth/userinfo.email';

/**
 * Whether or not the user is signed in.
 * 
 * @type {boolean}
 */
google.devrel.samples.hello.signedIn = false;

/**
 * Started or not
 * 
 * @type {boolean}
 */
google.devrel.samples.hello.started = false;

/**
 * Loads the application UI after the user has completed auth.
 */
google.devrel.samples.hello.userAuthed = function() {
	var request = gapi.client.oauth2.userinfo.get().execute(function(resp) {
		if (!resp.code) {
			google.devrel.samples.hello.signedIn = true;
			document.getElementById('signinButton').innerHTML = 'Sign out';
			document.getElementById('authedGreeting').disabled = false;
		}
	});
};

/**
 * Handles the auth flow, with the given value for immediate mode.
 * 
 * @param {boolean}
 *            mode Whether or not to use immediate mode.
 * @param {Function}
 *            callback Callback to call on completion.
 */
google.devrel.samples.hello.signin = function(mode, callback) {
	gapi.auth.authorize({
		client_id : google.devrel.samples.hello.CLIENT_ID,
		scope : google.devrel.samples.hello.SCOPES,
		immediate : mode
	}, callback);
};

/**
 * Presents the user with the authorization popup.
 */
google.devrel.samples.hello.auth = function() {
	if (!google.devrel.samples.hello.signedIn) {
		google.devrel.samples.hello.signin(false,
				google.devrel.samples.hello.userAuthed);
	} else {
		google.devrel.samples.hello.signedIn = false;
		document.getElementById('signinButton').innerHTML = 'Sign in';
		document.getElementById('authedGreeting').disabled = true;
	}
};

/**
 * Handles the auth flow, with the given value for immediate mode.
 * 
 * @param {boolean}
 *            mode Whether or not to use immediate mode.
 * @param {Function}
 *            callback Callback to call on completion.
 */
google.devrel.samples.hello.startClock = function() {
	if (!google.devrel.samples.hello.started) {
		google.devrel.samples.hello.intervalVariable = setInterval(function () {google.devrel.samples.hello.updateTime()}, 1000);
		google.devrel.samples.hello.started = true;
		document.getElementById('startButton').innerHTML = 'Stop clock';
	} else {
		google.devrel.samples.hello.started = false;
		clearInterval(google.devrel.samples.hello.intervalVariable);
		document.getElementById('startButton').innerHTML = 'Start clock';
	}
};

/**
 * Retrieves data from gae and update form
 */
google.devrel.samples.hello.updateTime = function() {
	gapi.client.helloworld.greetings.getGermanTime().execute(function(resp) {
		if (!resp.code) {
			$("[id^=row]").removeClass("red");
			$("[id^=row]").removeClass("yellow");
			$("#circle").removeClass("yellow");
			
			if (resp.seconds % 2 == 0) {
				$("#circle").addClass("yellow");
			}
			
			if (resp.fiveHours > 0) {
				for (var i = 1; i <= resp.fiveHours; i++) {
					$("#row-1-" + i).addClass("red");
				}
			}
			if (resp.singleHours > 0) {
				for (var i = 1; i <= resp.singleHours; i++) {
					$("#row-2-" + i).addClass("red");
				}
			}
			if (resp.fiveMinutes > 0) {
				for (var i = 1; i <= resp.fiveMinutes; i++) {
					if (i % 3 == 0) {
						$("#row-3-" + i).addClass("red");
					} else {
						$("#row-3-" + i).addClass("yellow");
					}
				}
			}
			if (resp.singleMinutes > 0) {
				for (var i = 1; i <= resp.singleMinutes; i++) {
					$("#row-4-" + i).addClass("yellow");
				}
			}
		} else {
			window.alert(resp.message);
		}
	});
};

/**
 * Enables the button callbacks in the UI.
 */
google.devrel.samples.hello.enableButtons = function() {
	document.getElementById('signinButton').onclick = function() {
		google.devrel.samples.hello.auth();
	}

	document.getElementById('startButton').onclick = function() {
		google.devrel.samples.hello.startClock();
	}

};

/**
 * Initializes the application.
 * 
 * @param {string}
 *            apiRoot Root of the API's path.
 */
google.devrel.samples.hello.init = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			google.devrel.samples.hello.enableButtons();
			google.devrel.samples.hello.signin(true,
					google.devrel.samples.hello.userAuthed);
		}
	}

	apisToLoad = 2; // must match number of calls to gapi.client.load()
	gapi.client.load('helloworld', 'v1', callback, apiRoot);
	gapi.client.load('oauth2', 'v2', callback);
};
