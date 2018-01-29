/*
Gradle Imports:
    compile "com.squareup.okio:okio:1.13.0"
    compile 'com.squareup.okhttp3:okhttp:3.9.1'

Maven Imports:
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>3.9.1</version>
    </dependency>
    <dependency>
        <groupId>com.squareup.okio</groupId>
        <artifactId>okio</artifactId>
        <version>1.13.0</version>
    </dependency>
*/
private static final OkHttpClient client = new OkHttpClient();
    
    public static void updateServerCount(DiscordApi api) {
        String apikey = "DBLAPIKEY";
        String botId = "Your BotID goes here";

        int serverCount = api.getServers().size();

        JSONObject count = new JSONObject()
                .put("server_count", serverCount);

        try {
            client.newCall(new Request.Builder()
                    .url("https://discordbots.org/api/bots/" + botId + "/stats")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", apikey)
                    .post(RequestBody.create(MediaType.parse("application/json"), count.toString()))
                    .build()
            ).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Listeners
api.addServerLeaveListener(event -> updateServerCount(api));
api.addServerJoinListener(event -> updateServerCount(api));
