# Contributing

## General PR Guidelines
* The code submitted should run correctly and follow the best programming standards for that language
* Use `DBLAPIKEY` to represent the DiscordBots.org bot api key.
* If not using a Discord API library: Use `DISCORDBOTID` for the bot ID and ensure guild count is clearly marked.
* If using a Discord API library: No other information should be required from the bot owner, use your library to get bot id etc.

## Adding new examples
If you wish to help, please follow the following when creating a PR:
* Example file should be added in the correct folder location (see above)
* The example relies on standard libraries in your language, and if using a Discord API, preferably the same http client as the Discord API lib uses.
* Any examples from your langauge/library combination should be removed from the relevant to-be-processed file if applicable.
