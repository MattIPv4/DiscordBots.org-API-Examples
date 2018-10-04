# Warning: this repository is abandoned
 Please consider using [discordlists.py](https://github.com/MattIPv4/discordlists.py/) to send your server/guild counts to bot lists (including DiscordBots.org). discordlists.py is also available on [PyPi](https://pypi.org/project/discordlists.py/).

# DiscordBots.org Bot Stats API Examples

All files are organised as so: `/{language}/{library}/Example-{type}.{ext}` or in the event no Discord API library is used: `/{language}/Example-{type}.{ext}`.

In every example `DBLAPIKEY` is used to represent where your DiscordBots.org bot api key needs to added (replace the placeholder with your key).

If a Discord API library is not used `DISCORDBOTID` is used to indicate your bot ID and the file will be clearly commented to indicate where a guild count should go.

For a full and quick access list of all examples we have please read [EXAMPLES](EXAMPLES.md)

Types:
* NoShards - Example written to only post guild count without shards.
* Shards - Supports bots that are using shards.
* All - Supports both sharded and non-sharded bots.

## Contributing
Please read [CONTRIBUTING](CONTRIBUTING.md)
