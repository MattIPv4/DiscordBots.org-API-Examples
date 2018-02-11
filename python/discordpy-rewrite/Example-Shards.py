import json
import aiohttp
import logging

class DiscordBotsOrgAPI:
    def __init__(self, bot):
        self.bot = bot
        self.session = aiohttp.ClientSession(loop=self.bot.loop)
        self.key = 'DBLAPIKEY'
        
    def __unload(self):
        self.bot.loop.create_task(self.session.close())
        
    async def update(self):
        payload = json.dumps({
            'shard_id': self.bot.shard_id,
            'shard_count': self.bot.shard_count,
            'server_count': len(self.bot.guilds)
        })
        head = {
            'Authorization': self.key,
            'Content-type' : 'application/json'
        }

        url = f'https://discordbots.org/api/bots/{self.bot.user.id}/stats'

        async with self.session.post(url, data=payload, headers=head) as req:
            if req.status == 200:
                logging.info('poster[dbl]: done')
            else:
                t = await req.text()
                logging.error(f'poster[dbl]: failed (code {req.status})')
                logging.error('poster[dbl]: response: {t}')
        
    async def on_guild_join(self, guild):
        await self.update()
        
    async def on_guild_remove(self, guild):
        await self.update()
        
    async def on_ready(self):
        await self.update()
        
def setup(bot):
    bot.add_cog(DiscordBotsOrgAPI(bot))
