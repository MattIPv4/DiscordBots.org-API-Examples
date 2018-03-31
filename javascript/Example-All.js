/**
 * You must install https://www.npmjs.com/package/dblposter first!
 */

const dblposter = require("dblposter");

/**
 * `client` must be your client instance
 * After this, you are able to access this instance anywhere with <client>.dblPoster
 * or whatever value you chose when binding the poster to your client.
 */
const dbl = new dblposter(client, "DBLAPIKEY");

// Binds the client to the internal timer
// You can also pass in a custom name for the value that will get bound to the client.
dbl.bind();

// If you want to manually trigger a statistics post, for some reason.
dbl.post();
