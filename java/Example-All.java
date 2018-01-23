import com.github.natanbc.discordbotsapi.BotInfo;
import com.github.natanbc.discordbotsapi.BotStats;
import com.github.natanbc.discordbotsapi.DiscordBotsAPI;
import com.github.natanbc.discordbotsapi.Search;
import com.github.natanbc.discordbotsapi.UpvoterInfo;
import com.github.natanbc.discordbotsapi.UserInfo;
import okhttp3.OkHttpClient;

import java.util.stream.Stream;

public class StatsPoster {
    private final DiscordBotsAPI api;

    public StatsPoster(String DBLAPIKEY, long DISCORDBOTID) {
        this.api = new DiscordBotsAPI(new OkHttpClient(), DBLAPIKEY, DISCORDBOTID);
    }

    public void postStats(int shardId, int shardTotal, int guildCount) {
        api.postStats(shardId, shardTotal, guildCount);
    }

    public void postStats(int[] guildCounts) {
        api.postStats(guildCounts);
    }

    public long[] getUpvoterIds() {
        return api.getUpvoterIds();
    }
    
    public UpvoterInfo[] getUpvoters() {
        return api.getUpvoters();
    }
    
    //the following methods don't require a token
    
    public BotInfo getBotInfo(long id) {
        return api.getBot(id);
    }
    
    public BotStats getBotStats(long id) {
        return api.getBotStats(id);
    }
    
    public UserInfo getUserInfo(long id) {
        return api.getUser(id);
    }
    
    
    //just an example of search
    public BotInfo[] getCertifiedBotsOwnedBy(long ownerId) {
        return api.search(new Search.Builder()
                .certified(true)
                .ownedBy(ownerId)
                .build()
        );
    }
    
    public Stream<BotInfo> getBotsWithMoreThan100Upvotes() {
        return api.index().stream().filter(b->b.getPoints() > 100);
    }
}
