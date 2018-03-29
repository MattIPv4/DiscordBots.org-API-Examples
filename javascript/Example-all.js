/**
 * You must install https://www.npmjs.com/package/dblposter first!
 */

const dblposter = require("dblposter");

/**
 * `client` must be your client instance
 */
const dbl = new dblposter(client, DBLAPIKEY);

// Binds the client to the internal timer
dbl.bind();
