import json
import aiohttp
import logging

class DiscordBotsOrgAPI:
    def __init__(self, bot):
        self.bot = bot
        self.session = aiohttp.ClientSession(loop=self.bot.loop)
        
    def __unload(self):
        self.bot.loop.create_task(self.session.close())
        
    async def send(self):
        payload = json.dumps({
            'server_count': len(self.bot.guilds)
        })
        head = {
            'Authorization': 'DBLAPIKEY',
            'Content-type' : 'application/json'
        }

        url = '{}/bots/{}/stats'.format('https://discordbots.org/api', self.bot.user.id)

        async with self.session.post(url, data=payload, headers=head) as resp:
        if req.status == 200:
            logging.info('poster[dbl]: done')
        else:
            t = await req.text()
            logging.error('poster[dbl]: failed (code {})'.format(req.status))
            logging.error('poster[dbl]: response: {}'.format(t))
        
    async def on_guild_join(self, guild):
        await self.update()
        
    async def on_guild_remove(self, guild):
        await self.update()
        
    async def on_ready(self):
        await self.update()
        
def setup(bot):
    bot.add_cog(DiscordBotsOrgAPI(bot))
