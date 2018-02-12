//add https://bintray.com/natanbc/maven/discordbots-api as a dependency

import com.github.natanbc.discordbotsapi.BotInfo;
import com.github.natanbc.discordbotsapi.BotStats;
import com.github.natanbc.discordbotsapi.DiscordBotsAPI;
import com.github.natanbc.discordbotsapi.Search;
import com.github.natanbc.discordbotsapi.Sort;
import com.github.natanbc.discordbotsapi.UserInfo;

import java.util.stream.Stream;

public class StatsPoster {
    private final DiscordBotsAPI api;

    public StatsPoster(String DBLAPIKEY, long DISCORDBOTID) {
        this.api = new DiscordBotsAPI.Builder()
                .setToken(DBLAPIKEY)
                .setBotClientId(DISCORDBOTID)
                .setCallSiteTrackingEnabled(true) // Useful for debugging async requests
                .build();
    }

    public void postStats(int shardId, int shardTotal, int guildCount) {
        //there's no real reason to wait until the request is done
        api.postStats(shardId, shardTotal, guildCount).async();
    }

    public void postStats(int guildCount) {
        //there's no real reason to wait until the request is done
        api.postStats(guildCount).async();
    }


    public long[] getUpvoterIds() {
        return api.getUpvoterIds().execute();
    }

    public long[] getUpvoterIdsInTheLastDays(int days /* must be in the range [0, 31] (inclusive) */) {
        //we have to trick the compiler here ¯\_(ツ)_/¯
        return api.getUpvotersIds((Integer)days).execute();
    }

    //BELOW HERE TOKEN IS NOT NEEDED
    //other API endpoints

    public BotInfo getBotById(long id) {
        //block the current thread until the request is done
        return api.getBot(id).execute();
    }

    public BotStats getBotStatsById(long id) {
        return api.getBotStats(id).execute();
    }

    public UserInfo getUserById(long id) {
        return api.getUser(id).execute();
    }

    //index() uses the search endpoint under the hoods, but handles pagination
    
    public Stream<BotInfo> getCertifiedBotsWithMultipleOwners() {
        return api.index(new Search.Builder()
                .certified(true)
                .build()
        ).stream().filter(bot->bot.getOwners().length > 1);
    }
    
    public Iterable<BotInfo> getMusicBotsOrderedByName() {
        return api.index(
                Sort.byUsername().reverse(),
                new Search.Builder()
                    .withTags(new String[]{"music"})
                    .build()
        );
    }
}

